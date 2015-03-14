package createTextFile;

public class AccountRecord {

	
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	public AccountRecord(){
		
		this(0,"","",0.0);
		
	}

	public AccountRecord(int i, String string, String string2, double d) {
		// TODO Auto-generated constructor stub
		setAccount(i);
		setFirstName(string);
		setLastName(string2);
		setBalance(d);
		
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
