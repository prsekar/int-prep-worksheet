package com.algos.sort;

import java.util.Scanner;

public class QuickSort {
	
	private static void sort(int[] arr, int pivot, int start, int end) {
		if (end - start > 1) {
			for (int i=start ;i< end;i++) {
				if ((arr[i] < arr[pivot] && i > pivot ) || (arr[i] > arr[pivot] && i < pivot)) {
					int tmp = arr[i];
					arr[i] = arr[pivot];
					arr[pivot] = tmp;
				}
			}
			System.out.println("Start : " + start + " Pivot : " + pivot + " End : " + end);
			sort(arr, (start + pivot)/2, start, pivot);
			sort(arr, (pivot + end)/2, pivot, end);			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] arr = new int[l];
		for (int i=0;i<l;i++) {
			arr[i] = sc.nextInt();
		}
		sort(arr, arr.length / 2, 0, arr.length-1);
		
		for (int i=0;i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
