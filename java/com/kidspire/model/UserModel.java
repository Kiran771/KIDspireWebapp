package com.kidspire.model;

import java.time.LocalDate;

/**
 * @author kiransaud 23048603
 *  UserModel class represents the data model for a users
 * It contains attributes such as userId, userName, firstName, lastName,date of birth, contact number, 
 * password, and confirmation password
 * 
 * This model is used to encapsulate babysitter data and transfer it between different layers
 * of the application
 */

public class UserModel {
	
	// Private fields representing user attributes
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String contactNumber;
	private String email;
	private String password;
	private String confirmPassword;
	
	//default constructor
	public UserModel() {
		
	}
	
    /**
     * Constructor to initialize all fields including userId
     * 
     * @param userId Unique identifier for the user
     * @param userName UserName of the user
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param dob Date of birth of the user
     * @param contactNumber Contact number of the user
     * @param email  Email address of the user
     * @param password Password for the user account
     * @param confirmPassword Password confirmation
     */
	
	
	public UserModel(int userId, String userName, String firstName, String lastName, LocalDate dob,
			String contactNumber, String email, String password, String confirmPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	/**
     * Constructor without userId (useful during registration before userId is generated)
     * 
     * @param userName User name of the user
     * @param firstName First name of the user
     * @param lastName Last name of the user
     * @param dob Date of birth of the user
     * @param contactNumber Contact number of the user
     * @param email Email address of the user
     * @param password Password for the user account
     * @param confirmPassword Password confirmation
     */
    
	
	public UserModel(String userName, String firstName, String lastName, LocalDate dob, String contactNumber,
			String email, String password, String confirmPassword) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	/**
     * Constructor without confirmPassword (useful if confirmation is not required at this point)
     * 
     * @param userName  User name of the user
     * @param firstName First name of the user
     * @param lastName  Last name of the user
     * @param dob Date of birth of the user
     * @param contactNumber Contact number of the user
     * @param email Email address of the user
     * @param password Password for the user account
     */
 
	
	public UserModel(String userName, String firstName, String lastName, LocalDate dob, String contactNumber,
			String email, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}
	


	/**
	 * Constructor used for login where only username and password are required
	 * 
	 * @param userName  User name of the user
	 * @param password  Password for the user account
	 */
	
	public UserModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * Parameterized constructor to initialize a UserModel object with user details.
	 * This constructor is used in updating user profile
	 * 
	 * @param userName The username of the user, typically a unique identifier.
	 * @param firstName The first name of the user.
	 * @param lastName The last name of the user.
	 * @param contactNumber The contact number of the user (e.g., phone number).
	 * @param email The email address of the user, used for communication or login.
	 */
    public UserModel(String userName, String firstName, String lastName, String contactNumber, String email) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
	}

	/**
     * Gets the user's ID
     * @return userId
     */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user's ID
	 * @param userId the ID to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
     * Gets the user's user name
     * 
     * @return userName
     */
 
	public String getUserName() {
		return userName;
	}
	
	/**
     * Sets the user's user name
     * 
     * @param userName the user name to set
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
     * Gets the user's first name
     * @return firstName
     */
	public String getFirstName() {
		return firstName;
	}
	


	/**
	 * Sets the user's first name
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	/**
	 * Gets the user's last name 
	 * @return lastName
	 */
	public String getLastName() {
	    return lastName;
	}
	
	/**
	 * Sets the user's last name
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	
	/**
	 * Gets the user's date of birth
	 * @return dob
	 */
	public LocalDate getDob() {
	    return dob;
	}
	
	/**
	 * Sets the user's date of birth
	 * @param dob the date of birth to set
	 */
	public void setDob(LocalDate dob) {
	    this.dob = dob;
	}
	
	/**
	 * Gets the user's contact number
	 * @return contactNumber
	 */
	public String getContactNumber() {
	    return contactNumber;
	}
	
	/**
	 * Sets the user's contact number
	 * @param contactNumber the contact number to set
	 */
	public void setContactNumber(String contactNumber) {
	    this.contactNumber = contactNumber;
	}
	
	/**
	 * Gets the user's email address
	 * @return email
	 */
	public String getEmail() {
	    return email;
	}
	
	/**
	 * Sets the user's email address
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
	    this.email = email;
	}
	
	/**
	 * Gets the user's password
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}
	
	/**
	 * Sets the user's password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
	    this.password = password;
	}
	
	/**
	 * Gets the user's confirm password field
	 * @return confirmPassword
	 */
	public String getConfirmPassword() {
	    return confirmPassword;
	}
	
	/**
	 * Sets the user's confirm password field
	 * @param confirmPassword the confirmation password to set
	 */
	public void setConfirmPassword(String confirmPassword) {
	    this.confirmPassword = confirmPassword;
	}
}