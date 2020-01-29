package com.algos.searching;

public class BinarySearch {

    public static void main(String[] args) {

        int[] numbers = {1, 4, 5, 12, 56, 3232, 54546, 78899};

        System.out.println(binarySearch(numbers, 78899));
    }

    private static boolean binarySearch(int[] numbers, int searched) {

        int maxIndex = numbers.length - 1;
        int index = maxIndex / 2;

        while (index >= 0 && index <= maxIndex) {
            if (index == 0 && numbers[index] != searched) {
                return false;
            }
            if (index == maxIndex && numbers[index] != searched) {
                return false;
            }

            if (numbers[index] == searched) {
                return true;
            } else if (numbers[index] > searched) {
                index /= 2;
            } else {

                index += (maxIndex - index) / 2 + 1;
            }
        }

        return false;
    }

}
