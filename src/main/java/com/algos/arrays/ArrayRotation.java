package com.algos.arrays;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class ArrayRotation {

    public static void main(String[] args) {
        int rotationPoint = 3;

        Integer[] array = new Integer[]{3, 6, 7, 1, 2, 3, 4, 5, 9, 10};
        Integer[] array2 = new Integer[]{3, 6, 7, 1, 2, 3, 4, 5, 9, 10};

        rotateFromBack(array, rotationPoint);
        rotateFromFront(array2, rotationPoint);

        System.out.println(describe(array));
        System.out.println(describe(array2));
    }

    private static String describe(Integer[] array) {
        return newArrayList(array).stream().map(i -> Integer.toString(i)).collect(joining(", "));
    }

    private static void rotateFromFront(Integer[] array, int rotationPoint) {
        for (int i = 0; i < rotationPoint; i++) {
            int temp = array[i];
            int switchIndex = array.length - 1 - (rotationPoint - 1) + i;
            array[i] = array[switchIndex];
            array[switchIndex] = temp;
        }
    }

    private static void rotateFromBack(Integer[] array, int rotationPoint) {
        for (int i = rotationPoint - 1; i >= 0; i--) {
            int rotationPointFromBack = array.length - 1 - (rotationPoint - 1) + i;
            int temp = array[rotationPointFromBack];
            array[rotationPointFromBack] = array[i];
            array[i] = temp;
        }
    }

}
