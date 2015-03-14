package fileSequentialSerializable;

import java.io.IOException;

public class TestCreateSequentialFile {
	
	
	public static void main (String args[]) throws IOException{
	CreateSequentialFile sequentialFile = new CreateSequentialFile();
	
	sequentialFile.openFile();
	sequentialFile.addRecords();
	sequentialFile.closeFile();
	
	}

}
