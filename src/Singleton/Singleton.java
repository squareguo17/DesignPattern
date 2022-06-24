package Singleton;

public class Singleton {
    // volatile一定要, 解决双重校验场景下编译器重排序带来的线程安全问题
    // 具体见:https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
    private static volatile Singleton sInstance;

    public static Singleton getInstance() {
        if (sInstance == null) {
            synchronized (Singleton.class) {
                if (sInstance == null) {
                    sInstance = new Singleton();
                }
            }
        }
        return sInstance;
    }

    public void doSomething() {
        System.out.println("Instance addr:" + sInstance);
    }

    private Singleton() {
        // 初始化代码
    }
}