package com.algos;

import java.util.Random;

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

}
