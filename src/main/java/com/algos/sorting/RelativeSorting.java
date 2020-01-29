package com.algos.sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Maps.newTreeMap;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.*;

//https://practice.geeksforgeeks.org/problems/relative-sorting/0
public class RelativeSorting {

    public static void main(String[] args) {
        int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] A2 = {2, 1, 8, 3};

        relativeSortBasedOnSortingAndBinarySearch(A1, A2);
        System.out.println(Arrays.toString(relativeSortingBasedOnMapCount(A1, A2)));
//        System.out.println(Arrays.toString(A1));
        // 1 2 2 2 2 3 4 8 9 11
    }

    private static int[] relativeSortingBasedOnMapCount(int[] a1, int[] a2) {
        Map<Integer, Integer> valueToCount = newTreeMap();
        for (int value : a1) {
            valueToCount.computeIfPresent(value, (key, oldVal) -> oldVal + 1);
            valueToCount.putIfAbsent(value, 1);
        }

        int[] sorted = new int[a1.length];

        int position = 0;
        for (int value : a2) {
            if (valueToCount.containsKey(value)) {
                Integer count = valueToCount.get(value);
                fill(sorted, position, position + count, value);
                position += count;
                valueToCount.remove(value);
            }
        }

        for (Map.Entry<Integer, Integer> entry : valueToCount.entrySet()) {
            fill(sorted, position, position + entry.getValue(), entry.getKey());
            position += entry.getValue();
        }

        return sorted;
    }

    private static void relativeSortBasedOnSortingAndBinarySearch(int[] A1, int[] A2) {
        sort(A1);

        int currentIndex = 0;
        for (int i = 0; i < A2.length; i++) {
            int found = binarySearch(A1, currentIndex, A1.length - 1, A2[i]);
            while (found >= 0 && currentIndex <= A1.length - 1) {
                move(found, currentIndex, A1);
                found = binarySearch(A1, currentIndex, A1.length - 1, A2[i]);
                currentIndex++;
            }
        }
    }

    private static void move(int from, int to, int[] array) {
        if (from == to) {
            return;
        }
        for (int i = from; i > to; i--) {
            int temp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = temp;
        }
    }

}
