package com.kidspire.model;


/**
 * @author kiransaud 23048603
 * Model class representing a Babysitter entity.
 * It holds details about a babysitter such as ID, name, age, contact details, experience, and status.
 */
public class BabysitterModel {
	
	// Unique identifier for the babysitter
	private int babysitterId;

	// Name of the babysitter
	private String name;

	// Age of the babysitter
	private short age;

	// Experience of the babysitter 
	private String experience;

	// Email address of the babysitter
	private String email;

	// Contact number (preferably validated to a specific format, e.g., starts with 98 and 10 digits long)
	private String contactNumber;

	// Status indicating availability
	private String status;
	
	
	
	 /**
     * Default constructor.
     */
	public BabysitterModel() {
		super();
	}

	
	/**
     * Constructor with all attributes including ID.
     * Used when all babysitter data is known, e.g., retrieved from a database.
     * 
     * @param babysitterId Unique ID of the babysitter
     * @param name Name of the babysitter
     * @param age Age of the babysitter
     * @param experience Experience details
     * @param email Email address
     * @param contactNumber Contact number
     * @param status Availability status
     */
	public BabysitterModel(int babysitterId, String name, short age, String experience, String email,
			String contactNumber, String status) {
		super();
		this.babysitterId = babysitterId;
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.email = email;
		this.contactNumber = contactNumber;
		this.status = status;
	}
	
	/**
     * Constructor without babysitter ID.
     * Useful when creating a new babysitter record before the ID is assigned.
     * 
     * @param name Name of the babysitter
     * @param age Age of the babysitter
     * @param experience Experience details
     * @param email Email address
     * @param contactNumber Contact number
     * @param status Availability status
     */
	public BabysitterModel(String name, short age, String experience, String email, String contactNumber,
			String status) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.email = email;
		this.contactNumber = contactNumber;
		this.status = status;
	}
	
	/**
     * Minimal constructor used for displaying only essential details.
     * 
     * @param name Name of the babysitter
     * @param experience Experience details
     */

	public BabysitterModel(String name, String experience) {
		super();
		this.name = name;
		this.experience = experience;
	}


	/**
	 * Returns the babysitter's ID
	 * @return babysitterId
	 */
	public int getBabysitterId() {
		return babysitterId;
	}

	/**
	 * Sets the babysitter's ID
	 * @param babysitterId the ID to set
	 */
	public void setBabysitterId(int babysitterId) {
		this.babysitterId = babysitterId;
	}

	/**
     * Gets the babysitter's  name
     * @return firstName
     */
	
	public String getName() {
		return name;
	}
	
	/**
     * Sets the babysitter's  name
     * @param Name the  name to set
     */

	public void setName(String name) {
		this.name = name;
	}

	

	/**
     * Gets the babysitter's age
     * @return age
     */
    public short getAge() {
        return age;
    }

    /**
     * Sets the babysitter's age
     * @param age the age to set
     */
    public void setAge(short age) {
        this.age = age;
    }

    /**
     * Gets the babysitter's contact number
     * @return contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the babysitter's contact number
     * @param contactNumber the contact number to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the babysitter's email address
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the babysitter's email address
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the babysitter's experience information
     * @return experience
     */
    public String getExperience() {
        return experience;
    }

    /**
     * Sets the babysitter's experience information
     * @param experience the experience to set
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**
     * Gets the babysitter's status 
     * @return status
     */
	public String getStatus() {
		return status;
	}

	/**
     * Sets the babysitter's status
     * @param status the status to set
     */
	public void setStatus(String status) {
		this.status = status;
	}
    
   

}