package com.algos.sort;

import java.util.Scanner;

public class WorstSort {
	
	public static int[] sort(int[] ar) {
		for (int i = 0; i < ar.length ; i++) {
			System.out.println(" iteration " + i);
			for (int j = i+1; j < ar.length; j++) {
				System.out.println(" iteration " + j);
				if (ar[i] > ar[j]) {
					System.out.println(ar[i]+ " "+ ar[j]);
					int tmp = ar[j];
					ar[j] = ar[i];
					ar[i] = tmp;
				}					
			}
		}
		return ar;
	}
	public static void printArr(int[] ar) {
		for (int i=0;i< ar.length;i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for (int i=0;i<n;i++) {
			ar[i] = sc.nextInt();			
		}
		sort(ar);
		printArr(ar);
	}
}
