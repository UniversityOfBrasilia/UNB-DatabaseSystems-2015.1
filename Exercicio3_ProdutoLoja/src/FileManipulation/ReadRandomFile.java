package FileManipulation;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

import Product.ProductRecord;

public class ReadRandomFile {

	private RandomAccessFile input;

	public void openFile(String fileName){

		try{
			input = new RandomAccessFile(fileName, "rw");

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

		ProductRecord record = new ProductRecord();

		System.out.printf( "\n%-15s"
				+ "%-15s"
				+ "%-15s\n", 
				"Descrição",
				"ID", 
				"Quantidade");

		try{

			while(true){

				do{
					record.read(input);

				}while(record.getProductId() == 0);

				
				System.out.printf("%-15s"
						+ "%-15d"
						+ "%-15d\n",
						record.getDescription(),
						record.getProductId(), 
						record.getAmount());

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
