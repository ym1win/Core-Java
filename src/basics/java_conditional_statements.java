package basics;

public class java_conditional_statements {
    static void main() {

        // 1. IF STATEMENT
        // Condition true hone par if block execute hota hai.
        int age = 20;

        if (age >= 18) {
            System.out.println("Eligible to vote.");
        }


        // 2. IF-ELSE STATEMENT
        // Condition true -> if
        // Condition false -> else
        int number = 7;

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }


        // 3. ELSE-IF LADDER
        // Multiple conditions ko check karne ke liye.
        int marks = 85;

        if (marks >= 90) {
            System.out.println("Grade A+");
        } else if (marks >= 80) {
            System.out.println("Grade A");
        } else if (marks >= 70) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }


        // 4. NESTED IF
        // Ek if ke andar doosra if.
        int userAge = 25;
        boolean hasLicense = true;

        if (userAge >= 18) {

            if (hasLicense) {
                System.out.println("Can drive.");
            } else {
                System.out.println("Need driving license.");
            }

        } else {
            System.out.println("Cannot drive.");
        }


        // 5. SWITCH STATEMENT
        // Fixed values ko compare karne ke liye.
        int day = 3;

        switch (day) {

            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            default:
                System.out.println("Invalid day.");
        }


        // 6. TERNARY OPERATOR
        // if-else ka short form.
        int num = 10;

        String result = (num % 2 == 0)
                ? "Even"
                : "Odd";

        System.out.println(result);


        // 7. LOGICAL OPERATORS

        boolean p = true;
        boolean q = false;

        // && = Logical AND
        System.out.println(p && q);

        // || = Logical OR
        System.out.println(p || q);

        // ! = Logical NOT
        System.out.println(!p);


        // 8. BITWISE AND (&)
        // Dono bits 1 hone par result 1.
        int a = 5;
        int b = 3;

        System.out.println("AND = " + (a & b));


        // 9. BITWISE OR (|)
        // Koi bhi bit 1 ho to result 1.
        System.out.println("OR = " + (a | b));


        // 10. BITWISE XOR (^)
        // Different bits -> 1
        // Same bits -> 0
        System.out.println("XOR = " + (a ^ b));


        // 11. BITWISE NOT (~)
        // 0 ko 1 aur 1 ko 0 karta hai.
        System.out.println("NOT = " + (~a));


        // 12. LEFT SHIFT (<<)
        // Bits ko left shift karta hai.
        System.out.println("Left Shift = " + (a << 1));


        // 13. RIGHT SHIFT (>>)
        // Bits ko right shift karta hai.
        System.out.println("Right Shift = " + (a >> 1));


        // 14. UNSIGNED RIGHT SHIFT (>>>)
        // Left side par 0 fill karta hai.
        int negative = -8;

        System.out.println("Unsigned Right Shift = "
                + (negative >>> 1));


        // 15. BITWISE WITH IF
        // Odd/Even check using bitwise AND.
        int n = 15;

        if ((n & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }


        // 16. CHECK ith BIT
        // Check karta hai ki ith bit SET hai ya nahi.
        int value = 10;
        int i = 3;

        if ((value & (1 << i)) != 0) {
            System.out.println("Bit is SET.");
        } else {
            System.out.println("Bit is NOT SET.");
        }


        // 17. SET ith BIT
        // OR operator se bit ko 1 karte hain.
        int setValue = 8;
        int position = 1;

        setValue = setValue | (1 << position);

        System.out.println("After setting bit: " + setValue);


        // 18. CLEAR ith BIT
        // AND + NOT se bit ko 0 karte hain.
        int clearValue = 15;
        int clearPosition = 2;

        clearValue = clearValue & ~(1 << clearPosition);

        System.out.println("After clearing bit: " + clearValue);


        // 19. TOGGLE ith BIT
        // XOR se bit ko toggle karte hain.
        // 0 -> 1
        // 1 -> 0
        int toggleValue = 10;

        int togglePosition = 1;
        toggleValue = toggleValue ^ (1 << togglePosition);

        System.out.println("After toggling bit: " + toggleValue);

        System.out.println("All concepts completed!");



    }
}
