package com.javaex.ex02;

public class LowerThread extends Thread{
	
	// 생성자
	
	public LowerThread() {
		
	}
	
	public void run() {
		for (char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(700);
			} catch(Exception e) {
				System.out.println("");
			}
		}
	}

}
