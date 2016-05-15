package com.dropwizard.user.profiles.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "User_Profiles",
    uniqueConstraints =
        {@UniqueConstraint(columnNames={"userId"})}
)

public class UserDetails extends BaseDomain {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name="firstName", nullable = false)
	@NotNull
	private String  firstName;
	
	@Column(name="lastName", nullable = false)
	@NotNull
	private String  lastName;
	
	@Column(name="address")
	private String  address;
	
	@Column(name="city")
	private String  city;
	
	@Column(name="postcode")
	@NotNull
	private String  postCode;
	
	@Column(name="country", nullable = false)
	@NotNull
	private String  country;
	
	@Column(name="phoneNumber", nullable = false)
	@NotNull
	private Integer phoneNumber;
	
	@Column(name="emailId", nullable = false)
	@NotNull
	private String  emailId;
	
	@Column(name="privateUser", nullable = false)
	@NotNull
	private Boolean isPrivateUser;
	
	public UserDetails(){
		
	}
	
	public UserDetails(Integer userId, String firstName, String lastName, String address, 
			String city, String postCode, String country, Integer phoneNumber,
			String emailId, Boolean isPrivateUser) {
		
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.isPrivateUser = isPrivateUser;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Boolean getIsPrivateUser() {
		return isPrivateUser;
	}
	
	public void setIsPrivateUser(Boolean isPrivateUser) {
		this.isPrivateUser = isPrivateUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, firstName, lastName, address,city,
				postCode,country,phoneNumber,emailId,isPrivateUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		UserDetails that = (UserDetails) obj;
		
		return  Objects.equals(this.userId, that.userId) &&
				Objects.equals(this.firstName, that.firstName) &&
				Objects.equals(this.lastName, that.lastName) &&
				Objects.equals(this.address, that.address) &&
				Objects.equals(this.city, that.city) &&
				Objects.equals(this.postCode, that.postCode) &&
				Objects.equals(this.country, that.country) &&
				Objects.equals(this.phoneNumber, that.phoneNumber) &&
				Objects.equals(this.emailId, that.emailId) &&
				Objects.equals(this.isPrivateUser, that.isPrivateUser) ;
	}

}
