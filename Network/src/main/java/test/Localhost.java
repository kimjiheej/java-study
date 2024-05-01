package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	public static void main(String[] args) {
		
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName(); // 컴퓨터 이름이 나오게 된다 
			String hostIpAddress = inetAddress.getHostAddress();

			System.out.println(hostName);

			System.out.println(hostIpAddress); // localhost 이다 

			byte[] IpAddresses =  inetAddress.getAddress();

			for(byte IpAddress : IpAddresses) {
				System.out.println(IpAddress & 0x000000ff);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
