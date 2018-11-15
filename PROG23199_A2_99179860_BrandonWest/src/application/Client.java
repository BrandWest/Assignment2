package application;

public class Client
{
	/**
	 *	Field Variables
	 *	Private String
	 *			_firstName - field varaible for first name
	 *			_lastName - field varaible for last name
	 *			_eMail - field varaible for email
	 *			_phoneNUmber - field varaible for phone number
	 */
	private String _firstName, _lastName, _eMail, _phoneNumber;

	/**
	 *	Field Variable
	 *	private Account
	 *		_clientAccount - clientAccount object
	 */
	private Account _clientAccount;

	/**
	 * Constructor to create a new clientAccount
	 * @param firstName - this holds the first name of the client
	 * @param lastName - this holds the last name of the client
	 * @param eMail - This holds the clients email
	 * @param phoneNumber - this holds the clients phone number
	 * @param balance - this holds the clients balance
	 * @param accountNumber - this holds the clients account number
	 */
	public Client ( String firstName, String lastName, String eMail, String phoneNumber, double balance, int accountNumber ) // account creation constrcutor
	{
		_clientAccount = new Account ( );
		this._firstName = firstName;
		this._lastName = lastName;
		this._eMail = eMail;
		this._phoneNumber = phoneNumber;
		_clientAccount.setBalance( balance );
		_clientAccount.setAccountId ( accountNumber) ;

	} // end of Account constructor

	/**
	 * Client  default constructor
	 * creates new object called _clientAccount
	 */
	public Client ( )
	{
		_clientAccount = new Account ( );
	}

	/**
	 * 	getter for the clients account information
	 * @return returns the field variable client account
	 */
	public Account getClientAccount( )
	{
		return _clientAccount;
	}

	/**
	 * sets the clients account
	 * @param clientAccount this holds the client account information for the object
	 */
	public void setClientAccount(Account clientAccount)
	{
		this._clientAccount = clientAccount;
	}

	/**
	 * Sets the clients first name
	 * @param firstName - the clients input for first name in a String
	 */
	public void setFirstName ( String firstName )
	{
		this._firstName = firstName;
	}

	/**
	 * Getter for the clients first name
	 * @return this returns this. objects first name
	 */
	public String getFirstName ( )
	{
		return this._firstName;
	}

	/**
	 * Setter for the clients last name
	 * @param lastName - this holds the clients last name in a String
	 */
	public void setLastName ( String lastName )
	{
		this._lastName = lastName;
	}

	/**
	 * Getter for the clients last name
	 * @return this returns this. objects last name of the client
	 */
	public String getlastName ( )
	{
		return this._lastName;
	}

	/**
	 * Setter for clients email
	 * @param eMail - this holds the clients eMail address in a String
	 */
	public void setEmail ( String eMail )
	{
		this._eMail = eMail;
	}

	/**
	 *  Getter for the clients email address
	 * @return returns this.objects email of the client
	 */
	public String getEmail ( )
	{
		return this._eMail;
	}

	/**
	 * Setter for the clients phone number
	 * @param phoneNumber this holds the clients phone number in a String
	 */
	public void setPhoneNumber ( String phoneNumber )
	{
		this._phoneNumber = phoneNumber;
	}

	/**
	 * Getter for the clients phone number
	 * @return returns phone Number of the client in a String
	 */
	public String getphoneNumber ( )
	{
		return this._phoneNumber;
	}

	/**
	 *	toString to return the clients information
	 * @return returns the clients information in a String
	 */
	public String toString ( )
	{
		return "Clients Account Number: " + getClientAccount().getAccountId() + ".\nClients First Name: " + this._firstName + ".\nClients Last Name: " + this._lastName +
				".\nClients E-Mail: " + this._eMail + ".\nClients Phone Number: " +
				this._phoneNumber +".\nClients Balance: $" + getClientAccount().getBalance();
	}// end of toString method
} // end of client class
