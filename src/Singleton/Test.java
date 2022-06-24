package Singleton;

public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Singleton.getInstance().doSomething();
            }
        };
        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(runnable);
        firstThread.start();
        secondThread.start();
    }
}
