package com.algos.sorting;

import com.algos.arrays.ArrayUtils;
import com.algos.structures.LongestIncreasingSubsequence;

import static com.algos.RandomUtils.randoms;

public class InsertionSort {

    public static void main(String[] args) {
        LongestIncreasingSubsequence.benchmark(() -> sort(randoms(10)));
    }

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[j] >= array[i]) {
                    insert(array, i, j);
                    break;
                }
            }

        }
        return array;
    }

    // TODO write using while, and moving all greater elements by one to the right

    private static void insert(int[] array, int i, int j) {
        int temp = array[i];
        ArrayUtils.shiftRight(array, j, i);
        array[j] = temp;
    }

}
