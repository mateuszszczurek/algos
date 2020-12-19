package com.algos.structures;

import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;

public class Heap {

    public static final int HEAP_SIZE = 128;
    int maxIndex = 0;

    int[] elements = new int[HEAP_SIZE];

    public Heap(int[] ints) {
        arraycopy(ints, 0, elements, 0, ints.length);
        heapify(0);
        maxIndex = ints.length - 1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 15, 8, 9, 12, 5, 7};

        Heap heap = new Heap(ints);
    }

    private void heapify(int position) {
        int leftPos = leftChild(position);
        int rightPos = rightChild(position);
        int maxValue = position;
//        if(elements[leftPos] <= maxIndex && elements[leftPos] > elements[position])
    }

    private static int rightChild(int position) {
        return position * 2 + 2;
    }

    private static int leftChild(int position) {
        return position * 2 + 1;
    }

    private void put(int value) {


        maxIndex++;
    }


}
