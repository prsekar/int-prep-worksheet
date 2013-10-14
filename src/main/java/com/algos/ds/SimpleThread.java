package com.algos.ds;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThread implements Runnable {
	
	public static void main(String[] args) {
		SimpleThread thread = new SimpleThread();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(thread);
		for (int i = 0;i < 1000; i++) {
			System.out.println("main Thread calling");	
		}
	}

	public void run() {
		for (int i = 0;i < 100; i++) {
			System.out.println("sub Thread calling");	
		}
	}
}
