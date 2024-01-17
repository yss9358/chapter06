package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		// 서버 소켓 생성
		ServerSocket serverSocket = new ServerSocket();

		//InetSocketAddress aaa = new InetSocketAddress("192.168.0.14", 10001);
		// bind - aaa 변수를 생성하는대신 아래 바인드() 안에 ("ip주소", 포트번호)를 적는다
		serverSocket.bind(new InetSocketAddress("192.168.0.14", 10001));
		
		// 서버시작
		System.out.println("<서버 시작>");
		System.out.println("============================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		// 클라이언트가 접속을 하면 accept()가 실행됨
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결 되었습니다.]");
		
		// 로직
		
		// 메세지 받기용 스트림 in
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		// 메세지 보내기용 스트림 out
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		// 받은메세지들을 계속 보내주기 위해 반복문 작성
		while(true) {
			// 메세지 받기 read
			String msg = br.readLine();
			if(msg == null) { // msg 와 null 은 주소 끼리의 비교이므로 equals가 아닌 == 사용
				break;
			}
			System.out.println("[ 받은 메세지: " + msg + " ]");
			
			// 메세지 보내기 write
			bw.write(msg); // 받은걸 그대로 보내주는 프로그램, 따라서 "내용" 가 아닌 받은 메세지 msg를 작성해준다.
			bw.newLine(); // 줄바꿈 작성한 것은 읽어들이지 않고 인식만함. 
			bw.flush(); // BufferedWriter 가 일정량 모이지 않아도 메세지를 보냄
		
		}
		
		System.out.println("===============================");
		System.out.println("<서버를 종료합니다.>");
		
		// 소켓 닫기
		bw.close();
		br.close();		
		socket.close();
		serverSocket.close();
		
	}

}
