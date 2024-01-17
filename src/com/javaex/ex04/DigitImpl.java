package com.javaex.ex04;

public class DigitImpl implements Runnable{
	
	public DigitImpl() {
		
	}
	
	public void run() {
		for (int i=0; i<=30; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println("");
			}
		}
		
		
	}
	

}
