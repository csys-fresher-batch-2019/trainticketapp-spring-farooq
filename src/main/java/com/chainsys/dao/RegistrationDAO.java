package com.chainsys.dao;

import java.time.LocalDate;
import java.util.ArrayList;


import com.chainsys.exception.DbException;
import com.chainsys.model.Register;




public interface RegistrationDAO {
	
	
	public int registrationInsert(String username,String password,String emailid,long phonenumber,String gender,LocalDate dob,String cityname) throws DbException;
	
	
	public void changePassword(String emailid,String pass) throws DbException;
	
	
	public ArrayList<Register>getAllUserDetails()throws DbException;
	
	
	public void deleteUser()throws DbException;
		
	
	public int blockUser(int userid,int status) throws DbException;
	
	
	
}
