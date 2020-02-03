package com.algos.bit;

public class RightmostDifferentBit {

    public static void main(String[] args) {
        int m, n;
        System.out.println(findRightmostDofferent(11, 9));
        System.out.println(findRightmostDofferent(52, 4));
    }

    private static int findRightmostDofferent(int x, int y) {
        int number = x ^ y;

        int pos = 1;
        while(number != 0) {
            if((number &1) == 1) {
                break;
            }
            number = number >>> 1;
            pos++;
        }
        return pos;
    }

}
