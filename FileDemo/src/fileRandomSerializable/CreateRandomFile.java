package fileRandomSerializable;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateRandomFile {

	
	private static final int NUMBER_RECORDS = 100;
	
	public void createFile(){
		
		RandomAccessFile file = null;
		
		try{
			
			file = new RandomAccessFile("clients.dat","rw");
			
			RandomAccessAccountRecord blankRecord = new RandomAccessAccountRecord();
			
			for(int count = 0; count < NUMBER_RECORDS; count++)
				blankRecord.write(file);
			
			System.out.println("Created file clients.dat.");
			
			System.exit(0);
			
		}
		catch(IOException ioException){
			
			System.err.println("Error processing file.");
			System.exit(1);
		}
		finally{
			
			try{
				
				if(file != null)
					file.close();
			}
			catch(IOException ioException2){
				
				System.err.println("Erro closing file.");
				System.exit(1);
				}
		}
	}
	
}
