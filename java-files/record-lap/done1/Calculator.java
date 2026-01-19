// College record : Program 1
class Calculator {
    public static void main(String[] args) {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            int sum = num1 + num2;
            int diff = num1 - num2;
            int pro = num1 * num2;

            System.out.println("Sum: " + sum + "\n Difference: " + diff + "\n Product: " + pro);

            // Handle division and remainder carefully to avoid division by zero
            if (num2 != 0) {
                int quot = num1 / num2;
                int rem = num1 % num2;

                System.out.println("Quotient: " + quot + "\n Remainder: " + rem);
            } else {
                System.out.println("Invalid number");
            }
    }
}
