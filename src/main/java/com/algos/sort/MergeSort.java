package com.algos.sort;


public class MergeSort {
	
	/*
     * The merge method used by the mergeSort algorithm implementation.
     */
    private static void merge(int[] array, int leftArrayBegin,
            int rightArrayBegin, int rightArrayEnd) {

        int leftArrayEnd = rightArrayBegin - 1;

        int numElements = rightArrayEnd - leftArrayBegin + 1;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

        // Find the smallest element in both these array and add it to the result
        // array i.e you may have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
            if (array[leftArrayBegin] <= array[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = array[leftArrayBegin++];
            } else {
                resultArray[resultArrayBegin++] = array[rightArrayBegin++];
            }
        }

        // After the main loop completed we may have few more elements in
        // left array copy them.
        while (leftArrayBegin <= leftArrayEnd) {
            resultArray[resultArrayBegin++] = array[leftArrayBegin++];
        }

        // After the main loop completed we may have few more elements in
        // right array copy.
        while (rightArrayBegin <= rightArrayEnd) {
            resultArray[resultArrayBegin++] = array[rightArrayBegin++];
        }

        // Copy resultArray back to the main array
        for (int i = numElements - 1; i >= 0; i--, rightArrayEnd--) {
            array[rightArrayEnd] = resultArray[i];
        }
    }
    private static void printArr(int[] ar, int left, int right) {
    	for (int i=left ; i<right;i++) {
    		System.out.print(ar[i]);
    	}
    	System.out.println(" ");
    }

    /*
     * The mergeSort algorithm implementation
     */
    public static void mergeSort(int[] array, int left, int right) {
    	printArr(array, left, right);
        if (left < right) {

            //split the array into 2
            int center = (left + right) / 2;

            //sort the left and right array
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);

            //merge the result
            merge(array, left, center + 1, right);
        }
    }
    
	
	public static void main(String[] args) {
		int[] arr = {7,6,5,4,3,2,1};
		mergeSort(arr, 0, 6);
		System.out.println(arr);
	}
	
}
