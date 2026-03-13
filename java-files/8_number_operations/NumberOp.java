
/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * NumberOp
 * -------------------------
 * -number : int
 * +readNumber() : void
 * +sumOfDigits() : int
 * +reverseNumber() : int
 * +main(args : String[]) : void
 * -------------------------
 */

import java.util.Scanner;

public class NumberOp {
    int number;
    void readNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = sc.nextInt();

        sc.close();
    }

    int sumOfDigits() {
        int sum = 0;
        int temp = number;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    int reverseNumber() {
        int reverse = 0;
        int temp = number;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        NumberOp numberOpObj = new NumberOp();
        numberOpObj.readNumber();
        System.out.println("Sum of digits: " + numberOpObj.sumOfDigits());
        System.out.println("Reverse of the number: " + numberOpObj.reverseNumber());
    }

}
