package com.kidspire.model;


/**
 * @author kiransaud 23048603
 * Model class representing a Babysitter entity.
 * It holds details about a babysitter such as ID, name, age, contact details, experience, and status.
 */
public class BabysitterModel {
	
	private int babysitterId;
	private String firstName;
	private String lastName;
	private short age;
	private String contactNumber;
	private String email;
	private String experience;
	private String status;
	
	
	 /**
     * Default constructor.
     */
	public BabysitterModel() {
		super();
	}

	
	/**
     * Parameterized constructor to initialize a BabysitterModel object with all attributes.
     * 
     * @param babysitterId Unique ID of the babysitter
     * @param firstName First name of the babysitter
     * @param lastName Last name of the babysitter
     * @param age Age of the babysitter
     * @param contactNumber Contact number of the babysitter
     * @param email Email address of the babysitter
     * @param experience Experience details of the babysitter
     * @param status Current status of the babysitter i.e. availability check
     */
	
	public BabysitterModel(int babysitterId, String firstName, String lastName, Short age, String contactNumber,
			String email, String experience, String status) {
		super();
		this.babysitterId = babysitterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.experience = experience;
		this.status = status;
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
     * Gets the babysitter's first name
     * @return firstName
     */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
     * Sets the babysitter's first name
     * @param firstName the first name to set
     */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
     * Gets the babysitter's last name
     * @return lastName
     */
	
	public String getLastName() {
		return lastName;
	}

	/**
     * Sets the babysitter's last name
     * @param lastName the last name to set
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
     * Gets the babysitter's current status i.e availability status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the babysitter's current status
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}