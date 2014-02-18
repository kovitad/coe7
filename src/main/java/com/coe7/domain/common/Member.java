package com.coe7.domain.common;

import java.util.Date;

public class Member extends BaseDomain{

	private static final long serialVersionUID = -2308559840825088547L;
	
	private String firstName;
	private String lastName;
	private Date dob;
	private String username;
	private String password;
	private Boolean active;
	private Boolean numberOfLoginFailed;
	
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getNumberOfLoginFailed() {
		return numberOfLoginFailed;
	}
	public void setNumberOfLoginFailed(Boolean numberOfLoginFailed) {
		this.numberOfLoginFailed = numberOfLoginFailed;
	}
	
	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", username=" + username + ", password="
				+ password + ", active=" + active + ", numberOfLoginFailed="
				+ numberOfLoginFailed + "]";
	}
}
