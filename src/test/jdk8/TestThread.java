package test.jdk8;

/**
 * Created by Jun on 2017/7/20.
 */
public class TestThread {
    public static void main(String ... args){
        System.out.println(111);
        Thread t1 = new Thread(() -> System.out.println("Hello world1"));
        t1.run();
        Thread t2 = new Thread(() -> System.out.println("Hello world2"));
        t2.run();
        Thread t3 = new Thread(() -> System.out.println("Hello world3"));
        t3.run();
    }
}
