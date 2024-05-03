package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
	
	
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner= null;
		Socket socket= null;
		
		try {
			
			scanner = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);	//auto 플러시 true
			
			//5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname=scanner.nextLine();
			printWriter.println("join:" + nickname); // 서버로 데이터를 전송한다. 
			printWriter.flush(); // 바로 버퍼를 비워준다..! 
			
			String data= br.readLine(); 	//blocking
			if (data.equals("join:ok")) {
				System.out.println("입장 완료");
			}
			
			//6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();
			
			//7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if ("quit".equals(input)==true) {	//==true
					//8. quit 프로토콜 처리
					printWriter.println("quit");
					break;
				} else {
					printWriter.println("message:"+ input);
				}	
			}
		} catch (SocketException e) {
			log("Socket Exception: " + e);
		} catch (IOException e) {
			log("error:"+ e);
		} finally {
			//10. 자원정리
			try {
				scanner.close();
				
				if (socket!=null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void log(String message) {
		System.out.println("[Client] " + message);
	}


}