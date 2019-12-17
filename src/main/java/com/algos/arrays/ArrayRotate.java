package com.algos.arrays;

import java.util.Arrays;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newArrayListWithCapacity;
import static java.lang.System.*;
import static java.util.stream.Collectors.joining;

//https://practice.geeksforgeeks.org/problems/rotate-and-delete/0 - do according to spec
public class ArrayRotate {

    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        int[] array = new int[]{1, 2, 3, 4};

        int k = 0;
        while (array.length > 1) {
            int[] newArray = new int[array.length - 1];

            rightRotate(array);

            if (k == array.length - 1) {
                arraycopy(array, 1, newArray, 0, array.length - 1);
            } else if (k == 0) {
                arraycopy(array, 0, newArray, 0, array.length - 1);
            } else {
                int removalIndex = array.length - 1 - k;
                arraycopy(array, 0, newArray, 0, removalIndex);
                arraycopy(array, removalIndex + 1, newArray, removalIndex, array.length - (removalIndex + 1));
            }

            if (k < newArray.length - 1) {
                k++;
            } else {
                k = newArray.length - 1;
            }
            array = newArray;
        }

        out.println(Arrays.toString(array));
    }

    private static void rightRotate(int[] array) {
        int temp = array[array.length - 1];
        arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = temp;
    }

}
