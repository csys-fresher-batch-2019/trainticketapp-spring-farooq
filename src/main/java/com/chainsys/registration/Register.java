package com.chainsys.registration;

import java.sql.Date;

public class Register {

	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}

	private int userid;
	private String username;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}


	/**
	 * @param emailid the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	/**
	 * @return the phonenum
	 */
	public long getPhonenum() {
		return phonenum;
	}


	/**
	 * @param phonenum the phonenum to set
	 */
	public void setPhonenum(long phonenum) {
		this.phonenum = phonenum;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}


	/**
	 * @return the cityname
	 */
	public String getCityname() {
		return cityname;
	}


	/**
	 * @param cityname the cityname to set
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	private String password;
	private String emailid;
	private long phonenum;
	private String gender;
	private Date dob;
	private String cityname;
	
	
	

	public Register(int user_id, String username, String password, String emailid, long phonenum, String gender,
			Date dob,String cityname) {
		this.userid = user_id;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.phonenum = phonenum;
		this.gender = gender;
		this.dob = dob;
		this.cityname = cityname;
	}

	public Register() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TestReg [user_id=" + userid + ", username=" + username + ", password=" + password + ", emailid="
				+ emailid + ", phonenum=" + phonenum + ", gender=" + gender + ", dob=" + dob + ", cityname="
				+ cityname + "]";
	}


}
