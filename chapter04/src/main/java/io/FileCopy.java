package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("loopy.png");
			os = new FileOutputStream("loopy.copy.jpg");
			
			int data = -1;
			
			while((data = is.read()) != -1) {
				os.write(data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch(IOException e) {
			System.out.println("error:"+ e);
			
		} finally {
			try {
				if(is != null) {
					is.close();
				}
				
				if(os != null) {
					os.close();
				}
			} 
			catch( IOException e) {
				e.printStackTrace();
			}
		}

	}

}
