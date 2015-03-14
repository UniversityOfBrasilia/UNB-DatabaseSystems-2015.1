package fileSequentialSerializable;

import java.io.IOException;

public class TestReadSequentialFile {
	
	public static void main(String args[]) throws ClassNotFoundException, IOException{
		
		ReadSequentialFile sequential = new ReadSequentialFile();
		
		sequential.openFile();
		sequential.readRecords();
		sequential.closeFile();
		
		
	}

}
