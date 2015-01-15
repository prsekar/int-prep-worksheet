package com.algos.ds;

public class LinkedList {

	private ListNode head = null;
	public static void main(String[] rags) {
		int[] arr = new int[] {1,2,3,4,5,6,67,78,8,10};
		LinkedList list = new LinkedList();
		for (int i : arr) {
			list.add(new ListNode(i));
		}
	}
	
	public void add(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			add(head.getNext());
		}
	}
	
	public void printList(LinkedList list) {
		if (head == null) {
			
		} else {
			
		}
	}
}


class ListNode {
	private int i;
	private ListNode next;
	public ListNode(int i) {
		this.i = i;
	}
	public int getValue() {
		return i;
	}
	public ListNode getNext() {
		return next;
	}
}