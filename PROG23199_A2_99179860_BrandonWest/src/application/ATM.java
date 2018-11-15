package application;

import java.util.InputMismatchException;
import java.util.Scanner;
 // for my personal details, if I return it the way it is, I get a double that has no precision
public class ATM
{
	// Field variables
	Client [] _clientList = new Client [ 3 ]; // client list array object set to 3
	int _index = 0; // index counter for array

	public void menu ( ) // print menu function
	{
		System.out.println ( "_____________________________________________" );
		System.out.println ( "Welcome to the ATM. Please make a selection: " );
		System.out.println ( "1: Create new account." );
		System.out.println ( "2: Balance." );
		System.out.println ( "3: Withdraw." );
		System.out.println ( "4: Deposit." );
		System.out.println ( "5: Interest." );
		System.out.println ( "6: Show Personal Details." );
		System.out.println ( "7: Change Personal Details." );
		System.out.println ( "8: Exit." );
		System.out.print ( "Selection: " );
	} // end of menu function

	public void run ( )
	{
		// variables
		int choice = 0, accountId = 0; // Variables for choice from user and account id from user
		double money = 0.0; // double to hold money inpput from user
		Scanner input = new Scanner ( System.in ); // scanner input object


		while ( choice != 8 ) // while loop for controlling user input
		{
			try
			{
				menu(); // menu function call
				choice = input.nextInt(); // choice input from user
			}
			catch ( InputMismatchException error )
			{
				input.next();
			}

			switch (choice) // switch statement for users input
			{
				case 1:// accout creation case
					while (true) // try block control
					{
						try// try block
						{
							accountCreation(); // accout creation function call
							break; // break out of try block
						}// end of try block
						catch ( InputMismatchException error ) // input mismatch exception
						{
							System.out.print ( "Account numbers can only be positive numbers, try again.\n" );
						} // end of catch
					}// while loop try block
					break; // break out of switch statement

				case 2: // account balance view case
					while ( true ) // try block control
					{
						try // try block
						{
							System.out.print( "Which account would you like to check the balance on? " );
							accountId = input.nextInt(); // account ID input from user

							System.out.printf( "The balance of %d is $%.2f", _clientList [ checkAccountId ( accountId ) ].getClientAccount().getAccountId(),
									_clientList[ checkAccountId( accountId ) ].getClientAccount().getBalance() );// print statement, accessing the clientlist at a specific index after checking that the account is actually there
							System.out.println ( " " );
							break; // break out of try block
						}
						catch ( InputMismatchException error ) // input mismatch exception catch
						{
							System.out.println ( "Accounts must be numbers between 1 and 999. Try again." );
							input.next(); // clears buffer
						} // end of catch
						catch ( NullPointerException error ) // null pointer exception catch
						{
							System.out.println ( "No account found, try again." );
							continue;
						}// end of catch
					}// while loop try block
					break;// breaks out of the switch statement

				case 3: // case to withdraw from user
					while ( true ) // control the try block
					{
						try // try block
						{
							System.out.print( "Which account would you like to withdraw from? " );
							accountId = input.nextInt(); // account input from user
						}
						catch ( NullPointerException error ) // null pointer exception catch
						{
							System.out.println ( "Account number not found. Try again." );
						} // end of catch
						catch ( InputMismatchException error ) // input mismatch exception catch
						{
								input.next(); // clears buffer
						} // end of catch
						break; // breaks out of while loop
					}// while loop try block

					while ( true ) //controls the try block
					{
						try // try block
						{
							System.out.printf ( "How much would you like to withdraw from %d: $", _clientList [ checkAccountId ( accountId ) ].getClientAccount().getAccountId() ); // checks the account number and how much to withdraw
							_clientList[ checkAccountId ( accountId) ].getClientAccount().withdraw( input.nextDouble() ); // user input for withdrawl from account
							break;
						}
						catch ( InputMismatchException error ) // input mismatch exception catch
						{
							System.out.println ( "Invalid input, $.$$" );
							input.next();// clears buffer
						} // end catch
					}// end try block control
					break; // end of withdraw switch statement

				case 4: // deposit switch statement
					while ( true ) // control try block
					{
						try // start of try block
						{
							System.out.print( "Which account would you like to deposit into? " );
							accountId = input.nextInt(); // user input for the account to access
							_clientList [ checkAccountId ( accountId) ].getClientAccount().getAccountId(); //The account check to verify that the account is actually there
						}// end of try block
						catch ( NullPointerException error ) // null pointer exception catch
						{
							System.out.println ( "Accounts not found. Try again." );
							continue; //continues through while loop
						}// end of null pointer exception
						catch ( InputMismatchException error ) // input catch
						{
							System.out.println ( "Accounts must be numbers between 1 and 999. Try again." );
							input.next();// clear buffer
						}// end of input mismatch exception
						break;// breaks out of while loop
					}
					while ( true ) // while loop to control try block
					{
						try // try block
						{
							System.out.printf ( "How much would you like to deposit into account %d: $", accountId );
							 money = input.nextDouble ();
							 _clientList[ checkAccountId ( accountId) ].getClientAccount().deposit ( money );
							break;
						}//end of try block
						catch ( InputMismatchException error ) // catches wrong input
						{
							System.out.println ( "Invalid input, $.$$" );
							input.next(); // clears the buffer
						}// end of input mismatch error
					}// end of while control of try block
					break; // end of deposit switch statement

				case 5: // interest check on the account
					while ( true )// control try block
					{
						try // try block
						{
							System.out.print ( "Which account would you like to view the intreset gain on? " );
							accountId = input.nextInt(); // Account ID input from user
							_clientList [ checkAccountId ( accountId ) ].getClientAccount ().getMonthlyInterest(); // checks the account is in the system and prints the interest amount gained
							break;
						}// end of try
						catch ( NullPointerException error ) // Null pointer exception catch
						{
							System.out.println ( "Account not found, try again." );
							continue;
						}// end of catch
						catch ( InputMismatchException error ) // input mismatch exception catch
						{
							System.out.println ( "Accounts must be numbers between 1 and 999. Try again." );
							input.next(); // clears buffer
						}// end catch
					}// end try block control
					break; // interest check switch statement end

				case 6: // detail check switch statement
					while ( true ) // try block control
					{
						try// try block
						{
							System.out.print ( "Which account would you like to view the details of? " );
							accountId = input.nextInt(); // account input from user
							System.out.println (  _clientList [ checkAccountId ( accountId ) ] ); // checks the account is valid andreturns the account details
							break;
						}// end try block
						catch ( NullPointerException error ) // null pointer exception catch
						{
							System.out.println ( "Account not found. Try again." );
							continue;
						}// end catch
						catch ( InputMismatchException error ) // input mismatch exception catch
						{
							System.out.println ( "Accounts must be numbers between 1 and 999. Try again." );
							input.next(); // clears buffer
						}// end catch
					}// end of the while loop control
					break; // end of detail check switch statement

				case 7: // detail change switch statement
						while ( true ) // control try block
						{
							try// try block
							{
								System.out.print( "What account would you like to modify the personal details? ");
								accountId = input.nextInt(); // account ID input from user
								_clientList[ checkAccountId ( accountId ) ].getClientAccount().getAccountId(); // verify Account ID is valid
								break; // end of
							}// end try block
							catch ( NullPointerException error ) // null pointer exception catch
							{
								System.out.println ( "Account not found. Try again." );
								continue;
							}// end catch
							catch ( InputMismatchException error ) // input mismatch catch
							{
								System.out.println ( "Invalid input, accounts can only be 1-999." );
								input.next(); // clears buffer
							}// end catch
						}// end try block control
						while (choice != 5) // while loop to control the change if more than one variable
						{
							while ( true ) // try block control
							{
								try // try block
								{
									detailMenu( ); // detail menu called
									choice = input.nextInt(); // choice input by user
									detailChange( choice, accountId ); // detailchange method called, choice and accountID as parameters
									break; // break out of try block control
								}// end try
								catch ( InputMismatchException error ) // input mismatch exception catch
								{
									System.out.println ( "Invalid input, numbers between 1-5 only." );
									input.next(); // clears buffer
								}// end catch
							}// try block control end
						} // end of while loop for change detail
					 break;// end of change detail switch statement

				case 8: // exits the programs
					System.out.println ( "Thank you for using this ATM. Good-bye." );
					input.close(); // closes scanner
					break; // end of switch statement for exit

				default: // error check in the switch statement
					System.out.println ( "Invalid option, try again." );
					break; // end error check
			}// end of switch statement
		} // end of while loop
	} // end of run method

