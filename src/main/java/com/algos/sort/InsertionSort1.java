package com.algos.sort;

import java.util.Scanner;

public class InsertionSort1 {
    
    static void insertionSort(int[] ar) {
        int item = ar[ar.length-1];
        int i = ar.length - 2;
        while (i >= 0) {
        	if (ar[i] > item) {
        		ar[i+1] = ar[i];
            	printArray(ar);	
        	}
        	else {
        		ar[i+1] = item;
            	printArray(ar);	
        		break;
        	}	
        	i--;
        }   
        if (i < 0) {
        	ar[0] = item;
        	printArray(ar);
        }
 }   

/* Tail starts here */

static void printArray(int[] ar) {
   for(int n: ar){
      System.out.print(n+" ");
   }
     System.out.println("");
}
 
public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int[] ar = new int[n];
     for(int i=0;i<n;i++){
        ar[i]=in.nextInt(); 
     }
     insertionSort(ar);
 }  
}
