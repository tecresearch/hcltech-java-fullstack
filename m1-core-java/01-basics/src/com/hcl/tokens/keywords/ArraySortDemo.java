/*
 * 🔑 Keywords Used:
import, public, class, static, int, for
This example uses the Arrays.sort() method from Java’s standard library, which is highly optimized and commonly used in contests.
 */
package com.hcl.tokens.keywords;
import java.util.Arrays;

public class ArraySortDemo {

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        // Sorting the array
        Arrays.sort(arr);

        // Displaying sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
