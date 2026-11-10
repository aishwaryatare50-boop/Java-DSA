package OOPS;
class Pen {
    // Data or properties
    String color;
    String type; // ballpoint, gel

    // Members
    public void write() {
        System.out.println("write something");
    }

    public void printColor() {
        System.out.println(this.color);
    }

    public void printType() {
        System.out.println(this.type);
    }
}

class Course {
    String name;
    String[] subjects = new String[5];

    public void printInfo() {
        System.out.println(this.name);
        for(int i=0; i<5; i++) {
            System.out.println(this.subjects[i] + " ");
        }
    }

    Course() {
        this.name = "";
        for(int i=0; i<5; i++) {
            subjects[i] = "";
        }
    }
    Course(Course c) {
        this.name = c.name;
        this.subjects = c.subjects;
    }
}
class Student {
    String name;
    static String school;
    int age;

    public static void changeSchool() {
        school = "newSchool";
    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    // Non-Parameterized Constructor
    Student() {
        System.out.println("Constructor Called");
    }

    // Parameterized Constructor
    
    Student(String name, int age) {
    this.name = name;
    this.age = age;
    }
    

    // Copy Constructor->this copy constructor creates a shallow copy
    Student(Student s2) {
        this.name = s2.name;
        this.age = s2.age;
    }
}

public class OOPS {
    public static void main(String args[]) {
        Pen pen1 = new Pen();
        pen1.color = "blue";
        pen1.type = "gel";

        Pen pen2 = new Pen();
        pen2.color = "black";
        pen2.type = "ballpoint";

        pen1.write();
        pen1.printColor();
        pen1.printType();

        pen2.write();
        pen2.printColor();
        pen2.printType();

        Student.school = "JMV";

        Student s1 = new Student(); // constructors
        s1.name = "Aman";
        s1.age = 19;

        Student s2 = new Student(); // Constructors
        // Student s1 = new Student("aman", 24); // Parameterized constructor
        s2.name = "Aishwarya";
        s2.age = 19;

        // Copy Constructor
        Student s3 = new Student(s2);   // Constructor Overloading
        s3.printInfo();
        
        s1.printInfo();
        s2.printInfo();
        // System.out.println(s2.school); this shows error because we must use it statically

        // Parameterized constructor
        Student s4 = new Student("Aditya", 20);
        s4.printInfo();

        Course c1 = new Course();
        c1.name = "Computer Science and Engineering";
        c1.subjects[0] = "Theory of Computation";
        c1.subjects[1] = "Object Oriented Programming and Methodology";
        c1.subjects[2] = "Discrete Mathematices";
        c1.subjects[3] = "Data Structures";
        c1.subjects[4] = "Java";

        c1.printInfo();

        Course c2 = new Course(c1);
        c2.printInfo();
        c2.subjects[4] = "C++";

        c1.printInfo(); // This occurs due to shallow copy
        c2.printInfo();

        System.out.println(c1.subjects);// Both c1 and c2 are arrays which refer to same memory location therefore, when we change c2 it reflects in c1.
        System.out.println(c2.subjects);// To solve this problem we must manually create a new memory location for c2.

    }
}