package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s;
        
        do {
            System.out.print("> ");
            s = sc.nextLine();
            
            try {
                InetAddress[] inetAddresses = InetAddress.getAllByName(s);
                for(InetAddress a : inetAddresses) {
                    System.out.println(a);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        } while (!s.equals("exit"));
        
        sc.close(); // Scanner를 사용한 후에는 close() 메소드를 호출하여 리소스를 해제하는 것이 좋습니다.
    }
}