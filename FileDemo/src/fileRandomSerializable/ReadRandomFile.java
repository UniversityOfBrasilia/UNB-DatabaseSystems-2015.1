package fileRandomSerializable;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadRandomFile {

	private RandomAccessFile input;
	
public void openFile(){
		
		try{
			input = new RandomAccessFile("clients.dat", "rw");
			
		}
		catch(IOException ioException){
			
			System.err.println("File does not exist.");
		}
	}
	
	public void closeFile(){
		
		try{
			if(input != null)
				input.close();
		}
		catch(IOException ioException){
			
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}
	
	public void readRecords(){
		
		RandomAccessAccountRecord record = new RandomAccessAccountRecord();
		
		 System.out.printf( "%-10s%-15s%-15s%10s\n", "Account",
		         "First Name", "Last Name", "Balance" );
		   
		 try{
			 
			 while(true){
				 
				 do{
					 
					 record.read(input);
				 }while(record.getAccount() == 0);
				 
				 System.out.printf( "%-10d%-12s%-12s%10.2f\n",
			               record.getAccount(), record.getFirstName(),
			               record.getLastName(), record.getBalance() );
			 }
			 
		 }catch(EOFException eofException){
			 
			 return;
		 }
		 catch(IOException ioException){
			 
			 System.err.println("Error reading file.");
			 System.exit(1);

			 
		 }
		
		
	}
		
}
