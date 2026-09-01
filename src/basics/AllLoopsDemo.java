package basics;

public class AllLoopsDemo {

     static void main(String[] args) {

        // =====================================================
        // 1. FOR LOOP
        // =====================================================
        // Jab hume pata ho ki loop kitni baar chalana hai,
        // tab for loop ka use karte hain.

        System.out.println("FOR LOOP:");

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }


        // =====================================================
        // 2. WHILE LOOP
        // =====================================================
        // While loop mein condition pehle check hoti hai.
        // Agar condition true hai tabhi loop chalega.

        System.out.println("\nWHILE LOOP:");

        int i = 1;

        while (i <= 5) {
            System.out.println(i);
            i++;
        }


        // =====================================================
        // 3. DO-WHILE LOOP
        // =====================================================
        // Do-while loop mein condition baad mein check hoti hai.
        // Isliye loop kam se kam ek baar zaroor execute hota hai.

        System.out.println("\nDO-WHILE LOOP:");

        int j = 1;

        do {
            System.out.println(j);
            j++;
        } while (j <= 5);


        // =====================================================
        // 4. ENHANCED FOR LOOP / FOR-EACH LOOP
        // =====================================================
        // Array ya collection ke elements ko traverse karne
        // ke liye enhanced for loop ka use hota hai.

        System.out.println("\nENHANCED FOR LOOP:");

        int[] numbers = {10, 20, 30, 40, 50};

        for (int number : numbers) {
            System.out.println(number);
        }


        // =====================================================
        // 5. NESTED FOR LOOP
        // =====================================================
        // Ek loop ke andar doosra loop hone ko nested loop
        // kehte hain.

        System.out.println("\nNESTED FOR LOOP:");

        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }


        // =====================================================
        // 6. BREAK STATEMENT
        // =====================================================
        // break statement loop ko immediately terminate karta hai.

        System.out.println("\nBREAK STATEMENT:");

        for (int k = 1; k <= 10; k++) {

            if (k == 6) {
                break;  // Loop 6 par terminate ho jayega.
            }

            System.out.println(k);
        }


        // =====================================================
        // 7. CONTINUE STATEMENT
        // =====================================================
        // continue current iteration ko skip karta hai
        // aur next iteration par chala jata hai.

        System.out.println("\nCONTINUE STATEMENT:");

        for (int k = 1; k <= 10; k++) {

            if (k == 5) {
                continue;  // 5 skip hoga.
            }

            System.out.println(k);
        }


        // =====================================================
        // 8. BREAK WITH WHILE LOOP
        // =====================================================
        // break while loop ko bhi terminate kar sakta hai.

        System.out.println("\nBREAK WITH WHILE:");

        int x = 1;

        while (x <= 10) {

            if (x == 6) {
                break;
            }

            System.out.println(x);
            x++;
        }


        // =====================================================
        // 9. CONTINUE WITH WHILE LOOP
        // =====================================================
        // continue current iteration skip karta hai.
        // Important: continue ke baad increment zaroor karna
        // chahiye, warna infinite loop ho sakta hai.

        System.out.println("\nCONTINUE WITH WHILE:");

        int y = 1;

        while (y <= 5) {

            if (y == 3) {
                y++;
                continue;
            }

            System.out.println(y);
            y++;
        }


        // =====================================================
        // END
        // =====================================================

        System.out.println("\nAll loops, break and continue demonstrated!");
    }
}
