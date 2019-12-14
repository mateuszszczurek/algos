package com.algos.opmization;

public class TopProfit {

    public static void main(String[] args) {

//        int[] array = {500, 600, 400, 1000, 1100, 0, 800, 500, 300};
        int[] array = {700, 600, 300, 100, 0};

        int bestProfit = findBestProfit(array);

        System.out.println(bestProfit);
    }

    private static int findBestProfit(int[] array) {
        int bestProfitSoFar = 0, buy = 0;

        for (int i = 1; i < array.length; i++) {
            if(array[i] < array[buy]) {
                buy = i;
            } else if (array[i] - array[buy] > bestProfitSoFar){
                bestProfitSoFar = array[i] - array[buy];
            }
        }

        return bestProfitSoFar;
    }

}
