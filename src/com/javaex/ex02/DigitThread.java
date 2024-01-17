package com.javaex.ex02;


public class DigitThread extends Thread{

	// 생성자
	public DigitThread(){
		
	}
	
	// 메소드
	
	public void run() {
		for(int i=0; i<=30; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				System.out.println("");
			}
			
		
		}
	}
	
	
	
}
