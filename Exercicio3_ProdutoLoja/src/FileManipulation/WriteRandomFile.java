package FileManipulation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Student.StudentRecord;

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

		StudentRecord record = new StudentRecord();
		String cPF;
		String name;
		int studentId;
		int age;
		String birthDate;
		String gender;
		String adress;
		String phoneNumber;
		String fathersName;
		String mothersName;

		Scanner input = new Scanner(System.in);

		System.out.printf( "%s\n%s\n%s\n%s\n\n",
				"Para parar com a entrada, pressione a tecla que indica fim de arquivo ",
				"quando pedir para entrar com um novo dada ",
				"Em UNIX/Linux/Mac OS X pressione <ctrl> d e pressione Enter",
				"Em Windows pressione <ctrl> z e aperte Enter" );

		System.out.printf( "\n%s\n%s", "Entre consecutivamente com\n"
				+ "CPF\n"
				+ "Nome\n"
				+ "Matricula\n"
				+ "Idade\n"
				+ "Data de Nascimento\n"
				+ "Sexo\n"
				+ "Endereco\n"
				+ "Telefone\n"
				+ "Nome do Pai\n"
				+ "Nome da Mae\n",
				"? " );

		while(input.hasNext()){

			try{

				cPF  = input.next();
				name = input.next();
				studentId = input.nextInt();
				age = input.nextInt();
				birthDate = input.next();
				gender = input.next();
				adress = input.next();
				phoneNumber = input.next();
				fathersName = input.next();
				mothersName = input.next();

				if(studentId > 0){

					record.setCpf(cPF);
					record.setName(name);
					record.setStudentId(studentId);
					record.setAge(age);
					record.setBirthDate(birthDate);
					record.setGender(gender);
					record.setAdress(adress);
					record.setPhoneNumber(phoneNumber);
					record.setFathersName(fathersName);
					record.setMothersName(mothersName);

					
					output.seek((studentId - 1)* 
							StudentRecord.SIZE);
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
					+ "CPF\n"
					+ "Nome\n"
					+ "Matricula\n"
					+ "Idade\n"
					+ "Data de Nascimento\n"
					+ "Sexo\n"
					+ "Endereco\n"
					+ "Telefone\n"
					+ "Nome do Pai\n"
					+ "Nome da Mae\n",
					"? " );
		}

	}
}
