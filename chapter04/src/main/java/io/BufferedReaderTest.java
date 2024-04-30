package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		BufferedReader br = null;
		
		// 기반 스트림 
	   try {
		FileReader fr = new FileReader("./src/main/java/io/BufferedRederTest.java");
		// 보조 스트림 
		
	   br = new BufferedReader(fr);
	   
	   String line = null;
	   
	   while((line = br.readLine()) != null) {
		   System.out.println(line);
	   }
		
	} catch (FileNotFoundException e) {
		System.out.println("file not found: "+ e);
	} catch (IOException e) {
		System.out.println("erorr:" + e);
	}
	   finally {
		try {
			if( br != null) {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}

}
