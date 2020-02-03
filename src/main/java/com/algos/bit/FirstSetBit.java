package com.algos.bit;

//https://practice.geeksforgeeks.org/problems/find-first-set-bit/0
public class FirstSetBit {

    public static void main(String[] args) {
        int n = 120023102;

        System.out.println(firstBitSet(n));
        System.out.println(firstBitSet(18));
        System.out.println(firstBitSet(12));
    }

    private static int firstBitSet(int n) {
        int current = n, pos = 1;
        while(current != 0) {
            if((current&1)  == 1) {
                break;
            }
            current >>>= 1;
            pos++;
        }
        return pos;
    }

}
