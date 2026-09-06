package oops;

public class constructor {
    void main() {
        Animal a1=new Animal();
        System.out.println("Values with default constructor -");
        System.out.println();
        System.out.println(a1.name); // null
        System.out.println(a1.age);  // 0
        System.out.println(a1.color);// null

        System.out.println();
        System.out.println("Values with parameterized constructor");
        System.out.println();
        Animal a2=new Animal("Tiger" ,7 , "yellow");
        System.out.println(a2.name);
        System.out.println(a2.age);
        System.out.println(a2.color);
    }

    class Animal{
        String name;
        int age;
        String color;

        Animal(String n , int a , String c){  // parameterized constructor
            name=n;
            age=a;
            color=c;
        }
        // constructor overloading - class ke andr ek aur constructor but with different parameter

        Animal(){
            // default constructor
        }
    }
}
