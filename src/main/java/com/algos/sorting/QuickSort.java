package com.algos.sorting;

import static com.algos.arrays.LongestIncreasingSubsequence.benchmark;

public class QuickSort {

    public static void main(String[] args) {
        benchmark(() -> quickSort(new int[]{20, 3, 4, 11, 0, 5, 31}, 0, 5));
    }

    public static int[] quickSort(int[] array, int beg, int end) {
        if (end - beg < 1) {
            return array;
        }

        int pivotIndex = partition(array, beg, end);

        quickSort(array, beg, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);

        return array;
    }

    private static int partition(int[] array, int beg, int end) {
        int pivotValue = array[end];
        int pivotFinalPos = beg;

        for (int i = beg; i < end; i++) {
            if (array[i] < pivotValue) {
                int temp = array[i];
                array[i] = array[pivotFinalPos];
                array[pivotFinalPos] = temp;
                pivotFinalPos++;
            }
        }

        int temp = array[pivotFinalPos];
        array[pivotFinalPos] = array[end];
        array[end] = temp;

        return pivotFinalPos;
    }


}
