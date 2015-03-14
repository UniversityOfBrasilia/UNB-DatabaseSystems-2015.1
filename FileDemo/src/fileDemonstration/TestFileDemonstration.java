package fileDemonstration;
import java.util.Scanner;


public class TestFileDemonstration {

	public static void main(String args[]){
		
		
		Scanner input = new Scanner(System.in);
		FileDemonstration application = new FileDemonstration();
		
		System.out.print("Enter file or direcotyr name here: ");
		
		application.analyzePath(input.nextLine());
		
	}
	
}
