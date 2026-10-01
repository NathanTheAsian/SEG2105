package chapter2.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// IOEXCEPTION, SQLEXCEPTION
// Talk about different types of exception (error vs exception)
public class ExampleException {
	  public static void main(String args[]) 
	   {
		FileInputStream fis = null;
		/*This constructor FileInputStream(File filename)
		 * throws FileNotFoundException which is a checked
		 * exception
	         */
	        try {
				fis = new FileInputStream("B:/myfile.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		int k; 

		try {
			while(( k = fis.read() ) != -1) 
			{ 
				System.out.print((char)k); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		/*The method close() closes the file input stream
		 * It throws IOException*/
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	   }
}
