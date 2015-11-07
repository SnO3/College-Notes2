public class Account
{
	private double balance;
	private String name;
	private long acctNum;
	/*
	Constructor
	initializes balance, owner, and account number
	 */
	public Account(double initBal, String owner, long number)
	{
		balance = initBal;
		name = owner;
		acctNum = number;
	}
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	public void withdraw(double amount)
	{
		if (balance >= amount)
			balance-= amount;
		else
			System.out.println("Insufficient funds");
	}

	// Adds deposit amount to balance.
	public void deposit(double amount)
	{
		balance += amount;
	}

	// Returns balance.
	public double getBalance()
	{
		return balance;
	}
	// Returns a string containing the name, account number, and balance.
	public String toString()
	{
		return String.format("Name: %s Account Number: %d Account Balance: %.2f",name,acctNum, balance);
	}
	public double chargeFee()
	{
		balance-= 10.00;
		return balance;
	}
	
	public void changeName(String newName)
	{
		name=newName;
	}
}