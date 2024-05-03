package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {

	// 소켓을 가지고 있어야 함 !! 
	private Socket socket;
	private PrintWriter printWriter;
    private Frame frame;
    private Panel pannel; // 텍스트 필드와 버튼이 들어있다. 
    private Button buttonSend;
    private TextField textField;
    private TextArea textArea;



    // 내부 변수로 만들어서 필드로 저장해준다 !! 
    public ChatWindow(String name, Socket socket) {
    	
        frame = new Frame(name); // 바깥에 있는 큰 윈도우의 창이다 
        pannel = new Panel(); // buttonSend 와 textField 를 묶는다 
        buttonSend = new Button("Send"); // 버튼 이름 
        textField = new TextField();
        textArea = new TextArea(30, 80);
        this.socket = socket;
    }

    public void show() {
    	
    	//Button
        buttonSend.setBackground(Color.GRAY);
        buttonSend.setForeground(Color.WHITE);
        
        buttonSend.addActionListener(new ActionListener() { // button 에 리스너를 달아준 것이다. 익명 클래스이다. 
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Textfield
        textField.setColumns(80); // 한줄 짜리르 준 것이다. 
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyCode = e.getKeyChar();
                if (keyCode == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        // Pannel
        pannel.setBackground(Color.LIGHT_GRAY);
        pannel.add(textField);
        pannel.add(buttonSend);
        frame.add(BorderLayout.SOUTH, pannel);

        //TextArea
        textArea.setEditable(false);
        frame.add(BorderLayout.CENTER, textArea);

        // Frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { // 윈도우가 닫힐 때에 정보를 받기 위함이다. 
            	
            	
                finish();
                
                
                
            }
        });
        frame.setVisible(true);
        frame.pack();

        // IOStream 받아오기 
        // ChatClientThread 를 생성해야 한다 
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            new ChatClientThread(socket).start();
        } catch (SocketException e) {
            log("socketException" + e);
        } catch (IOException e) {
            log("error  : " + e);
        }
    }

    private void log(String string) {
		// TODO Auto-generated method stub
    	
    	  System.out.println("ChatWindow " + string);
		
	}

    private void finish() {
        try {
            if (socket != null && !socket.isClosed()) {
                printWriter.println("quit");
                socket.close();
            }
        } catch (IOException e) {
            log("Exception error: " + e);
        }
        System.exit(0);
    }

    private void sendMessage() {
        String message = textField.getText();
        System.out.println("메세지 보내는 프로토콜을 구현!:" + message);
        
        printWriter.println("message:" + message);
        textField.setText("");
        textField.requestFocus();
    }

    private void updateTextArea(String message) {
        textArea.append(message);
        textArea.append("\n");
    }
    
    private class ChatClientThread extends Thread {
        
        private BufferedReader bufferedReader;
        private Socket socket;

        public ChatClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                while (true) {
                    String message = bufferedReader.readLine();
                    if (message == null) {
                        break; // 소켓이 닫혔을 때 루프를 탈출합니다.
                    }
                    
                    updateTextArea(message);
                }
            } catch (SocketException e) {
                // 소켓이 닫혔을 때 발생하는 예외 처리를 따로 하지 않습니다.
            } catch (IOException e) {
                log("IOException : " + e);
            } finally {
                finish(); // 소켓이 닫히면 종료합니다.
            }
        }
    }


}