	public void detailMenu () // change detail menu method
	{
		System.out.println ( "What would you like to change about this client?" );
		System.out.println ( "1: First Name. " );
		System.out.println ( "2: Last Name. " );
		System.out.println ( "3: E-Mail Address." );
		System.out.println ( "4: Phone Number." );
		System.out.println ( "5: Exit." );
		System.out.print ( "Selection: " );
	} // end of change detail menu method

	public void detailChange( int choice, int accountId ) // change details of the user.
	{
		String firstName = "", lastName = "", phoneNumber = "", eMail = ""; // String variables that hold first, last, email, phone number

		Scanner input = new Scanner ( System.in ); // scanner input

		switch ( choice ) // switch statement with choice
		{
			case 1: // selection 1, first name
					System.out.print ( "What is the clients first name: " );
					firstName = input.next(); // user input for new first name
					_clientList [ checkAccountId ( accountId ) ].setFirstName( firstName ); //checks the account and sets the first name to new name
					break; // end of first name change switch statement

			case 2: // selection 2, last name
					System.out.print ( "What is the clients last name: " );
					lastName = input.next(); // user input for new last name
					_clientList [ checkAccountId ( accountId ) ].setLastName( lastName ); // sets new last name and checks the account id
					break; // end of the last name change

			case 3: // selection 3, email
					System.out.print ( "What is the clients new e-mail address: " );
					eMail = input.next(); // email from user input change
					_clientList [ checkAccountId ( accountId ) ].setEmail( eMail ); // checks the users account id and sets the email
					break; // end of email change switch statement

			case 4:// selection 4, phone number
					System.out.print ( "What is the clients new phone number: " );
					phoneNumber = input.next(); // user input for new phone number
					_clientList [ checkAccountId ( accountId ) ].setPhoneNumber( phoneNumber); // checks account ID and sets the new phone number
					break;// end of phone number change switch statement

			case 5: // selection 5, exit
					System.out.println ( "Thank you for using the client deatil change method." );
					break; // exits the change detail switch statement

			default:// invalid option
					System.out.println ( "Invalid option." );
					break; // error check switch statement exit
		}// end of switch statement for client details
	}// end of detail change

