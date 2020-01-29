package com.algos.greedy;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

//https://practice.geeksforgeeks.org/problems/raju-and-coins/0
public class RajuAndCoins {

    public static void main(String[] args) {
//        he has a1, a2, a3 ... an
//        on sale there is 10^9 coints
//        i-th type costs i dolats
//        he can spend at most k dollars

//        int[] coins = {1, 3, 4};
//        int k = 7;

        int[] coins = {4, 6, 12, 8};
        int k = 14;
        System.out.println(maxBought(coins, k));
    }

    private static int maxBought(int[] coins, int k) {
        sort(coins);
        int moneyLeft = k;

        int result = 0;
        int desiredCoin = 1;
        while (moneyLeft >= desiredCoin) {
            if (binarySearch(coins, desiredCoin) < 0) {
                result++;
                moneyLeft -= desiredCoin;
            }
            desiredCoin++;
        }

        return result;
    }

}
