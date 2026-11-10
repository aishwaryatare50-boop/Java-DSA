package OOPS;
class Students {
    String name;
    int age;

    public void printInfo(String name) { // Function overloading : same name for different functions
        System.out.println(name);
    }

    public void printInfo(int age) {
        System.out.println(age);
    }

    public void printInfo(String name, int age) {
        System.out.println(name + " " + age);
    }

    public void printInfo(Students s) {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

// There are two types of polymorphism in java run-time polymorphism and compile-time polymorphism.

// Compile-time polymorphism
public class Polymorphism {
    public static void main(String args[]) {
        Students s1 = new Students();
        s1.name = "aman";
        s1.age = 24;

        Students s2 = new Students();
        s2.name = "Aishwarya";
        s2.age = 19;

        s1.printInfo(s1.name, s1.age);
        s2.printInfo(s2.age);
        s2.printInfo((s2.name));
        s1.printInfo(s1.name);
        s2.printInfo(s2);
        s1.printInfo(s1);
    }
}
// the method to run is decided at compile time — based on the method’s parameters.