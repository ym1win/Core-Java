package basics;

public class type_casting_and_type_promotion {
    static void main() {

        // implicit conversion
        byte b =34;
        int i=b;
        System.out.println(i);

        char c='a';
        int j=c;
        System.out.println(j);

        float f=5.6f;
        double d=f;
        System.out.println(d);

        // Explicit conversion
        int x=45;
      //  byte y=x; gives compile error cuz byte range is less than int , so we have to manually type cast it

        byte y=(byte) x;
        System.out.println(y); // it would print 45 % (range of byte i.e 256)

        // Truncating conversion = when we convert float or double type to integer type , decimal part gets removed(truncated)

        double r=5.987;
        int s=(int) r;
        System.out.println(s);

        //Boolean to any data type (these conversions are not possible)

        // Automatic type promotion

         byte u=50;
         // u=u*2; gives compile error cuz of type promotion 50 gets automatically converted to int

         u=(byte)(u*2);   // now whole expression and result becomes byte
        System.out.println(u);
    }
}
