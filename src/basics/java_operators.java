package basics;

public class java_operators {
    static void main() {

        int a = 10;
        int b = 3;

        // =====================================================
        // 1. ARITHMETIC OPERATORS
        // =====================================================

        int add = a + b;       // +  Addition
        int sub = a - b;       // -  Subtraction
        int mul = a * b;       // *  Multiplication
        int div = a / b;       // /  Division
        int mod = a % b;       // %  Modulus (remainder)

        System.out.println("Addition       : " + add);
        System.out.println("Subtraction    : " + sub);
        System.out.println("Multiplication : " + mul);
        System.out.println("Division       : " + div);
        System.out.println("Modulus        : " + mod);


        // =====================================================
        // 2. UNARY OPERATORS
        // =====================================================

        int x = 5;

        x++;                   // ++  Increment
        System.out.println("After x++      : " + x);

        x--;                   // --  Decrement
        System.out.println("After x--      : " + x);

        int positive = +x;     // +   Unary plus
        int negative = -x;     // -   Unary minus

        boolean flag = true;
        boolean notFlag = !flag;  // !  Logical NOT

        System.out.println("Unary +        : " + positive);
        System.out.println("Unary -        : " + negative);
        System.out.println("Logical NOT     : " + notFlag);


        // =====================================================
        // 3. RELATIONAL OPERATORS
        // =====================================================

        System.out.println("a > b          : " + (a > b));   // >  Greater than
        System.out.println("a < b          : " + (a < b));   // <  Less than
        System.out.println("a >= b         : " + (a >= b));  // >= Greater/equal
        System.out.println("a <= b         : " + (a <= b));  // <= Less/equal
        System.out.println("a == b         : " + (a == b));  // == Equal
        System.out.println("a != b         : " + (a != b));  // != Not equal


        // =====================================================
        // 4. LOGICAL OPERATORS
        // =====================================================

        boolean p = true;
        boolean q = false;

        System.out.println("p && q         : " + (p && q));  // && Logical AND
        System.out.println("p || q         : " + (p || q));  // || Logical OR
        System.out.println("!p             : " + (!p));      // !  Logical NOT


        // =====================================================
        // 5. BITWISE OPERATORS
        // =====================================================

        int m = 5;   // Binary: 101
        int n = 3;   // Binary: 011

        System.out.println("m & n          : " + (m & n));   // &  Bitwise AND
        System.out.println("m | n          : " + (m | n));   // |  Bitwise OR
        System.out.println("m ^ n          : " + (m ^ n));   // ^  Bitwise XOR
        System.out.println("~m             : " + (~m));       // ~  Bitwise NOT


        // =====================================================
        // 6. SHIFT OPERATORS
        // =====================================================

        System.out.println("m << 1         : " + (m << 1));   // <<  Left shift
        System.out.println("m >> 1         : " + (m >> 1));   // >>  Signed right shift
        System.out.println("m >>> 1        : " + (m >>> 1));  // >>> Unsigned right shift


        // =====================================================
        // 7. ASSIGNMENT OPERATORS
        // =====================================================

        int value = 10;      // =   Simple assignment

        value += 5;          // +=  Add and assign
        System.out.println("value += 5     : " + value);

        value -= 2;          // -=  Subtract and assign
        System.out.println("value -= 2     : " + value);

        value *= 2;          // *=  Multiply and assign
        System.out.println("value *= 2     : " + value);

        value /= 2;          // /=  Divide and assign
        System.out.println("value /= 2     : " + value);

        value %= 3;          // %=  Modulus and assign
        System.out.println("value %= 3     : " + value);

        value <<= 1;         // <<= Left shift and assign
        System.out.println("value <<= 1    : " + value);

        value >>= 1;         // >>= Right shift and assign
        System.out.println("value >>= 1    : " + value);

        value >>>= 1;        // >>>= Unsigned right shift and assign
        System.out.println("value >>>= 1   : " + value);

        value &= 3;          // &=  Bitwise AND and assign
        System.out.println("value &= 3     : " + value);

        value |= 2;          // |=  Bitwise OR and assign
        System.out.println("value |= 2     : " + value);

        value ^= 1;          // ^=  Bitwise XOR and assign
        System.out.println("value ^= 1     : " + value);


        // =====================================================
        // 8. TERNARY OPERATOR
        // =====================================================

        int age = 20;

        String result = (age >= 18)
                ? "Adult"       // ?  Condition
                : "Minor";      // :  Otherwise

        System.out.println("Ternary result : " + result);


        // =====================================================
        // 9. instanceof OPERATOR
        // =====================================================

        String name = "Rahul";

        boolean check = name instanceof String;
        // instanceof checks whether an object belongs to a class/type

        System.out.println("instanceof     : " + check);


        // =====================================================
        // 10. ARRAY ACCESS OPERATOR []
        // =====================================================

        int[] numbers = {10, 20, 30};

        System.out.println("Array element  : " + numbers[1]);
        // [] is used to access an array element


        // =====================================================
        // 11. MEMBER ACCESS OPERATOR .
        // =====================================================

        System.out.println("String length  : " + name.length());
        // . is used to access a class/object member


        // =====================================================
        // 12. PARENTHESES ()
        // =====================================================

        int calculation = (a + b) * 2;
        // () controls grouping and operator precedence

        System.out.println("Parentheses     : " + calculation);


        // =====================================================
        // 13. NEW OPERATOR
        // =====================================================

        String message = new String("Hello");
        // new creates an object

        System.out.println("new operator   : " + message);


        // =====================================================
        // 14. TYPE CASTING OPERATOR
        // =====================================================

        double decimal = 10.75;

        int integer = (int) decimal;
        // (int) explicitly converts double into int

        System.out.println("Type casting   : " + integer);


        // =====================================================
        // END
        // =====================================================

        System.out.println("\nAll major Java operators demonstrated!");

    }
}
