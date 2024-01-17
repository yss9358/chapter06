package com.javaex.ex01;

public class Ex01 {

	public static void main(String[] args) throws InterruptedException {
		
		
		// 숫자를 찍는 메소드를 실행시킨다
		// DigitThread 는 Thread 에 종속됨
		DigitThread a = new DigitThread();
		
		// start 는 Thread 의 메소드. 
		// start를 실행시키면 run 이 실행되게 코드가 짜여있음.
		// a.start 와 for문이 각각 실행됨( 순서대로x )
		
		a.start();
		
		for (char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			Thread.sleep(1000);
		}
		
		
		
		
		
		
		
	}

}
