package com.algos.arrays;

import com.algos.GlobalMax;
import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.function.Supplier;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class LongestIncreasingSubsequence {

    public static <T> void benchmark(Supplier<T> supplier) {
        Stopwatch started = Stopwatch.createStarted();
        T result = supplier.get();
        started.stop();
        if (result.getClass().isArray()) {
            System.out.println(Arrays.toString((int[]) result));
        } else {
            System.out.println("Result: " + result);
        }

        System.out.println("Elapsed: " + started.elapsed(MILLISECONDS));
    }

    public static void main(String[] args) {
        int[] randoms = {7, 10, 6, 15, 20, 24};
//        int[] randoms = RandomUtils.randoms(50000);

        benchmark(() -> backFillLis(randoms));
        benchmark(() -> reverseLisWrapper(randoms));
        benchmark(() -> patienceLis(randoms));

    }

    public static int lisWrapper(int[] numbers) {
        GlobalMax globalMax = new GlobalMax();

        lis(numbers, 0, globalMax, new java.util.HashMap<>());

        return globalMax.getMax();
    }

    public static int reverseLisWrapper(int[] numbers) {
        GlobalMax globalMax = new GlobalMax();
        Map<Integer, Integer> responses = new HashMap<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            lis(numbers, i, globalMax, responses);
        }

        return globalMax.getMax();

    }

    public static int patienceLis(int[] numbers) {

        List<Integer> piles = newArrayList();

        for (int i = 0; i < numbers.length; i++) {
            int pileIndex = findPlace(numbers[i], piles);
            if (pileIndex == -1) {
                piles.add(numbers[i]);
            } else {
                piles.set(pileIndex, numbers[i]);
            }
        }

        return piles.size();
    }

    private static int findPlace(int number, List<Integer> piles) {
        for (int j = 0; j < piles.size(); j++) {
            if (number <= piles.get(j)) {
                return j;
            }
        }
        return -1;
    }

    public static int lis(int[] numbers, int n, GlobalMax globalMax, Map<Integer, Integer> response) {
        if (n == numbers.length - 1) {
            response.put(n, 1);
            return 1;
        }

        int localMax;
        int finalMax = 0;

        for (int j = n + 1; j < numbers.length; j++) {

            if (response.containsKey(j)) {
                localMax = response.get(j);
            } else {
                localMax = lis(numbers, j, globalMax, response);
            }

            if (numbers[n] < numbers[j] && localMax > finalMax) {
                finalMax = localMax;
            }

        }

        int result = finalMax + 1;
        response.put(n, result);
        globalMax.compareAndEventuallySwap(result);

        return result;
    }


    public static List<Integer> values = new ArrayList<>(100);

    public static int backFillLis(int[] a) {

        for (int i = 0; i < a.length; i++) {
            values.add(i, 1);

            for (int j = 0; j <= i - 1; j++) {
                if (a[i] > a[j] && values.get(i) <= values.get(j)) {
                    Integer integer = values.get(j);
                    values.set(i, integer + 1);
                }
            }
        }

        return values.stream().mapToInt(value -> value).max().getAsInt();
    }

}
