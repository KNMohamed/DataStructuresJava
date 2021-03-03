package com.example.challenges;

import java.util.Arrays;

public class DuplicateChallenge {
    public static void main(String[] args) {
        int[] arr = {2,1,3,3,4,5};
        System.out.println(DuplicateChallenge.inPlaceAlgorithm(arr));
    }

    /**
     * This method is used to validate that an array does not contain a duplicate value
     * Limitations: Array values must be less than n-1, where n is the length of the array.
     * Time complexity: O(n)
     * @param arr
     * @return true if their is a duplicate, otherwise false
     */
    public static boolean inPlaceAlgorithm(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }else{
                return true;
            }
        }
        return false;
    }
}
