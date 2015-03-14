package fileRandomSerializable;

public class TestReadRandomFile {

	public static void main (String args[]){
		
		ReadRandomFile randomFile = new ReadRandomFile();
		
		randomFile.openFile();
		randomFile.readRecords();
		randomFile.closeFile();
		
	}
	
}
