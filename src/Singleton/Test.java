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

        // 预期10个线程打印出来的实例对象都是一致的
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
