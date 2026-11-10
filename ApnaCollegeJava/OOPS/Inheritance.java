package OOPS;

import java.util.*; // import all the classes of java.util package
// is a built in package which contains all the collection classes like ArrayList, LinkedList, HashMap, HashSet, and utility functions etc.

class Shape { // Base class
    String color;

    public void area() {
        System.out.println("display area");
    }
}

class Triangle extends Shape { // Single Inheritance
    public void area(int l, int h) { // Run-time polymorphism : the method to run is decided at runtime, depending on the actual object being used — even if the reference type is of the parent class.
        System.out.println(0.5 * l * h);
    }
}

class EquilateralTriangle extends Triangle { // Multilevel Inheritance
    public void area(int l, int h) { // method-overriding
        System.out.println(0.5 * l * h);
    }
}

class Circle extends Shape { // Hierarchical Inheritance
    public void area(int r) {
        System.out.printf("%.2f \n",Math.PI * r * r);
    }
}
public class Inheritance {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        Triangle t1 = new Triangle();
        t1.color = "red";

        Circle c1 = new Circle();
        c1.area(5);
        
        Shape c2 = new Circle();
        c2.area();
    }
}
// In java there is no multiple inheritance like C++ instead we use interfaces.
// In java there is also another type of inheritance called Hybrid Inheritance which is a combination of two or more types of inheritance.