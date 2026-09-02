package oops;

public class constructor_chaining_and_this_keyword {
        void main() {
        Student s1=new Student();
        Student s2=new Student("Yash");
        Student s3=new Student("Krish" , 21);
        Student s4=new Student("Rahul", 22 , 102);
        Student s5=new Student("Mohan" , 25, 104 , "ABES");

    }

    class Student{
        String name;
        int age;
        int rollno;
        String clg;

        // constructor chaining ke liye pehle constructor overloading krni pdegi
        // no argument constructor

        Student(){

        }

//        //parameterized constructor with one argument
//        Student(String name){
//            this.name=name;   // use of this keyword to distinguish btw instance variable and parameter
//        }
//
//        //parameterized constructor with two argument
//        Student(String name, int age){
//            this.name=name;
//            this.age=age;
//        }
//
//        //parameterized constructor with three argument
//        Student(String name, int age ,int rollno){
//            this.name=name;
//            this.age=age;
//            this.rollno=rollno;
//        }
//
//        //parameterized constructor with four argument
//        Student(String name, int age ,int rollno , String clg){
//            this.name=name;
//            this.age=age;
//            this.rollno=rollno;
//            this.clg=clg;}

            // 2nd use of this keyword - ek constructor ke andr se dusre constructor ko call krna

        //parameterized constructor with one argument
        Student(String name){
            this(name ,0 ,0,null)  ; // aise krke ye automatically sbse bde waale constructor ko call
        }                                           // kr dega with default values

        //parameterized constructor with two argument
        Student(String name, int age){
           this(name , age , 0,null);
        }

        //parameterized constructor with three argument
        Student(String name, int age ,int rollno){
            this(name , age ,rollno , "ABES");
        }

        //parameterized constructor with four argument
        Student(String name, int age ,int rollno , String clg) {
            this.name = name;  // yha kuch ni krenge cuz ye already sbse bda constructor hai
            this.age = age;
            this.rollno = rollno;
            this.clg = clg;
        }
    }

}
