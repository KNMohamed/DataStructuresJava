package com.example.challenges;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        ReverseArray.reverseArray(arr);

        for(int i: arr){
            System.out.print(i + " ");
        }
    }

    /**
     * Reverses an array of numbers
     * Time complexity: O(N)
     * @param arr
     */
    public static void reverseArray(int[] arr){
        int startIndex = 0;
        int lastIndex = arr.length - 1;

        while(lastIndex > startIndex){
            swap(arr,startIndex,lastIndex);
            startIndex ++;
            lastIndex --;
        }
    }

    /**
     * Swap an array of numbers with two provided indices
     * @param a array of integers
     * @param x index of the first element
     * @param y index of the second element
     */
    public static void swap(int[] a, int x, int y){
        int temp = a[y];
        a[y] = a[x];
        a[x] = temp;
    }
}
