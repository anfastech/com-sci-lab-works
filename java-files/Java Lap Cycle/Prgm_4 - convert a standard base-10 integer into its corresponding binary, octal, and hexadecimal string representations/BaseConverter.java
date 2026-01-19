public class BaseConverter {
    public static void main(String[] args) {
        int decimalNumber = 255;
        
        System.out.println("Decimal (Base 10): " + decimalNumber);
        
        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println("Binary (Base 2): " + binaryString);

        String octalString = Integer.toOctalString(decimalNumber);
        System.out.println("Octal (Base 8): " + octalString);

        String hexString = Integer.toHexString(decimalNumber);
        System.out.println("Hexadecimal (Base 16): " + hexString.toUpperCase());

        int targetBase = 5; 
        String baseFiveString = Integer.toString(decimalNumber, targetBase);
        System.out.println("Base " + targetBase + ": " + baseFiveString);
    }
}
