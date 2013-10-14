package com.algos.sort;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Given an integer array, find 2 integers which has sum, n
 *
 */
public class ArraySum {
	/**
	 * n^2 algorithm to find sum of integers
	 * @param array
	 * @param sum
	 * @return
	 */
	public static boolean checkSum(int[] array, int sum) {
		for (int i=0; i<array.length; i++) {
			for (int j = i+1; j< array.length; j++) {
				if (array[i] + array[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}

	private static ArrayList<Integer> addToList(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : array) {
			list.add(i);
		}
		return list;
	}
	public static boolean checkSumInList(int[] array, int sum) {
		ArrayList<Integer> list = addToList(array);
		for (int i=0; i<array.length; i++) {
				if (list.contains(sum - array[i])) {
					return true;
				}
		}
		return false;		
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int[] array = new int[arraySize];
        for (int i=0 ; i<arraySize ; i++) {
        	array[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(ArraySum.checkSum(array, sum));
        System.out.println(ArraySum.checkSumInList(array, sum));
    }
}
