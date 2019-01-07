package com.algos;

public class GlobalMax {

    private int max;

    public void compareAndEventuallySwap(int proposed) {
        if(proposed > max) {
            max = proposed;
        }
    }

    public int getMax() {
        return max;
    }
}
