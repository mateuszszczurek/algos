package com.algos;

import java.util.Random;
import java.util.StringJoiner;

public class RandomUtils {

    public static int[] randoms(int count) {
        Random random = new Random();

        int numbers[] = new int[count];

        for (int i = 0; i < count; i++) {
            int number = random.nextInt(20);
            numbers[i] = number;
        }

        return numbers;
    }

    public static int[][] randomArray(int dimension) {
        int[][] array = new int[dimension][dimension];

        Random random = new Random();

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                array[i][j] = random.nextInt(2);
            }
        }

        return array;
    }

    public static void describe(int[][] array) {
        StringJoiner joiner = new StringJoiner("\r\n");

        for (int[] anArray : array) {
            StringJoiner innerJoiner = new StringJoiner(" ");

            for (int anAnArray : anArray) {
                innerJoiner.add(Integer.toString(anAnArray));
            }

            joiner.merge(innerJoiner);
        }

        System.out.println(joiner.toString());
    }

}
