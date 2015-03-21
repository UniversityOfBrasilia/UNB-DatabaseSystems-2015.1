package Student;

import FileManipulation.CreateRandomFile;
import FileManipulation.ReadRandomFile;
import FileManipulation.WriteRandomFile;

public class StudentsRegister {
	
	public static void main(String args[]){
		
		String fileName =new String("students.dat");
		
		System.out.printf("%s",fileName);
		
		CreateRandomFile randomFileCreator = new CreateRandomFile();
		randomFileCreator.createFile(fileName);

		WriteRandomFile recordStudentsFile = new WriteRandomFile();
		recordStudentsFile.openFile(fileName);
		recordStudentsFile.addRecords();
		recordStudentsFile.closeFile();

		ReadRandomFile readStudentsFile = new ReadRandomFile();
		readStudentsFile.openFile(fileName);
		readStudentsFile.readRecords();
		readStudentsFile.closeFile();
		
		System.exit(0);
		
	}

}
