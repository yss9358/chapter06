package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException{
		
		// 소켓 객체 생성
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=============================================");
		System.out.println("[서버에 연결을 요청합니다.]");

		// connect
		
		// InetSocketAddress aaa = new InetSocketAddress("192.168.0.14" , 10001));
		// aaa 대신 new ~ 뒷부분을 아래에 대입
		socket.connect(new InetSocketAddress("192.168.0.14", 10001));
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		// 메세지 보내기 Stream Out
		// Client 에서 서버로 내용을 보내야 하기 때문에 OutputStream 사용
		// OutputStream out = new FileOutputStream("파일경로"); // 파일을 읽을 때 쓰던 방법
		OutputStream os = socket.getOutputStream(); // Client 와 server 의 socket 끼리 연결 되었기 떄문에 사용중인 outputStream 을 get으로 받아온다
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); // os 주소값을 보낼때 UTF-8을 사용한다
		BufferedWriter bw = new BufferedWriter(osw); // Buffered 는 일정량을 모아서 보낸다. 모아진 양이 적으면 null 이 뜰수도있음.
		
		// 메세지 받기 Stream in
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		// 스캐너 입력
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		// 메세지 보내기
		bw.write(str);
		bw.newLine(); // 줄바꿈을 해주지 않으면 어디까지가 한줄인지 인식하지 못함.
		bw.flush(); // 일정량이 모이지 않아도 BufferedWriter가 값을 보낸다.
		
		// 메세지 받기
		String reMsg = br.readLine();
		System.out.println("[ server: " + reMsg + " ]" );
		
		//닫기 
		sc.close();
		bw.close();
		br.close();
		socket.close();
		
	}

}
