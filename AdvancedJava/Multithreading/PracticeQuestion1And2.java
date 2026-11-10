package AdvancedJava.Multithreading;

class MyThreadPQ1 extends Thread {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Good morning");
        }
    }
}

class MyThreadPQ2 extends Thread {
    public void run() {
        try {
            Thread.sleep(200);
            for(int i=0; i<10; i++) {
                System.out.println("Welcome");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class PracticeQuestion1And2 {
    public static void main(String[] args) {
        MyThreadPQ1 t1 = new MyThreadPQ1();
        MyThreadPQ2 t2 = new MyThreadPQ2();

        t1.setPriority(6);
        t2.setPriority(9);

        t1.start();
        t2.start();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(Thread.currentThread());
    }
}
