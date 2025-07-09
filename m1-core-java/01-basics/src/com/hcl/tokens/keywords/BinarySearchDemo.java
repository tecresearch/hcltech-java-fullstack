/*
 * 🔑 Keywords Used:
public, class, static, int, if, else, return, while
Binary search is a must-know for competitive programming due to its O(log n) time complexity.
 */
package com.hcl.tokens.keywords;
public class BinarySearchDemo {

    // Binary search method
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // target found
            } else if (arr[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] sortedArr = {1, 3, 5, 7, 9, 11};
        int target = 7;

        int result = binarySearch(sortedArr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
