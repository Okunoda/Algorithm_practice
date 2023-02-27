package practice;

/**
 * @author Okunoda
 * @date 2023年02月26日12:35
 */
public class thread {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "正在运行");
            Test t = new Test();
            System.out.println(Thread.currentThread().getName()+"结束");
        };
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");
        t1.start();
        t2.start();


    }

}
    class Test {
        static {
            if (true) {
                System.out.println("初始化");
//                while (true) {
//                }

            }
        }
    }
