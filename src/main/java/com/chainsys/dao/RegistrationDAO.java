package com.chainsys.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.exception.DbException;
import com.chainsys.registration.Register;

public interface RegistrationDAO {

	public int registrationInsert(String username,String password,String emailid,long phonenumber,String gender,LocalDate dob,String cityname) throws DbException;
	
	public String getUserPassword(String emailid) throws DbException;
	
	
	public void changePassword(String emailid,String pass) throws DbException;
	
	public void changephonenum (int userid,long phonenumber)throws DbException;
	
	public ArrayList<Register>getAllUserDetails()throws DbException;
	
	public void deleteUser()throws DbException;
	
	public void getUserByCity(String city)throws DbException;
	
	public List<Register> getUserDetails(int userid)throws DbException;
	
	@SqlUpdate("update registration set blocklist = :blocklist where user_id= :id")
	public int blockUser(@Bind("id") int userid,@Bind("blocklist") int status) throws DbException;
	
	
	
}
