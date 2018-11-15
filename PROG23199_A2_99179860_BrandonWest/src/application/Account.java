// Brandon West
// 991179860
// Java Programming PROG23199 Assignment 2
// ATM Program Account Class
package application;

public class Account
{
	// field variables
	private int _id = 999;
	private double _balance = 0.0;
	private double _annualInterestRate = 3.0;

	// set account mutator method
	public void setAccountId ( int account )
	{
		_id = account; // sets the account to the _id
	}// end of set account method

	// get account accessor method
	public int getAccountId ( )
	{
		return _id; // returns the account _id
	}// get account method end

	// set balance mutator method (no negatives allowed)
	public void setBalance ( double balance )
	{
		double tempBalance = 0.0;

		tempBalance = balance;

		if ( balance < 0.00 ) // balance received is negative set to original balance
			this._balance = tempBalance;
		else
			this._balance = balance; // balance set to user input
	} // end of set balance method

	//	 get balance accessor method
	public double getBalance ( )
	{
		return this._balance; // returns _balance
	} // end of get balance method

	// calculate interest method
	public void getMonthlyInterest( )
	{
		double interestGained = 0.0; // variable to hold interest gains

		interestGained = ( _annualInterestRate / 1200 ) * this._balance; // calculates the yearly interest
		if ( interestGained == 0.00 )
		{
			System.out.printf( "No interest accumulated." );
		}
		else if ( interestGained >= 0.00 )
		{
			System.out.printf ( "The interest gained for Account %d is: $%.2f \n", _id, interestGained );
			deposit( interestGained ); // deposits the interest made into the account
		}// end of else if for positive numbers
		else // error else statement
			System.out.println ( "Invalid input." );
	} // end of getMonthlyInterest method

	// withdraw method
	public void withdraw ( double money )
	{
		double tempBalance = 0.0; // holds the temp balance if the amount withdrawn is greater than the _balance

		tempBalance = getBalance() ; // Temporary balance holder in case of negative number
		this._balance = ( this._balance - money ); // calculates new withdraw amount

		if ( this._balance < 0.00 )// insufficient funds error, sets balance back to original
		{
			System.out.printf ( "There is not enough funds available in the account with the id: %d.\n", _id );
			this._balance = tempBalance;
			System.out.printf( "Balance: $%.2f\n", _balance );
		} // end of insufficient funds

		else if ( money < 0.00) // if the amount requested to be withdrawn is a negative number
		{
			System.out.println ( "Must be a positive integer." );
			this._balance = tempBalance; // sets balance back to initial value
		}
		else // else statement to show what balance is remaining after withdrawing from account
			System.out.printf ( "Successful. Remaining balance in the account %d is: $%.2f\n", this._id, getBalance ( ) ); // prints remaining balance
	} // end of withdraw method

	// deposit method
	public void deposit ( double money ) // takes money as an argument
	{
		if ( money >= 0.00) // if money to be deposited is greater than or equal to 0.00
			System.out.printf( "New balance for Account %d is: $%.2f\n", this._id, this._balance = this._balance + money); //print statement for new balance in account
		else if ( money < 0.00 ) // else if trying to deposit a negative number
			System.out.println ( "Only positive integers allowed." );
		else // else statement for invalid input
			System.out.println ( "Invalid Option." ); //error for input
	} // end of deposit method
}// end of Account Class.