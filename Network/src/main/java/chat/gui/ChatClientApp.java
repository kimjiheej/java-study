package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import chat.ChatServer;

public class ChatClientApp {
	
	public static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		
		
		Socket socket = null;
		String name = null;
		Scanner sc = null;

		try {

			
			sc = new Scanner(System.in);

			// 콘솔에 적고 
	            while (true) {
				System.out.println("대화명을 입력하세요.!");
				System.out.print(">>>  ");
				
				// 처음 창에 띄우기 위한 이름이다. 콘솔에서 입력을 받는다. 
				name = sc.nextLine();

				if (!name.isEmpty()) { // 처음에 이름이 입력되지 않는걸 방지하기 위함이다. 
					break;
				}
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
	            
			sc.close();

			
			// 소켓을 연결하고 
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("연결이 완료되었습니다");
			// 입출력 할 것을 설정해준다 
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			// 서버에다가 join 하는 이름을 출력해준다 
			printWriter.println("join:" + name);
			printWriter.flush();
			// 확인 체크를 해준다 
			String ack = bufferedReader.readLine();
			if ("join:ok".equals(ack)) {
				new ChatWindow(name, socket).show();
			}
		} catch (SocketException e) {
			log("SocketExceptionError:" + e);
		} catch (IOException e) {
			log("IOException:" + e);
		}
	}

	private static void log(String message) {
		System.out.println("ClientApp"  + message);
	}
}
