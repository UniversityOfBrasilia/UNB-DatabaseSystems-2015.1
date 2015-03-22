package Product;

import FileManipulation.CreateRandomFile;
import FileManipulation.ReadRandomFile;
import FileManipulation.WriteRandomFile;

public class ProductRegister {
	
	public static void main(String args[]){
		
		String fileName =new String("products.dat");
		
		System.out.printf("%s",fileName);
		
		CreateRandomFile randomFileCreator = new CreateRandomFile();
		randomFileCreator.createFile(fileName);

		WriteRandomFile recordProductsFile = new WriteRandomFile();
		recordProductsFile.openFile(fileName);
		recordProductsFile.addRecords();
		recordProductsFile.closeFile();

		ReadRandomFile redProductsFile = new ReadRandomFile();
		redProductsFile.openFile(fileName);
		redProductsFile.readRecords();
		redProductsFile.closeFile();
		
		System.exit(0);
		
	}

}
