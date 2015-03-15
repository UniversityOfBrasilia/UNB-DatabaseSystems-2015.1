package Student;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentRecord implements Serializable {


	private String cPF;
	private String name;
	private int studentId;
	private int age;
	private String birthDate;
	private String gender;
	private String adress;
	private String phoneNumber;
	private String fathersName;
	private String mothersName;

	
	public static final int AMOUNT_OF_STRINGS = 8;
	public static final int SIZE_OF_STRINGS = AMOUNT_OF_STRINGS * 30;
	public static final int AMOUNT_OF_INTEGERS = 2;
	public static final int SIZE_OF_INTEGERS = AMOUNT_OF_INTEGERS * 4;
	public static final int SIZE = SIZE_OF_INTEGERS + SIZE_OF_STRINGS;
	
	public StudentRecord(){
		
		this("","",0,0,"","","","","","");
		
	}

	public StudentRecord(String cpf, String name, int studentId, int age,
			String birthDate, String gender, String adress, String phoneNumber,
			String fathersName, String mothersName) {
		// TODO Auto-generated constructor stub
		setCpf(cpf);
		setName(name);
		setStudentId(studentId);
		setAge(age);
		setBirthDate(birthDate);
		setGender(gender);
		setAdress(adress);
		setPhoneNumber(phoneNumber);
		setFathersName(fathersName);
		setMothersName(mothersName);
		
		
	}

	
	public void read(RandomAccessFile file) throws IOException{

		setCpf(readString(file));
		setName(readString(file));
		setStudentId(file.readInt());
		setAge(file.readInt());
		setBirthDate(readString(file));
		setGender(readString(file));
		setAdress(readString(file));
		setPhoneNumber(readString(file));
		setFathersName(readString(file));
		setMothersName(readString(file));

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
		
		writeString(file, getCpf());
		writeString(file,getName());
		file.writeInt(getStudentId());
		file.writeInt(getAge());
		writeString(file,getBirthDate());
		writeString(file,getGender());
		writeString(file,getAdress());
		writeString(file,getPhoneNumber());
		writeString(file,getFathersName());
		writeString(file,getMothersName());

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
	
	public String getCpf() {
		return cPF;
	}

	public void setCpf(String cpf2) {
		cPF = cpf2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId2) {
		this.studentId = studentId2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	
}
