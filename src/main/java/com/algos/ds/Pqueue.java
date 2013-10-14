package com.algos.ds;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * #1) priority queue with no capacity. Add millions on data
 * 
 *
 */
public class Pqueue {

	private static long insertAvg =0;
	private static long pollAvg =0;
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(50000000);
		Random r = new Random();
		for (int i=0;i<50000000;i++) {
			long timeIn = System.currentTimeMillis();
			pq.add(r.nextInt(Integer.MAX_VALUE));
			insertAvg += System.currentTimeMillis() - timeIn;
		}
		print(pq.size());
		for (int i=0;i<50000000;i++){
			long timeIn = System.currentTimeMillis();
			pq.poll();
			pollAvg += System.currentTimeMillis() - timeIn;
		}
		
		System.out.println(insertAvg + " " + pollAvg);
		System.out.println("Avg insert time : " + insertAvg/50000000);
		System.out.println("Avg poll time : " + pollAvg/50000000);
	}
	
	public static void print(Object o) {
		System.out.println(o);
	}
}