package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fis = null;
		
		try {
			 fis = new FileInputStream("hello.txt");
			//int data = fis.read();
			
		} catch (FileNotFoundException e) {
		   
			System.out.println("error: " + e);
				
		} catch(IOException e) {
			System.out.println("error: "+ e);
		}
		finally {
		     try {
		    	 if(fis != null) {
		    		 fis.close();
		    	 }
		     } catch(IOException e) {
		    	 e.printStackTrace();
		     }
		}
	}

}
