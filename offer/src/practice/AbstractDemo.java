package practice;

/**
 * @author Okunoda
 * @date 2023年03月14日15:13
 */
public abstract class AbstractDemo {
    private int a;
    protected int b;
    int c;
    public int d;
    public AbstractDemo(){
        a = 1;
        b = 2;
        c = 3;
        d = 4;
    }

    private void method1(){
        System.out.println("hello method 1");
    }

    protected void method2(){
        System.out.println("hello method 2");
    }

    void method3(){
        System.out.println("hello method 3");
    }

    public void method4(){
        System.out.println("hello method 4");
    }

    abstract void method5();

}
