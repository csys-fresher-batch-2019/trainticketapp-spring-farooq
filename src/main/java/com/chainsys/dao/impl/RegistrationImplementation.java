package com.chainsys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.Util.TestConnect;
import com.chainsys.exception.DbException;
import com.chainsys.exception.ErrorMessages;
import com.chainsys.model.Register;
@Repository
public class RegistrationImplementation implements com.chainsys.dao.RegistrationDAO {
/**
 * Get user-id and phone number and update DB
 */
	
	final static Logger logger = LoggerFactory.getLogger(RegistrationImplementation.class);

	public void changephonenum(int userid, long phonenumber) throws DbException {

		String query = "select user_id from registration where user_id=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query);) {
			stmt.setInt(1, userid);
			try (ResultSet row1 = stmt.executeQuery();) {

				if (row1.next()) {

					int userid1 = getUserId(row1);

					if (userid == userid1) {

						String query1 = "update registration set phone_num =? where user_id=?";

						try (PreparedStatement stmt1 = connection.prepareStatement(query1);) {

							stmt1.setLong(1, phonenumber);
							stmt1.setInt(2, userid);
							stmt1.executeUpdate();
						} catch (Exception e) {
							throw new Exception(ErrorMessages.INVALID_SQLQUERY);

						}

					}
				}
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_SQLQUERY);
			}

		} catch (Exception e1) {
			throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);
		}
	}

	private int getUserId(ResultSet row1) throws SQLException {
		int userid1 = row1.getInt("user_id");
		return userid1;
	}

	public ArrayList<Register> getAllUserDetails() throws DbException {
		ArrayList<Register> task = new ArrayList<>();
		String query = "select * from registration";
		try (Connection connection = TestConnect.getConnection(); Statement stmt = connection.createStatement();) {

			try (

					ResultSet row = stmt.executeQuery(query);) {

				while (row.next()) {
					Register obj = new Register();
					setRegistrationDetails(row, obj);

					task.add(obj);

				}

			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_SQLQUERY);
			}
		} catch (SQLException e1) {
			throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);

		} catch (Exception e1) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		}
		return task;

	}

	private void setRegistrationDetails(ResultSet row, Register obj) throws SQLException {
		obj.setUsername(row.getString("user_name"));
		obj.setUserid(row.getInt("user_id"));
		obj.setEmailid(row.getString("email_id"));
		obj.setPhonenum(row.getLong("phone_num"));
		obj.setPassword(row.getString("pass"));
		obj.setGender(row.getString("gender"));
		obj.setDob(row.getDate("dob"));
		obj.setCityname(row.getString("city_name"));
	}

	public void deleteUser() throws DbException {
		
		String sql1 = "delete from booking where booking.booked_date=(select max(booked_date) from booking)";
		try (Connection connection = TestConnect.getConnection(); 
		Statement stmt1 = connection.createStatement()) {
						stmt1.executeUpdate(sql1);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getUserByCity(String city) throws DbException {

		String query = "select * from registration where city_name=?";
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {

			stmt.setString(1, city);
			try (ResultSet row1 = stmt.executeQuery();) {

				ArrayList<Register> task = new ArrayList<>();
				if (row1.next()) {

					String city1 = row1.getString("city_name");

					if (city.equals(city1)) {

						Register obj = new Register();

						setRegistrationDetails(row1, obj);

						task.add(obj);
					} else {
					logger.info("invalid city");
				}

				}
			}catch(Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}
			} catch (Exception e) {
				throw new DbException("ESTABLISH CONNECTION");
			}
	}
/**
 * Get emailId 
 * return password
 */
	public String getUserPassword(String emailid) throws DbException {

		String query = "select pass from registration where email_id=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query);) {
			stmt.setString(1, emailid);

			try (ResultSet row = stmt.executeQuery();) {
				String password = null;

				if (row.next()) {
					password = row.getString("pass");

				} else {
					logger.info("NO DATA");
				}
				return password;
			}
		} catch (SQLException e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		} catch (Exception e) {
			throw new DbException("UNABLE TO PROCESS");
		}
	}

	public List<Register> getUserDetails(int userid) throws DbException {
		String sql = "select * from registration where user_id=?";
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);) {

			stmt.setInt(1, userid);
			try (

					ResultSet row = stmt.executeQuery();) {

				ArrayList<Register> task = new ArrayList<>();
				if (row.next()) {
					Register p1 = new Register();

					setRegistrationDetails(row, p1);

					task.add(p1);

					int userid1 = row.getInt("user_id");
					if (userid == (userid1)) {

						throw new DbException("VALID");

					}
				} else {
					throw new Exception("INVALID");
				}
				return task;
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_SQLQUERY);
			}
		} catch (SQLException e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		}
	}
/**
 * Get userId,Password and update DB
 */
	public void changePassword(String emailid ,String pass) throws DbException {

		String query1 = "update registration set pass=? where email_id=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query1);) {

			stmt.setString(1, pass);
			stmt.setString(2, emailid);
									stmt.executeUpdate();

		} catch (Exception e) {
//throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);
e.printStackTrace();
		}
			}
/**
 * 
 * @param obj
 * @throws DbException
 * Get User details Using Object And insert into DB
 */
	public static void save(Register obj) throws DbException {

		String sql = "insert into registration values(?,?,?,?,?,?,?,?)";
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setString(2, obj.getUsername());
			ps.setInt(1, obj.getUserid());
			ps.setString(4, obj.getEmailid());
			ps.setString(3, obj.getPassword());
			ps.setLong(5, obj.getPhonenum());
			ps.setString(6, obj.getGender());
			ps.setString(8, obj.getCityname());
			ps.setDate(7, obj.getDob());

			ps.executeUpdate();

		} catch (SQLException e) {
		throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);

		} catch (Exception e) {
			throw new DbException("UNABLE TO PROCESS");
		}
	}
/**
 * Get user Details and Insert into DB
 */
	public int registrationInsert(String username, String password, String emailid, long phonenumber, String gender,
			LocalDate dob, String cityname) throws DbException {

		int  user_id = 0;
		try (Connection connection = TestConnect.getConnection();

				Statement stmt = connection.createStatement();) {

			String sql = "insert into registration(user_id,user_name,pass,email_id,phone_num,gender,dob,city_name) values(user_id_seq.nextval,'"
					+ username + "','" + password + "','" + emailid + "'," + phonenumber + ",'" + gender + "',to_date('"
					+ dob + "','yyyy-MM-dd'),'" + cityname + "')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			String sql1 = "select user_id from registration where email_id='" + emailid + "'";
			stmt.executeUpdate(sql1);
			try (ResultSet row1 = stmt.executeQuery(sql1);) {
				if (row1.next()) {
					System.out.println("NOTE DOWN THE USER_ID FOR BOOKING");
					user_id = row1.getInt("user_id");
					System.out.println("USER-ID=" + user_id);
				}
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}

		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}
		return user_id;
	}
/**
 * Get User-id and Status as 0(unblock)/1(Block) 
 */
	public int blockUser(int userid, int status) throws DbException {

		String sql = "update registration set blocklist =? where user_id=?";
		int result=0;
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setInt(1, status);
			stmt.setInt(2, userid);
			stmt.executeUpdate();
			result=1;
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}
		return result;

	}
	public int unblockUser(int userid, int status) throws DbException {

		String sql = "update registration set blocklist =? where user_id=?";
		int result=0;
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setInt(1, status);
			stmt.setInt(2, userid);
			stmt.executeUpdate();
			result=1;
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}
		return result;

	}

}
