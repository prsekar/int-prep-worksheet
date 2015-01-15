package com.algos.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {

    public static void insertionSortPart2(int[] ar) {
        int pivot = 0;
        while (pivot <= ar.length - 2) {
            int elem = pivot + 1;
            for (int i = 0; i <= pivot; i++) {
                if (ar[elem] < ar[i]) {
                    //insert in location i and move all from i+1 till pivot
                    int tmp = ar[elem];
                    int shifter = pivot + 1;
                    ar[i] = tmp;
                    while (shifter > i) {
                        ar[shifter] = ar[shifter-1];
                        shifter--;
                        printArray(ar);
                    }
                    break;
                }
            }
            pivot++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);

    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}