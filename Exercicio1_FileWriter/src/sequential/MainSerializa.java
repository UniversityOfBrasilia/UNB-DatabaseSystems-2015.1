package sequential;
import java.io.IOException;

public class MainSerializa {

	public static void main(String[] args) throws IOException{
		
		Employ[] employers = SerializeEmploy.getEmployers(3) ;	
		
		SerializeEmploy.writeEmployInFile(employers);
		
		
	}
	
	
}
