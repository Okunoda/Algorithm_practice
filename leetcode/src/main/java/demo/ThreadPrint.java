package demo;

public class ThreadPrint {
    private static final Object lock = new Object();
    private static volatile Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> print("A", 0)).start();
        new Thread(() -> print("B", 1)).start();
        new Thread(() -> print("C", 2)).start();

        Thread.sleep(1000);
        System.out.println("success");
    }


    /**
     * 三个线程，首先每个线程需要去获取count，判断是否应当自己打印，获取的时候涉及到可见性，应当用volatile，
     * 如果是属于当前线程应该打印的，那么就直接打印，然后加锁进行值的增加，因为volatile没有原子性，可能会导致写丢失
     *
     * @param threadName
     * @param value
     */
    private static void print(String threadName, Integer value) {
        Thread.currentThread().setName(threadName);
        while (true) {
            synchronized (lock) {
                if(count > 100){
                    lock.notifyAll();
                    return;
                }
                if (count % 3 == value) {
                    System.out.println(Thread.currentThread().getName() + "\t" + count);
                    try {
                        count++;
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } /*else {
                    //如果不属于当前线程打印的，那么就将线程阻塞，否则死循环会导致浪费CPU时间片
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }*/
            }
        }
    }

}
