package com.algos.opmization;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TopProfitOnMap {

    public static class BestBuyAndSell {

        public final String buyDate;
        public final String sellDate;
        public final Double value;

        public BestBuyAndSell(String buyDate, String sellDate, Double value) {
            this.buyDate = buyDate;
            this.sellDate = sellDate;
            this.value = value;
        }


        @Override
        public String toString() {
            return "BestBuyAndSell{" +
                    "buyDate='" + buyDate + '\'' +
                    ", sellDate='" + sellDate + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<String, Double> prices = new LinkedHashMap<>();
//        prices.put("2017-02-01", 100d);
//        prices.put("2017-02-02", 200d);
//        prices.put("2017-02-03", 0d);
//        prices.put("2017-02-04", 800d);
//        prices.put("2017-02-05", 700d);
//        prices.put("2017-02-06", 600d);
//        prices.put("2017-02-07", 0d);
//        prices.put("2017-02-08", 900d);
//        prices.put("2017-02-09", 1000d);
//        prices.put("2017-02-10", 100d);

        prices.put("2017-02-01", 1000d);
        prices.put("2017-02-02", 900d);
        prices.put("2017-02-03", 800d);
        prices.put("2017-02-04", 400d);
        prices.put("2017-02-05", 350d);
        prices.put("2017-02-06", 0d);

        BestBuyAndSell bestBuyAndSell = findBestBuyAndSell(prices);

        System.out.println(bestBuyAndSell);
    }

    private static BestBuyAndSell findBestBuyAndSell(Map<String, Double> prices) {
        Iterator<Map.Entry<String, Double>> iterator = prices.entrySet().iterator();

        Map.Entry<String, Double> buy = iterator.next();
        Map.Entry<String, Double> sell = iterator.next();
        double bestPrice = sell.getValue() - buy.getValue();

        while (iterator.hasNext()) {
            Map.Entry<String, Double> candidate = iterator.next();

            if (candidate.getValue() - buy.getValue() > bestPrice) {
                sell = candidate;
                bestPrice = sell.getValue() - buy.getValue();
            } else if (candidate.getValue() < buy.getValue()) {
                buy = candidate;
            }

        }

        return new BestBuyAndSell(buy.getKey(), sell.getKey(), bestPrice);
    }

}
