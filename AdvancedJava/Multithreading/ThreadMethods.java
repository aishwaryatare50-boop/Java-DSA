package AdvancedJava.Multithreading;

class MyNewThread extends Thread {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Id = " + this.threadId());
            try {
                Thread.sleep(455);
            } catch(Exception e) {
                System.out.println(e);
            }
           
        }
    }
}

public class ThreadMethods {
    public static void main(String[] args) {
        MyNewThread t1 = new MyNewThread();
        MyNewThread t2 = new MyNewThread();
        t1.start();

        try {
            t1.join();
        } catch(Exception e) {
            System.out.println(e);
        }

        t2.start();
    }
}
