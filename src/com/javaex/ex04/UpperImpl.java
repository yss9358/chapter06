package com.javaex.ex04;

public class UpperImpl implements Runnable{
	
	public UpperImpl() {
		
	}
	
	public void run() {
		for (char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(700);
			} catch (Exception e) {
				System.out.println("");
			}
		}
	}

}
