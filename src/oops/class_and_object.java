package oops;

public class class_and_object {

    class Student{
        String name;           //characteristics of a class
        int age ;
        int rollno;
        String clg;

        void markattendance(){ // behaviour of a class is represented through function
                               // koi paramter paas ni krna pda cuz class ke andr h function bna hai toh uske paas already access hai
            System.out.println("Attendace marked by - "+name); // name ka already access hai ki kya hoga
        }

        void print(){
            System.out.println("Name - "+name+" Age - "+age+" Rollno - "+rollno+" College - "+clg);
        }
    }// abhi sirf blueprint bni hai , koi memory allocate ni hui , uske liye main method ke andr object bnana hoga

        void main() {
        Student s1= new Student(); //by new keyword allocating memory in heap for that object s1 of class student
        Student s2= new Student();

        s1.name="yash";            //by using dot operator accessing characteristic field of an object
        s1.age=22;
        s1.rollno=291;
        s1.clg="abes";

        s2.name="rahul";
        s2.age=23;
        s2.rollno=289;
        s2.clg="abes";

        s1.markattendance();
        s1.print();
            System.out.println();
        s2.markattendance();
        s2.print();
    }
}
