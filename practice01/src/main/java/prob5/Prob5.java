package prob5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Prob5 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		for(int i = 1; i<=99; i++) {
			String s = String.valueOf(i);
			
			String k ="";
			boolean check = false;
			
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				
				if(c=='3' || c=='6' || c=='9')
				{
					check = true;
					k += "짝";
				}	
			}
			
		    if(check) {
		    	bw.append(String.valueOf(i)+" ");
		    	bw.append(k);
		    	bw.append("\n");
		    }
		}
		
		bw.flush();
	}
}
