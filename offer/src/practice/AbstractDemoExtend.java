package practice;

/**
 * @author Okunoda
 * @date 2023年03月14日15:16
 */
public class AbstractDemoExtend extends AbstractDemo{

    @Override
    void method5() {
        super.method2();
        super.method3();
        super.method4();
    }

    public static void main(String[] args) {
        new AbstractDemoExtend().method5();
    }
}
