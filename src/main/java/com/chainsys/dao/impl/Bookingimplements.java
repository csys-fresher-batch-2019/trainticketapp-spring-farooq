package com.chainsys.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.Util.TestConnect;
import com.chainsys.exception.DbException;
import com.chainsys.exception.ErrorMessages;
import com.chainsys.exception.SqlException;
import com.chainsys.model.Booking;

@Repository
public class Bookingimplements implements com.chainsys.dao.BookingDAO {

	String passengerName;
	int age;
	String boardingStation;
	final static Logger logger = LoggerFactory.getLogger(Bookingimplements.class);

	public String getUserName(int user_id) throws DbException {
		String name = null;
		String sql = "select user_name from registration where user_id=?";
		PreparedStatement stmt;
		try {
			stmt = TestConnect.getConnection().prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("user_name");
			}
		} catch (SQLException e) {

		} catch (Exception e) {

		}

		return name;
	}

	/**
	 * Get user-id and password then checking with DB return valid or invalid as
	 * Boolean type
	 * 
	 * @throws SqlException
	 */
	public boolean login(int userid, String password) throws DbException, SqlException {

		String sql1 = "select user_id,pass from registration where user_id =? and pass =?";
		Boolean result = false;
		try (Connection connection = TestConnect.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql1);) {

			stmt.setInt(1, userid);
			stmt.setString(2, password);

			try (ResultSet row = stmt.executeQuery();) {

				if (row.next()) {
					int userid1 = row.getInt("user_id");
					String password1 = row.getString("pass");

					if (userid1 == userid && password1.equals(password)) {
						logger.info("LOGGED IN");
						result = true;
					}
				} else {
					logger.info("INVALID EMAIL ID OR PASSWORD");
				}
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_SQLQUERY);
			}
		} catch (SQLException e) {
			throw new SqlException(ErrorMessages.ESTABLISH_CONNECTION);
		} catch (Exception e1) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		}
		return result;
	}

	public String getemailId(int userid) throws DbException, SqlException {
		String sql = "select email_id from registration where user_id=?";
		String emailId = null;
		try {
			PreparedStatement stmt = TestConnect.getConnection().prepareStatement(sql);
			stmt.setInt(1, userid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				emailId = rs.getString("email_id");
			}

		} catch (SQLException e) {
			throw new SqlException(ErrorMessages.INVALID_SQLQUERY);
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		}

		return emailId;
	}

	/**
	 * Get PNR number to remove details from booking table Get user-id,train
	 * number,travel date and move to cancellation table
	 */
	public void Cancellation(int user_id, int train_number, LocalDate traveldate, long pnrNumber)
			throws DbException, SQLException {

		Connection connection;
		try {
			connection = TestConnect.getConnection();
			CallableStatement stmt = connection.prepareCall("{call CANCEL_TICKETS(?,?,?,?)}");
			stmt.setInt(1, train_number);
			stmt.setInt(2, user_id);
			java.sql.Date date = java.sql.Date.valueOf(traveldate);
			stmt.setDate(3, date);
			stmt.setLong(4, pnrNumber);
			stmt.executeQuery();
			CallableStatement stmt1 = connection.prepareCall("{call ALLOCATE_TICKETS(?,?)}");
			stmt1.setInt(1, train_number);
			java.sql.Date date1 = java.sql.Date.valueOf(traveldate);
			stmt1.setDate(3, date1);
			stmt1.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Booking> myBooking(int user_id) throws DbException {
		ArrayList<Booking> task = new ArrayList<>();
		String sql = "select b.pnr_num,b.travel_date,b.no_of_seats,b.curr_status from booking b left join "
				+ "bookingqueue bq on b.user_id= bq.user_id where b.user_id=?";

		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(sql);) {
			stmt.setInt(1, user_id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Booking obj = new Booking();
				obj.setPnrNumber(rs.getLong("pnr_num"));
				obj.setTravel_date(rs.getDate("travel_date"));
				obj.setNoOfSeats(rs.getInt("no_of_seats"));
				obj.setCurrentStatus(rs.getString("curr_status"));
				task.add(obj);
			}
		} catch (Exception e) {
			throw new DbException(e.getMessage());

		}
		return task;

	}

	/**
	 * get train details as train number,source,destination,no of seats to be booked
	 * and travel date calculating total amount and returning it updating seats
	 * count displaying PNR number
	 */
	public int bookSeats1(int trainnumber, int userId, String boarding, String destination, int noOfSeats,
			LocalDate date) throws Exception {

		int a = 0;
		try (Connection connection = TestConnect.getConnection(); 
				Statement stmt1 = connection.createStatement();) {

			String sql = "select blocklist from registration where user_id=" + userId + "";

			try (ResultSet row = stmt1.executeQuery(sql);) {

				if (row.next()) {
					int status = row.getInt("blocklist");

					if (status == 0) {
						System.out.println(trainnumber + "-" + userId + "-" + boarding + "-" + destination + "-" + date
								+ "-" + noOfSeats);

						CallableStatement stmt = connection.prepareCall("{call PR_booking_status(?,?,?,?,?,?)}");
						stmt.setInt(1, trainnumber);
						stmt.setInt(2, userId);
						stmt.setString(3, boarding);
						stmt.setString(4, destination);
						java.sql.Date date2 = java.sql.Date.valueOf(date);
						stmt.setDate(6, date2);
						stmt.setInt(5, noOfSeats);

						stmt.executeQuery();

						String sql2 = "select amount from viewtrain where train_num='" + trainnumber + "'";

						try (ResultSet row3 = connection.createStatement().executeQuery(sql2);) {
							if (row3.next()) {
								int amount = row3.getInt("amount");
								logger.info("BOOKING DETAILS");

								String sql4 = "select no_of_seats from booking where travel_date=to_date('" + date2
										+ "','yyyy-MM-dd') and user_id=" + userId + "";

								try (ResultSet seats = connection.createStatement().executeQuery(sql4);) {
									if (seats.next()) {
										int seats1 = seats.getInt("no_of_seats");
										a = seats1 * amount;
										logger.info("AMOUNT TO BE PAID=" + a);

										String sql3 = "update booking set amount=" + a + "where travel_date=to_date('"
												+ date2 + "','yyyy-MM-dd') and user_id=" + userId +" ";
										stmt.executeUpdate(sql3);
									}
									String sql5 = "select no_of_seats from bookingQueue where travel_date=to_date('"
											+ date2 + "','yyyy-MM-dd') and user_id=" + userId + "";

									try (ResultSet seats1 = connection.createStatement().executeQuery(sql5);) {

										if (seats1.next()) {
											int seats2 = seats1.findColumn("no_of_seats");
											int b = seats2 * amount;
											String sql6 = "update bookingQueue set amount=" + b
													+ "where travel_date=to_date('" + date2
													+ "','yyyy-MM-dd') and user_id=" + userId + "";
											stmt.executeUpdate(sql6);
										}

										String sql1 = "select pnr_num,travel_date from booking where travel_date=to_date('"
												+ date + "','yyyy-MM-dd')";

										try (ResultSet row1 = connection.createStatement().executeQuery(sql1);) {
											while (row1.next()) {
												int pnr = row1.getInt("pnr_num");
												Date date1 = row1.getDate("travel_date");
												logger.info("PNR NUMBER=" + pnr + "\n" + "TRAVEL DATE=" + date1);
											}

										} catch (Exception e) {
											throw new DbException(ErrorMessages.INVALID_SQLQUERY);
										}
									} catch (Exception e) {
										throw new DbException(ErrorMessages.INVALID_SQLQUERY);
									}

								} catch (DbException e) {
									throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
								}
							}
						} catch (DbException e) {
							throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
						}
					}
				} else {

					throw new DbException("YOUR ACCOUNT IS BLOCKED ");
				}

			} catch (DbException e) {
				throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
			}
		} catch (DbException e) {
			throw new DbException(ErrorMessages.ESTABLISH_CONNECTION);
		}
		return a;
	}
}
