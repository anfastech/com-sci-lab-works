public class ArrayStats {
    public static void main(String[] args) {
        if (args.length < 10) {
            System.out.println("Please provide at least 10 numbers as command line arguments.");
            return;
        }

        try {
            int[] numbers = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }

            int smallest = numbers[0];
            int largest = numbers[0];
            int secondLargest = Integer.MIN_VALUE;

            for (int num : numbers) {
                if (num < smallest) {
                    smallest = num;
                }
                if (num > largest) {
                    secondLargest = largest; // update secondLargest before updating largest
                    largest = num;
                } else if (num > secondLargest && num < largest) {
                    secondLargest = num;
                }
            }

            System.out.println("Smallest element: " + smallest);
            System.out.println("Largest element: " + largest);

            if (secondLargest == Integer.MIN_VALUE) {
                System.out.println("There is no distinct second largest element.");
            } else {
                System.out.println("Second largest element: " + secondLargest);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please provide valid integer numbers only.");
        }
    }
}
