package fileRandomSerializable;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteRandomFile {

	private RandomAccessFile output;
	
	private static final int NUMBER_RECORDS = 100;
	
	public void openFile(){
		
		try{
			output = new RandomAccessFile("clients.dat", "rw");
			
		}
		catch(IOException ioException){
			
			System.err.println("File does not exist.");
		}
	}
	
	public void closeFile(){
		
		try{
			if(output != null)
				output.close();
		}
		catch(IOException ioException){
			
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}
	
	public void addRecords(){
		
		RandomAccessAccountRecord record = new RandomAccessAccountRecord();
		int accountNumber = 0;
		String firstName;
		String lastName;
		double balance;
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf( "%s\n%s\n%s\n%s\n\n",
		         "To terminate input, type the end-of-file indicator ",
		         "when you are prompted to enter input.",
		         "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
		         "On Windows type <ctrl> z then press Enter" );

		      System.out.printf( "%s %s\n%s", "Enter account number (1-100),",
		         "first name, last name and balance.", "? " );
		 
		      while(input.hasNext()){
		    	  
		    	  try{
		    		  
		    		  accountNumber = input.nextInt();
		    		  firstName = input.next();
		    		  lastName = input.next();
		    		  balance = input.nextDouble();
		    		  
		    		  if ( accountNumber > 0 && accountNumber < NUMBER_RECORDS) {
		    			  
		    			  record.setAccount(accountNumber);
		    			  record.setFirstName(firstName);
		    			  record.setLastName(lastName);
		    			  record.setBalance(balance);
		    			  
		    			  output.seek((accountNumber - 1)* 
		    					  RandomAccessAccountRecord.SIZE);
		    			  record.write(output);
	
					}else{
						
						System.out.println("Account number mus be between 0 and 100.");
					}
		    		  
		    		  
		    	  }
		    	  catch(IOException ioException){
		    		  
		    		  System.err.println("Error writing to file.");
		    		  return;
		    	  }
		    	  catch(NoSuchElementException noSuchElementException){
		    		  
		    		  System.err.println("Invalid input. Please try again.");
		    		  input.nextLine();
		    		  
		    		  
		    	  }
		    	  
		          System.out.printf( "%s %s\n%s", "Enter account number (1-100),",
		                  "first name, last name and balance.", "? " );

		      }
		
	}
}
