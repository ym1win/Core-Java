package basics;

public class type_promotion_exm_2 {
    static void main() {

        byte b=34;
        short s=765;
        char c='g';
        int i=7654;
        float f= 4.5f;
        double d=5.66;
        double result= (f*b) + (i/c) - (d*s);

        // f*b --> float
        // i/c --> int
        // d*s --> double

        // float + int --> float
        // float - double --> double
        // thats why whole result data type is double

        System.out.println((f*b)+" + "+(i/c)+" - "+(d*s));
        System.out.println("Result : "+ result);

    }
}
