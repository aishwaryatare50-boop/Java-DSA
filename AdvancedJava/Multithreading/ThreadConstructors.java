package AdvancedJava.Multithreading;

class MyThr extends Thread {
    public MyThr(String name) {
        super(name);
    }

    public void run() {
        for(int i=0; i<400; i++) {
            System.out.println("I am a thread");
        }
    }
}

public class ThreadConstructors {
    public static void main(String[] args) {
        MyThr t1 = new MyThr("Aman");
        MyThr t2 = new MyThr("Shradha");

        t1.start();
        t2.start();

        System.out.println("The id of the thread is " + t1.threadId());
        System.out.println("The name of thread is " + t1.getName());

        System.out.println("The id of the thread is " + t2.threadId());
        System.out.println("The name of thread is " + t2.getName());

    }
}
