package com.algos.sorting;

import static com.algos.RandomUtils.randoms;
import static com.algos.arrays.ArrayUtils.shiftRight;
import static com.algos.structures.LongestIncreasingSubsequence.benchmark;

public class InsertionSort {

    public static void main(String[] args) {
        benchmark(() -> sort(randoms(10)));
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

    private static void insert(int[] array, int i, int j) {
        int temp = array[i];
        shiftRight(array, j, i);
        array[j] = temp;
    }

}
