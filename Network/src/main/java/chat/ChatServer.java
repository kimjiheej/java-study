package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ChatServer {
	
	
	public static final int PORT=8088;
	
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket=null;
		// 서버에 연결된 모든 클라이언트의 출력 스트림이 저장되게 된다. 
		// Writer 는 출력 스트립을 나타낸다. writer 리스트에는 서버에서 클라이언트로 데이터를 보내는데 출력되는 스트림이 저장된다. 
		List<Writer> writers = new ArrayList<Writer>();
		
		
		
		try {
			
			serverSocket= new ServerSocket();
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			
			// 서버 소켓이 특정 포트에서 클라이언트의 연결 요청을 수신하기 위해 
			// 해당 포트와 호스트 주소에 바인딩이 된다. 
		
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			log("연결 기다림 " +  hostAddress +":" + PORT);
			
		
			while(true) { // 서버가 항상 실행되는 상태를 유지하고 클라이언트의 연결 요청을 수락하고 처리한다.
				Socket socket= serverSocket.accept();	// 서버 소켓이 클라이언트의 연결 요청을 기다리다가 클라이언트의 요청을 수락한다.
				
				// 서버의 작성자 목록을 전달한다. start 는 새로운 스레드가 생성이 되고 run 메서드가 실행된다. 
				new ChatServerThread(socket, writers).start();
			}
			
			
		} catch (IOException e) {
			log("error 이유 : "+ e);
		} finally {
			try {
				if (serverSocket!=null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void log(String m) {
		System.out.println("[Server Chat] "+ m);
	}
	
}
