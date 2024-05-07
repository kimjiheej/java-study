package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
    private static final String SERVER_IP = "127.0.0.1";
	public static final int PORT = 6000;
	public static final int BUFFER_SIZE = 256;

    public static void main(String[] args) {
        Scanner scanner = null;
        DatagramSocket socket = null;

        try {
            scanner = new Scanner(System.in);
            socket = new DatagramSocket();

            while (true) {
                System.out.print(">");
                String message = scanner.nextLine();

                if ("quit".equals(message)) {
                    break;
                }

                // Send message
                byte[] sndData = message.getBytes("utf-8");
                DatagramPacket sndPacket = new DatagramPacket(
                        sndData,
                        sndData.length,
                        new InetSocketAddress(SERVER_IP, PORT));
                socket.send(sndPacket);

                // Receive message
                DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
                socket.receive(rcvPacket);
                byte[] rcvData = rcvPacket.getData();
                int offset = rcvPacket.getLength();
                String receivedMessage = new String(rcvData, 0, offset, "UTF-8");
                System.out.println("Server: " + receivedMessage);
            }

        } catch (SocketException e) {
            System.out.println("[UDP Echo Client] error: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
