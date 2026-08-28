package functions;

public class types_of_functions {
    static void main() {   // main function is also a function from where jvm starts executing java code
        greet();
        System.out.println(getnum());
        sayhello("Yash");
        System.out.println(product(5,6));

    }
    // we will cover 4 types of fxn based on i/p , o/p

    // 1) no input , no output(no return)

    static void greet(){
        System.out.println("Hello ");
    }

    // 2) no input , output

    static int getnum(){
        return 10;
    }

    // 3) input , no output

    static void sayhello(String name){
        System.out.println("Hello "+ name);
    }

    // 4) input , output

    static int product(int a , int b){

        return (a*b);
    }
}
