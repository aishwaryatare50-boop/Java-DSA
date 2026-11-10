package OOPS;

// Abstraction is not pure here.
// Abstract class
abstract class Animal { // only a concept 
    abstract void walk(); // abstract method
    public void eat() { // non-abstract method
        System.out.println("Animal eats");
    }

    Animal() { // Constructor chaining
        System.out.println("You are creating a new animal.");
    }
}

class Horse extends Animal {
    public void walk() {
        System.out.println("Walk on 4 legs");
    }
    Horse() {
        System.out.println("Created a horse");
    }
}

class Chicken extends Animal {
    public void walk() {
        System.out.println("Walks on 2 legs");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Horse horse1 = new Horse();
        horse1.walk();
        horse1.eat();
    }
}

// for pure abstraction we use interfaces

interface Animals {
    int eyes = 2;
    void walk();
}

// for multiple inheritance in java we use interfaces 
// Multiple inheritance : a sub class inherits two or more base classes i.e. interfaces

interface Herbivore {

}

class Horses implements Animals, Herbivore {
    public void walk() {
        System.out.println("walks on 4 legs");
    }
}