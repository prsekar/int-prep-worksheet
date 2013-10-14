package com.algos.knapsack;

import java.util.Scanner;

import com.algos.sort.WorstSort;

public class MarkToys {
	private static void sort(int[] items) {
		items = WorstSort.sort(items);
	}
	public static void knapsack(int[] items, int k) {
		int i=0;int value =0;
		for ( i=0;i< items.length; i++) {
			if (value + items[i] <= k) {
				value +=items[i];
			}
			else {
				break;
			}
		}
		System.out.println("max # of items " + i);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] items = new int[n];
		for (int i= 0;i < n; i++) {
			items[i] = sc.nextInt();
		}
		sort(items);
		knapsack(items, k);
	}
}
