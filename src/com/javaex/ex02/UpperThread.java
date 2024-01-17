package com.javaex.ex02;

public class UpperThread extends Thread {
	
	// 생성자
	
	public UpperThread() {
		
	}
	
	public void run() {
		for (char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch(Exception e){
				System.out.println("");
			}
		}
	}
	
}
