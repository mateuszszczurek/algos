package com.algos.arrays;

public class ArrayUtils {

    public static void shiftRight(int[] array, int startRange, int endRange) {
        if(endRange - startRange < 1) {
            return;
        }
        for (int i = endRange - 1; i >= startRange; i--) {
            array[i +1] = array[i];
        }
    }

    public static int[] reverse(int[] input) {

        int[] reversed = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            reversed[input.length - 1 - i] = input[i];
        }
        return reversed;
    }

    public static void reverseInline(int[] input) {

        int size = input.length;

        for (int i = 0; i < size / 2; i++) {
            int tmp = input[i];
            input[i] = input[size - 1 - i];
            input[size - 1 - i] = tmp;
        }
    }

}
