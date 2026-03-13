
/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * HcfLcmFinder
 * -------------------------
 * +findHCF(num1 : int, num2 : int) : int
 * +findLCM(num1 : int, num2 : int) : int
 * +main(args : String[]) : void
 * -------------------------
 */

public class HcfLcmFinder {
    public static int findHCF(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static int findLCM(int num1, int num2) {
        return (num1 * num2) / findHCF(num1, num2);
    }

    public static void main(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        int hcf = findHCF(number1, number2);
        int lcm = findLCM(number1, number2);

        System.out.println("HCF of " + number1 + " and " + number2 + " is: " + hcf);
        System.out.println("LCM of " + number1 + " and " + number2 + " is: " + lcm);
    }
}
