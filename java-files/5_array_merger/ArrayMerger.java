/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * ArrayMerger
 * -------------------------
 * +main(args : String[]) : void
 * -------------------------
 */

import java.util.Arrays;

public class ArrayMerger {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};

        System.out.println("Array 1:"+ Arrays.toString(array1));
        System.out.println("Array 2:"+ Arrays.toString(array2));

        int[] mergedArray = new int[array1.length + array2.length];

        int currentIndex = 0;

        for (int num: array1) {
            mergedArray[currentIndex++] = num;
        }
        for (int num: array2) {
            mergedArray[currentIndex++] = num;
        }
        System.out.println("Merged Array:"+ Arrays.toString(mergedArray));

    }
}
