package com.algos.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by psekar on 1/7/15.
 */
public class StickcutProblem {

    public static void stickCut(Integer[] ar) {
        if (ar.length == 0) {
            return;
        }
        Arrays.sort(ar);
        int least = ar[0];
        List finalList = new ArrayList();
        int result = 0;
        for (int i=0; i< ar.length; i++) {
            result += 1;
            int x = ar[i] - least;
            if (x == 0) {
            //
            } else {
                finalList.add(x);
            }
        }
        System.out.println(result);
        Integer[] arr = (Integer[])finalList.toArray(new Integer[finalList.size()]);
        stickCut(arr);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Integer[] stickArr = new Integer[total];
        for (int i=0;i< total; i++) {
            stickArr[i] = sc.nextInt();
        }
        stickCut(stickArr);
    }
}