package com.springboot.practice.tryout;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static List<Integer> cellCompete(int[] cells, int days) {

        int len = cells.length;
        int[] newCells = new int[cells.length];
        for (int k = 0; k < days; k++) {
            for (int i = 0; i < cells.length; i++) {
                int cell = cells[i];
                int nextCell;
                int prevCell;
                int activenumber;
                if (i == 0) {
                    // edge cases
                    nextCell = cells[1];
                    prevCell = 0;
                } else if (i == cells.length - 1) {
                    // edge case
                    prevCell = cells[cells.length - 2];
                    nextCell = 0;
                } else {
                    nextCell = cells[i + 1];
                    prevCell = cells[i - 1];
                }
                if (nextCell == prevCell) {
                    // set it to inactive
                    activenumber = 0;
                } else {
                    //set it to active
                    activenumber = 1;
                }
                newCells[i]=activenumber;
            }
            for (int i = 0; i < 8; i++) {
                cells[i] = newCells[i];
            }
        }
        return Arrays.stream(newCells).boxed().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;
        //array = cellCompete(array, days);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    }


