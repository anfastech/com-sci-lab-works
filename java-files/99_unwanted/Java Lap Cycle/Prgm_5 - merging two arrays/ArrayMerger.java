import java.util.Arrays;

public class ArrayMerger {

    public static void main(String[] args) {
        int[] array1 = {10, 20, 30, 40};
        int[] array2 = {5, 15, 25, 35, 45};
        
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("\n------------------------------------");

        // --- Basic Method: Using a simple for-loop (Manual Copy) ---
        
        // 1. Calculate the total size of the new merged array
        int mergedLength = array1.length + array2.length;
        
        // 2. Create the new array of the combined size (must be int[])
        int[] mergedArray = new int[mergedLength];
        
        // This index tracks where the next element should be placed in the mergedArray
        int currentPosition = 0;
        
        // 3. Loop through the first array and copy its elements
        for (int element : array1) { // Iterating over integers
            mergedArray[currentPosition] = element;
            currentPosition++; // Move the position index forward
        }
        
        // 4. Loop through the second array and copy its elements
        for (int element : array2) { // Iterating over integers
            mergedArray[currentPosition] = element;
            currentPosition++; // Move the position index forward
        }

        System.out.println("Result (Manual Loop Copy):");
        System.out.println(Arrays.toString(mergedArray));
    }
}
