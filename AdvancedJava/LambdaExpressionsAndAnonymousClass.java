package AdvancedJava;

interface DemoAno {
    public void method1();
    public void method2();
}

class AnonyDemo implements DemoAno {
    public void display() {
        System.out.println("Hello");
    }

    @Override
    public void method1() {
        System.out.println("I am method 1");
    }

    @Override
    public void method2() {
        System.out.println("I am method 2");
    } 
}

@FunctionalInterface
interface DemoInterface {
    public void method1();
}

class DemoClass implements DemoInterface {
    @Override
    public void method1() {
        System.out.println("I am method 1");
    }
}

public class LambdaExpressionsAndAnonymousClass {
    public static void main(String[] args) {
        AnonyDemo obj = new AnonyDemo();
        obj.method1();

        // Anonymous Class
        DemoAno obj2 = new DemoAno() {
            @Override
            public void method1() {
                System.out.println("I am method 1");
            }

            @Override
            public void method2() {
                System.out.println("I am method 2");
            }
        };

        obj2.method1();

        DemoAno obj3 = new AnonyDemo();
        obj3.method1();


        // Lambda Expressions
        DemoInterface obj4 = new DemoClass();
        obj4.method1();

        DemoInterface obj5 = () -> {
            System.out.println("I am method 1 from this lambda expressions");
        };

        obj5.method1();
    }
}