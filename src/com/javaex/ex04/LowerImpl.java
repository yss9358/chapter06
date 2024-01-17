package com.javaex.ex04;

public class LowerImpl implements Runnable{
	
	public LowerImpl() {
		
	}
	
	public void run() {
		for (char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				System.out.println("");
			}
		}
	}

	
}
