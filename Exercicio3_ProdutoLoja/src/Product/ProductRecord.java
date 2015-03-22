package Product;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductRecord implements Serializable {


	private String description;
	private int productId;
	private int amount;


	
	public static final int AMOUNT_OF_STRINGS = 1;
	public static final int SIZE_OF_STRINGS = AMOUNT_OF_STRINGS * 30;
	public static final int AMOUNT_OF_INTEGERS = 2;
	public static final int SIZE_OF_INTEGERS = AMOUNT_OF_INTEGERS * 4;
	public static final int SIZE = SIZE_OF_INTEGERS + SIZE_OF_STRINGS;
	
	public ProductRecord(){
		
		this("",0,0);
		
	}

	public ProductRecord(String description, int productId, int amount) {
		// TODO Auto-generated constructor stub
		setDescription(description);
		setProductId(productId);
		setAmount(amount);
		
		
		
	}

	
	public void read(RandomAccessFile file) throws IOException{

		setDescription(readString(file));
		setProductId(file.readInt());
		setAmount(file.readInt());


	}

	private String readString (final RandomAccessFile file) throws IOException{

		char string[] = new char[15], temp;

		for(int count = 0; count < string.length; count++){

			temp = file.readChar();
			string[count] = temp;
		}
		return new String(string).replace('\0', ' ');
	}
	
	public void write(RandomAccessFile file) throws IOException{
		
		writeString(file, getDescription());
		file.writeInt(getProductId());
		file.writeInt(getAmount());


	}
	
	public void writeString(RandomAccessFile file, String string) throws IOException{
		
		StringBuffer buffer = null;
		
		if(string != null)
			buffer = new StringBuffer(string);
		else
			buffer = new StringBuffer(15);
		
		buffer.setLength(15);
		
		file.writeChars(buffer.toString());
		
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
