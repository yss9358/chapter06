package com.javaex.ex03;

public class DigitThreadImpl implements Runnable {
	
	public void run() {
		
		for (int i=0; i<=20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(600);
			} catch(Exception e) {
				
			}
		}
		
	}
	
	
}
