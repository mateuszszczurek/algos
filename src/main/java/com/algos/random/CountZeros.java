package com.algos.random;

public class CountZeros {

    public static void main(String[] args) {

        int[][] array1 = {{0, 0, 1}, {0, 0, 1}, {0, 1, 1}};
        int numberOfZeros = new CountZeros().countZero(array1);

        System.out.println("Number of zeros: " + numberOfZeros);
    }

    public int countZero(int[][] array) {

        int row = 0;
        int column = array[row].length - 1;

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

}
