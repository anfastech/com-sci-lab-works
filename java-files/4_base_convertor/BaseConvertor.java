/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * BaseConvertor
 * -------------------------
 * +main(args : String[]) : void
 * -------------------------
 */

public class BaseConvertor {
    public static void main(String[] args) {
        int decimalNumber = Integer.parseInt(args[0]);
        System.out.println("Decimal: " + decimalNumber);

        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println("Binary: " + binaryString);

        String octalString = Integer.toOctalString(decimalNumber);
        System.out.println("Octal: " + octalString);

        String hexString = Integer.toHexString(decimalNumber);
        System.out.println("Hexadecimal: " + hexString.toUpperCase());
    }
}