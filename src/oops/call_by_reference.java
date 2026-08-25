package oops;

// Java mein object pass karne par method ko us object ka reference milta hai.
// Isliye method ke andar object ke variables change karenge,
// toh original object mein bhi change dikhega.

public class call_by_reference {

    public static void main(String[] args) {

        // Random object banaya
        // r1 ke andar x = 4 aur y = 5 hai
        Random r1 = new Random(4, 5);

        // Method call karne se pehle object ki values
        System.out.println(r1.x + " " + r1.y);
        // Output: 4 5

        // r1 object ka reference method addten() mein pass ho raha hai
        addten(r1);

        // Method ke andar same object ke x aur y change hue hain,
        // isliye yahan bhi updated values milengi
        System.out.println(r1.x + " " + r1.y);
        // Output: 14 15
    }


    static void addten(Random r) {

        // 'r' aur 'r1' dono same object ko refer kar rahe hain

        // Original object ke x ko modify kar rahe hain
        r.x = r.x + 10;

        // Original object ke y ko modify kar rahe hain
        r.y = r.y + 10;
    }
}

// Ye ek class hai jisme object ke data members hain
class Random {

    int x;
    int y;

    // Constructor object create hote time x aur y initialize karta hai
    Random(int x, int y) {
        this.x = x;
        this.y = y;
    }
}