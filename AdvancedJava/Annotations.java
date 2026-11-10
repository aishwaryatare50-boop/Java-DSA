package AdvancedJava;

@FunctionalInterface
interface myFunctionalInterface {
    public void thisMethod();
}

class Phone {
    public void showTime() {
        System.out.println("Time");
    }

    public  void on() {
        System.out.println("Turning on phone...");
    }
}

class SmartPhone extends Phone {
    @Override
    public void showTime() {
        System.out.println("Time is 8 pm");
    }

    @Deprecated
    public int sum(int a, int b) {
        return a + b;
    }

}

public class Annotations {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();
        phone.showTime();
    
        System.out.println(phone.sum(6, 7));
    }
}