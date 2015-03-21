package FileManipulation;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

import Student.StudentRecord;

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

		StudentRecord record = new StudentRecord();

		System.out.printf( "\n%-15s"
				+ "%-15s"
				+ "%-15s"
				+ "%-15s"
				+ "%-25s"
				+ "%-15s"
				+ "%-15s"
				+ "%-15s"
				+ "%-15s"
				+ "%10s\n", 
				"CPF",
				"Nome", 
				"Matricula", 
				"Idade",
				"Data de Nascimento",
				"Sexo","Endereço",
				"Telefone",
				"Nome do Pai",
				"Nome da Mãe" );

		try{

			while(true){

				do{
					record.read(input);

				}while(record.getStudentId() == 0);

				
				System.out.printf("%-15s"
						+ "%-12s"
						+ "%-15d"
						+ "%-15d"
						+ "%-25s"
						+ "%-12s"
						+ "%-12s"
						+ "%-12s"
						+ "%-12s"
						+ "%12s\n",
						record.getCpf(),
						record.getName(),
						record.getStudentId(), 
						record.getAge(),
						record.getBirthDate(),
						record.getGender(),
						record.getAdress(),
						record.getPhoneNumber(),
						record.getFathersName(),
						record.getMothersName() );

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
