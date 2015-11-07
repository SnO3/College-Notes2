
public class ManageAccounts 
{
	public static void main(String[] args){
		Account acct1, acct2;
		acct1 = new Account(1000, "Sally", 1111);
		acct2 = new Account(500, "Joe", 1113);
		
		acct2.deposit(100.0);
		System.out.println("Joe's Balance: "+acct2.getBalance());
		
		acct1.withdraw(50.0);
		System.out.println("Sally's Balance: "+acct1.getBalance());
		
		acct1.chargeFee();
		acct2.chargeFee();
		
		acct2.changeName("Joseph");
		
		acct1.toString();
		acct2.toString();
	}

}
