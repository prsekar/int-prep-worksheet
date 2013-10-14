package com.algos.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
/**
 * find pairs of integers in array that can cause a diff > k
 *
 */
public class DiffTest {
	private static int counter;
	public static void findDiff(List<Integer> ar, int k) {
        Collections.sort(ar);
		for (int i = ar.size() -1 ; i >=0; i--) {
			for (int j = i-1 ; j >=0; j--) {
				int diff = ar.get(i).intValue() - ar.get(j).intValue();
				if (diff > k) {
					break;
				}
				else if (diff < k) {
					// do nothing
				}
				else {
					System.out.println(ar.get(i).intValue() + " -  " + ar.get(j).intValue() + " = " + k);
					counter++;
				}
			}
		}
		
		System.out.println("max pairs possible " + counter);
	}
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i = 0;i < n;i++) {
            ar.add(sc.nextInt());
        }
        findDiff(ar, k);
    }
}