package readTextFile;

public class ReadTextFileTest {
	
	public static void main(String args[]){
		
		ReadTextFile read = new ReadTextFile();
		
		read.openFile();
		read.readRecords();
		read.closeFile();
		
	}

}
