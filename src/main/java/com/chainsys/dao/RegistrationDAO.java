package com.chainsys.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.exception.DbException;
import com.chainsys.model.Register;

public interface RegistrationDAO {
	
	public int registrationInsert(String username,String password,String emailid,long phonenumber,String gender,LocalDate dob,String cityname) throws DbException;
	
	@SqlUpdate("update registration set pass= :password where email_id= :email")
	public void changePassword(@Bind("email")String emailid,@Bind("password")String pass) throws DbException;
	
	@SqlQuery("select * from registration")
	public ArrayList<Register>getAllUserDetails()throws DbException;
	
	@SqlUpdate("delete from booking where booking.booked_date=(select max(booked_date) from booking)")
	public void deleteUser()throws DbException;
		
	@SqlUpdate("update registration set blocklist = :blocklist where user_id= :id")
	public int blockUser(@Bind("id") int userid,@Bind("blocklist") int status) throws DbException;
	
	
	
}
