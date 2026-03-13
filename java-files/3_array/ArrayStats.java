
/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * ArrayStats
 * -------------------------
 * +main(args : String[]) : void
 * -------------------------
 */

public class ArrayStats {
    public static void main(String[] args) {
        if (args.length < 10) {
            System.out.println("Please provide at least 10 integer numbers as command line arguments.");
            return;
        } 
        
        try {
            int[] numbers = new int[args.length];
            for (int i = 0; i<args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }

            int smallest = numbers[0];
            int largest = numbers[0];
            int secondSmallest = Integer.MAX_VALUE;
            int secondLargest = Integer.MIN_VALUE;
            for (int num: numbers) {
                if (num < smallest) {
                    smallest = num;
                }
                if (num > largest) {
                    secondLargest = largest;
                    largest = num;
                } else if (num > secondLargest && num < largest ) {
                    secondLargest = num;
                }
            }

            System.out.println("Smallest: " + smallest);
            System.out.println("Largest: " + largest);
            
            if (secondLargest != Integer.MIN_VALUE) {
                System.out.println("Second Largest: " + secondLargest);
            } else {
                System.out.println("No second largest number found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please provide valid integer numbers as command line arguments.");
        }
    }
}