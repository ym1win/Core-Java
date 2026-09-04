package oops;

public class call_by_value {

    public static void main(String[] args) {

        // x aur y main() method ke local variables hain
        int x = 4;
        int y = 5;

        // addten() call karne se pehle original values
        System.out.println("Before method call:");
        System.out.println(x + " " + y); // Output: 4 5


        /*
         * Jab hum addten(x, y) call karte hain,
         * Java x aur y ki VALUES ki copies method ko deta hai.
         *
         * Original x aur y directly method ke paas nahi jaate.
         */
        addten(x, y);


        /*
         * addten() ke andar x aur y ki copies change hui thi.
         *
         * Original x = 4 aur y = 5 change nahi hue.
         */
        System.out.println("After method call:");
        System.out.println(x + " " + y); // Output: 4 5
    }


    static void addten(int x, int y) {
        /*
         * Ye x aur y, main() wale x aur y nahi hain.
         *
         * Ye unki COPIES hain:
         *
         * main()             addten()
         * x = 4  --------->   x = 4 (copy)
         * y = 5  --------->   y = 5 (copy)
         */

        // Sirf copied x change hoga
        x = x + 10;

        // Sirf copied y change hoga
        y = y + 10;

        // Method ke andar output: 14 15
        System.out.println("Inside addten():");
        System.out.println(x + " " + y);
    }
}