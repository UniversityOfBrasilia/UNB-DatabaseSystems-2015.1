package fileRandomSerializable;

import java.io.IOException;
import java.io.RandomAccessFile;

import createTextFile.AccountRecord;

public class RandomAccessAccountRecord extends AccountRecord {

	public static final int SIZE = 72;

	public RandomAccessAccountRecord(){

		this (0, "", "", 0);

	}

	public RandomAccessAccountRecord(int i, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
		super(i, string, string2, j);
	}

	public void read(RandomAccessFile file) throws IOException{

		setAccount(file.readInt());
		setFirstName(readName(file));
		setLastName(readName(file));
		setBalance(file.readDouble());
	}

	private String readName (RandomAccessFile file) throws IOException{

		char name[] = new char[15], temp;

		for(int count = 0; count < name.length; count++){

			temp = file.readChar();
			name[count] = temp;
		}
		return new String(name).replace('\0', ' ');
	}
	
	public void write(RandomAccessFile file) throws IOException{
		
		file.writeInt(getAccount());
		writeName(file,getFirstName());
		writeName(file,getLastName());
		file.writeDouble(getBalance());
	
	}
	
	public void writeName(RandomAccessFile file, String name) throws IOException{
		
		StringBuffer buffer = null;
		
		if(name != null)
			buffer = new StringBuffer(name);
		else
			buffer = new StringBuffer(15);
		
		buffer.setLength(15);
		
		file.writeChars(buffer.toString());
		
	}

}
