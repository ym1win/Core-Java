package functions;

public class chaining_of_fxn {

    // Function 1
    static void function1() {
        System.out.println("Inside Function 1");

        // Function 1 calls Function 2
        function2();

        // Control comes back here after Function 2 finishes
        System.out.println("Back in Function 1");
    }

    // Function 2
    static void function2() {
        System.out.println("Inside Function 2");

        // Function 2 calls Function 3
        function3();

        // Control comes back here after Function 3 finishes
        System.out.println("Back in Function 2");
    }

    // Function 3
    static void function3() {
        System.out.println("Inside Function 3");

        // Function 3 finishes here
        // Control returns to Function 2
    }

    public static void main(String[] args) {

        System.out.println("Inside Main");

        // Main calls Function 1
        function1();

        // Control comes back here after Function 1 finishes
        System.out.println("Back in Main");
    }

}
