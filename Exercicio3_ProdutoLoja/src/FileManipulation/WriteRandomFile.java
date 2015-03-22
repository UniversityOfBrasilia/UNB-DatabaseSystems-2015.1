package FileManipulation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Product.ProductRecord;

public class WriteRandomFile {

	private RandomAccessFile output;

	public void openFile(String filename){

		try{
			output = new RandomAccessFile(filename, "rw");

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

		ProductRecord record = new ProductRecord();
		String description;
		int productId;
		int amount;
		

		Scanner input = new Scanner(System.in);

		System.out.printf( "%s\n%s\n%s\n%s\n\n",
				"Para parar com a entrada, pressione a tecla que indica fim de arquivo ",
				"quando pedir para entrar com um novo dada ",
				"Em UNIX/Linux/Mac OS X pressione <ctrl> d e pressione Enter",
				"Em Windows pressione <ctrl> z e aperte Enter" );

		System.out.printf( "\n%s\n%s", "Entre consecutivamente com\n"
				+ "Descrição\n"
				+ "Id\n"
				+ "Quantidade\n",
				"? " );

		while(input.hasNext()){

			try{

				description  = input.next();
				productId = input.nextInt();
				amount = input.nextInt();
			
				if(productId > 0){

					record.setDescription(description);
					record.setProductId(productId);
					record.setAmount(amount);
					
					
					output.seek((productId - 1)* 
							ProductRecord.SIZE);
					record.write(output);
				}
				else{

					System.out.println("Cpf deve ser maior que 0");
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

			System.out.printf( "\n%s\n%s", "Entre consecutivamente com\n"
					+ "Descrição\n"
					+ "Id\n"
					+ "Quantidade\n",
					"? " );
		}

	}
}
