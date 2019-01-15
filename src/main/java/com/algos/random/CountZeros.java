package com.algos.random;

public class CountZeros {

    public static void main(String[] args) {

        int[][] input = {{0, 0, 1}, {0, 0, 1}, {0, 1, 1}};
        CountZeros countZeros = new CountZeros();

        System.out.println("Number of zeros: " + countZeros.countZero(input));
        System.out.println("Number of zeros (using binary search): " + countZeros.countZerosBinarySearch(input));
    }

    public int countZero(int[][] array) {

        int row = 0, column = array[row].length - 1;

        int total = 0;

        while (row < array.length && column >= 0) {
            if (array[row][column] == 1) {
                column--;
            } else {
                total += column + 1;
                row++;
            }
        }

        return total;
    }

    public int countZerosBinarySearch(int[][] array) {

        int row = 0, amountOfZeros = 0;

        int endIndex = array[row].length - 1;

        while (row < array.length && endIndex != -1) {

            endIndex = findStartingZero(0, endIndex, array[row]);

            if (endIndex != -1) {
                amountOfZeros += (endIndex + 1);
            }
            row++;
        }

        return amountOfZeros;
    }

    private int findStartingZero(int startIndex, int endIndex, int[] array) {
        int searchRange = (endIndex - startIndex) + 1;

        if (searchRange < 2) {
            return -1;
        } else if (searchRange == 2) {
            if (array[endIndex] == 0) {
                return endIndex;
            } else if (array[startIndex] == 0) {
                return startIndex;
            } else {
                return -1;
            }
        }

        int middle = (endIndex - startIndex) / 2;

        if (array[middle] == 0) {
            return findStartingZero(middle, endIndex, array);
        } else {
            return findStartingZero(startIndex, middle, array);
        }
    }

}
