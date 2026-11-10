package AdvancedJava.Multithreading;

class MyThr1 extends Thread {
    public MyThr1(String name) {
        super(name);
    }

    public void run() {
        for(int i=0; i<500; i++) {
            System.out.println("Id = " + this.threadId() + " Name = " + this.getName());
        }
    }
}

public class ThreadPriorities {
    public static void main(String[] args) {
        MyThr1 t1 = new MyThr1("t1");
        MyThr1 t2 = new MyThr1("t2");
        MyThr1 t3 = new MyThr1("t3");
        MyThr1 t4 = new MyThr1("t4");
        MyThr1 t5 = new MyThr1("t5 (most important)");

        t5.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
