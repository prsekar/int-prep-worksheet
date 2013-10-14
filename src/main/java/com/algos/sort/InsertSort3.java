package com.algos.sort;

import java.util.Scanner;

public class InsertSort3 {
	
	
	public static int sort(int[] ar) {
		int swapCount = 0;
		for (int i=0;i<ar.length;i++) {
			for (int j=i+1; j< ar.length; j++) {
				if (ar[i] > ar[j]) {
					swapCount++;
				}
			}
		}
		return swapCount;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i =0;i< testcases; i++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int j= 0 ;j< n;j++ ){
                ar[j] = sc.nextInt();
            }
            System.out.println(sort(ar));
        }
    }
}
