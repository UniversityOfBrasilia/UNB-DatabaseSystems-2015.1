package fileSequentialSerializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CreateSequentialFile {

		private ObjectOutputStream output;
	
		
		public void openFile() throws IOException{
			
			
			try
			{
				
				output = new ObjectOutputStream(
						new FileOutputStream("clients.ser"));
				
				
			}
			catch (IOException ioException){
				
				System.err.println("Error opening File.");
			}
			
		}
		
		public void addRecords() throws IOException{
			
			AccountRecordSerializable record = new AccountRecordSerializable();
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

			      System.out.printf( "%s\n%s", 
			         "Enter account number (> 0), first name, last name and balance.",
			         "? " );
			      
			      
			      while(input.hasNext()){
			    	  
			    	  
			    	  try{
			    		  
			    		  accountNumber = input.nextInt();
			    		  firstName = input.next();
			    		  lastName = input.next();
			    		   balance = input.nextDouble();
			    		  
			    		  if(accountNumber>0){
			    			  record = new AccountRecordSerializable(accountNumber,firstName,lastName,balance);
			    			  output.writeObject(record);
			    			  
			    		  }
			    		  else{
			    			  
			    			  System.out.println("Account number must be greater than 0");
			    			  
			    		  }
			    		  
			    		  
			    	  }
			    	  catch( IOException ioException){
			    		  
			    		  System.err.println("Error writing to file.");
			    		  return;
			    		  
			    	  }
			    	  catch(NoSuchElementException elementException){
			    		  System.err.println("Invalid input Please try again.");
			    		  input.nextLine();
			    		  
			    	  }
			    	  
			    	  System.out.printf("%s %s\n%s","Enter account number (>0),",
			    			  "first name, last name and balance", "?");
			    	  
			      }
			
		}
		
		
		
		public void closeFile(){
			
			try{
				if(output != null){
					output.close();
					
				}
				
			}
			catch (IOException ioException){
				
				System.err.println("Error clossing file.");
				System.exit(1);
			}
			
			
		}
		
}