	public int checkAccountId ( int accountNumber ) //Check where in index the account number is located in _clientList[]
	{
		int index = 0; // holds the index for the for loop

			for ( index = 0; index < _clientList.length; index++ ) // post increment index compares to _clientLIst array length
			{
				if ( accountNumber == _clientList[ index ].getClientAccount().getAccountId() && index < _clientList.length ) // if statement for the access of a specific account
				{
					return index; // returns the index if the account is found
				}// end of if
			} // end of the for loop
		return index; // returns index
	} // end of check account ID method

	public void accountCreation( ) // pass the index to it when you need to add more accounts
	{
		int accountNumber = -1; // account number inital value
		String firstName = "", lastName = "", eMail = "", phoneNumber = ""; // strings for the first name, last name, email and phone number
		double balance = 0.0; // balance to hold clients balance

		Scanner input = new Scanner ( System.in ); // scanner object to take clients inputs

		if ( _index < 3 ) //if the field variable _index is less than 3
		{

			System.out.print ( "Please enter the clients account number: " );
			accountNumber = input.nextInt(); // inputs the custom account number by client

			while ( accountNumber > 999 || accountNumber <= 0 ) // only allows account numbers between 0 and 999
			{
				System.out.print ( "Error: Account number must be between 1 and W999. Try again:  " );
				accountNumber = input.nextInt(); // asking for clients input
			}

			System.out.print( "Please enter the first name of the client: " );
			firstName = input.next( ); // firstname
			System.out.print ( "Please enter the last name of the client: ");
			lastName = input.next( ); // last name
			System.out.print( "Enter the clients e-mail address: " );
			eMail = input.next( ); // email
			System.out.print ( "Enter the clients phone number: " );
			phoneNumber = input.next(); //phone number
			System.out.print ( "Please enter the intial balance of the account: $" );
			balance = input.nextDouble(); // inital balance for client
			while ( balance < 0.00 ) // catch if balance is a negative number.
			{
				System.out.print ( "Balance must be a positive number, try again: " );
				balance = input.nextDouble();
			}
			_clientList [ _index ] = new Client ( firstName, lastName, eMail, phoneNumber, balance, accountNumber); // non-default constructor that is created with fields entered
			_index++; //increments index for next client insertion
		}
		else // if there are more than 3 accounts attempting to be created, stop.
			System.out.println ( "System overloaded, no more memory for new accounts." );
	} // end of account creation method
} // end of ATM class