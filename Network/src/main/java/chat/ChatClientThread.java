package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {

	private BufferedReader bufferedReader;
	private Socket socket= null;
	
	public ChatClientThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() { // reader 를 통해 읽은 데이터 콘솔에 출력하기
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			
			String message;
			while (( message = bufferedReader.readLine())!= null) {
				System.out.println(message);
			}
		} catch (SocketException e) {
		//	log("Socket Exception: " + e);
		} catch (IOException e) {
			log("error: "+ e);
		}
	}
	
	public static void log(String m) {
		System.out.println("[Client Chat] "+ m);
	}
	
}