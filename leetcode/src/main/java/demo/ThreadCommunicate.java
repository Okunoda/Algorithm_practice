package demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCommunicate {
    public static void main(String[] args) throws InterruptedException {
        ShardingBuffer buffer = new ShardingBuffer(5);
        AtomicInteger i = new AtomicInteger(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(i.get()<=0)
                        return;

                    while(i.get()> 0){
                        buffer.produce(String.valueOf(i.get()));
                        i.decrementAndGet();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(i.get()<=0)
                        return;

                    while(i.get()> 0){
                        String consume = buffer.consume();
                        System.out.println(Thread.currentThread().getName() + "\t" + consume);
                    }
                }
            }
        }).start();

        Thread.sleep(1000);
    }

    static class ShardingBuffer{
         private final Queue<String> queue ;
         private final Integer maxCapacity;

         public ShardingBuffer(Integer capacity){
            this.maxCapacity = capacity;
            this.queue = new LinkedList<>();
         }

         public synchronized void produce(String production){
             while(queue.size() == this.maxCapacity){
                 System.out.println("缓存区容量达到最大值，等待消费者消费.....");
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }

             queue.add(production);
             System.out.println("生产者产生了一个对象");
             notify();//唤醒消费者
             try {
                 wait();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }

         public synchronized String consume(){
             while(queue.isEmpty()){
                 System.out.println("缓存区容量为空，等待生产者生产.....");
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }

             String poll = queue.poll();
             System.out.println("消费者消费了一个对象");
             notify();//唤醒生产者
             try {
                 wait();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             return poll;
         }
    }

}