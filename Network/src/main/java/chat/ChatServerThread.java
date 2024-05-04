package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	
	private String nickname; // 연결된 클라이언트의 닉네임을 저장해야 한다. 
	private Socket socket; // 새롭게 연결하기 위한 소켓 
	private List<Writer> listWriters;
	
	
	
	BufferedReader bufferedReader =null;
	PrintWriter printWriter =null;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket=socket;
		this.listWriters = listWriters;
	}
	
	
	@Override
	public void run() {
		try {
	
			// 클라이언트와의 연결 정보 확인하기 
			// 소켓이 원격 호스트에 연결된 경우 해당 호스트의 주소를 나타내는 SocketAddress 객체르 반환한다. 
			InetSocketAddress inetRemoteSocketAddress= (InetSocketAddress) socket.getRemoteSocketAddress();
			
			// 연결된 호스트의 IP 주소를 나타내는 객체의 반환 
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			
			// 클라이언트와 연결된 소켓의 포트 번호를 반환한다. 
			int remotePort = inetRemoteSocketAddress.getPort();
		
	
			// 클라이언트와 통신하기 위함 
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);	//auto 플러시 true
			
		
			while(true) {
				String request= bufferedReader.readLine();		//blocking		
				if (request==null) {
					 log("클라이언트로 부터 연결 끊김");
					 doQuit(printWriter);
					break;
				}
				
				String[] tokens = request.split(":");
				
				if ("join".equals((tokens[0]))) {
					
					// printWriter 에는 클라이언트와 연결된 소켓으로부터 얻은 출력 스트림이 들어있으며 이를 통해 서버는 클라이언트에게 메세지를 전송한다. 
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					
					doMessage(tokens[1]);
					
				} else if ("quit".equals(tokens[0])) {
					
					doQuit(printWriter);
					break; //추가
				} else {
					
					log("에러: 알수 없는 요청(" + tokens[0]+ ")" );
				}
			}
			
		} catch (SocketException e) {
		    // SocketException이 발생하면 무시하도록 처리
		    // log("Connection reset: " + e);
		    // log("서버와의 연결이 끊겼습니다. 재연결을 시도합니다.");
		    // 재연결 로직 추가
		    // 혹은 사용자에게 적절한 안내 출력
			doQuit(printWriter);
		} catch (IOException e) {
		    log("error: " + e);
		    doQuit(printWriter);

		} finally {
		    try {

		        if (socket != null && !socket.isClosed()) {
		            socket.close();
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		}
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data= nickname+ "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	

	private void doJoin(String nickName, Writer writer) {
		
		
		this.nickname=nickName;
		String data= nickName+"님이 입장 하였습니다";
		broadcast(data);
		
		addWriter(writer);
	
		printWriter.println("join:ok");
	}

	// 서버에 연결된 모든 client에게 메세지를 보내는 메소드. 
	// 스레드간 공유 객체인 listWriters 에 접근 하기 때문에 동기화 처리를 해주어야 한다. 
	private void broadcast(String data) {
		synchronized(listWriters) {
			
			for (Writer writer: listWriters) {
				PrintWriter printWriter= (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	
	private void doMessage(String data) {
		broadcast(nickname+":"+data);
	}
	
	
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}

	
	

	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
	}
	
	
	public static void log(String m) {
		System.out.println("[Server Chat] "+ m);
	}
}