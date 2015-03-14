package fileRandomSerializable;

public class TestWriteRandomFile {

	public static void main(String args[]){
		
		WriteRandomFile randomFile = new WriteRandomFile();
		
		randomFile.openFile();
		randomFile.addRecords();
		randomFile.closeFile();
		
		
	}
	
}
