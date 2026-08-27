package functions;

public class function_overloading {

    // 1. Overloading by changing the NUMBER of parameters
    static void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    static void add(int a, int b, int c) {
        System.out.println("Sum = " + (a + b + c));
    }


    // 2. Overloading by changing the DATA TYPE of parameters
    static void display(int a) {
        System.out.println("Integer value = " + a);
    }

    static void display(double a) {
        System.out.println("Double value = " + a);
    }

    // 3. Overloading by changing the ORDER of parameters
    static void show(int a, String name) {
        System.out.println("Number = " + a + ", Name = " + name);
    }

    static void show(String name, int a) {
        System.out.println("Name = " + name + ", Number = " + a);
    }


    public static void main(String[] args) {

        // Calling overloaded add() methods
        add(10, 20);          // Calls add(int, int)
        add(10, 20, 30);      // Calls add(int, int, int)

        // Calling overloaded display() methods
        display(100);         // Calls display(int)
        display(10.5);        // Calls display(double)

        // Calling overloaded show() methods
        show(101, "Rahul");   // Calls show(int, String)
        show("Rahul", 101);   // Calls show(String, int)

        // NOT valid overloading
//        int add(int a, int b) { ... }
//        double add(int a, int b) { ... }  // Compile-time error

    }
}
