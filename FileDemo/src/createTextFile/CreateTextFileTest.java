package createTextFile;
import java.io.FileNotFoundException;


public class CreateTextFileTest {

	public static void main(String args[]) throws FileNotFoundException{
		
		CreateTextFile application = new CreateTextFile();
		
		application.openFile();
		application.addRecords();
		application.closeFile();
		
		
	}
	
}
