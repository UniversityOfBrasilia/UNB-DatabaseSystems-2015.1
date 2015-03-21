package FileManipulation;

import java.io.IOException;
import java.io.RandomAccessFile;
import Student.StudentRecord;

public class CreateRandomFile {

	
	
	public void createFile(String fileName){
		
		RandomAccessFile file = null;
		try{
			
			file = new RandomAccessFile(fileName,"rw");
			
			StudentRecord blankRecord = new StudentRecord();
			
			long numberOfRecords = 10;

			for(int count = 0; count < numberOfRecords; count++)
				blankRecord.write(file);
			
			System.out.println("Created file "+fileName);
						
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
