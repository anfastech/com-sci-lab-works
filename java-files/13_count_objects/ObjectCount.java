
// ---------------------------------
// |         CountObjects          |
// ---------------------------------
// | - count: int                  |  (static)
// ---------------------------------
// | + CountObjects()              |  (constructor)
// | + displayCount(): void        |
// ---------------------------------
//             ▲
//             |
// ---------------------------------
// |         ObjectCount           |
// ---------------------------------
// | + main(args: String[]): void  |
// ---------------------------------

class CountObjects {
    static int count = 0;

    CountObjects() {
        count++;
    }

    void displayCount() {
        System.out.println("Number of objects created: " + count);
    }
}

public class ObjectCount {
    public static void main(String[] args) {
        CountObjects obj1 = new CountObjects();
        CountObjects obj2 = new CountObjects();
        CountObjects obj3 = new CountObjects();

        obj3.displayCount();
    }
}
