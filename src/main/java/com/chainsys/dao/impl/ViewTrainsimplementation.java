package com.chainsys.dao.impl;

import java.sql.Connection;
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
import com.chainsys.dao.ListTrainDAO;
import com.chainsys.exception.DbException;
import com.chainsys.exception.ErrorMessages;
import com.chainsys.model.ListTrain;
@Repository
public class ViewTrainsimplementation implements ListTrainDAO {
/**
 * return Train details
 */
	final static Logger logger = LoggerFactory.getLogger(RegistrationImplementation.class);

	public ArrayList<ListTrain> getTrainsByArrivalTime() throws DbException {

		try (

				Connection connection = TestConnect.getConnection();

				Statement stmt = connection.createStatement();) {

			String query1 = "select train_num,train_name, to_char(arr_time,'hh24:mi:ss')as ar,route,boarding_station,destination_station,dept_time,status from viewtrain order by arr_time desc";

			ArrayList<ListTrain> task = new ArrayList<ListTrain>();
			try (ResultSet row = stmt.executeQuery(query1);) {

				while (row.next()) {
					ListTrain obj = new ListTrain();

					listall(row, obj);

					task.add(obj);
				}
				return task;

			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}

		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}
	}

	private void listall(ResultSet row, ListTrain obj) throws SQLException {
		obj.setTrainnumber(row.getInt("train_num"));
		obj.setTrainname(row.getString("train_name"));
		obj.setBoardingstation(row.getString("boarding_station"));
		obj.setDestinationstation(row.getString("destination_station"));
		obj.setArrivaltime(row.getString("arr_time"));
		obj.setDepaturetime(row.getString("dept_time"));
		obj.setRoute(row.getString("route"));
		obj.setStatus(row.getString("status"));
	}

	public ArrayList<ListTrain> getTrainsByDeptTime() throws DbException {
		try (Connection connection = TestConnect.getConnection();

				Statement stmt = connection.createStatement();) {

			String query = "select train_num,train_name, to_char(dept_time,'hh24:mi:ss') as dept,route,boarding_station,destination_station,arr_time,status from viewtrain order by arr_time asc";

			ArrayList<ListTrain> task = new ArrayList<ListTrain>();
			try (ResultSet row = stmt.executeQuery(query);) {

				while (row.next()) {
					ListTrain obj = new ListTrain();

					listall(row, obj);

					task.add(obj);
				}
				return task;
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}

		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}
	}

	public ArrayList<ListTrain> getTrainDetailsByname(String trainname) throws DbException {

		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
		String query = "select * from viewtrain where train_name LIKE '% ? %'";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query);) {

			stmt.setString(1, trainname);

			try (ResultSet row = stmt.executeQuery();) {
				if (row.next()) {

					ListTrain obj = new ListTrain();

					listall(row, obj);

					task.add(obj);
				} else {
					logger.info("INVALID TRAIN NAME");
				}
			}
		} catch (SQLException e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		}
		return task;
	}

	public ArrayList<ListTrain> getTrainDetailsByTrainNumber(int trainnum) throws DbException {

		String query = "select * from viewtrain where train_num=?";
		ArrayList<ListTrain> task = new ArrayList<ListTrain>();
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(query)) {

			stmt.setInt(1, trainnum);

			try (

					ResultSet row = stmt.executeQuery();) {

				if (row.next()) {

					ListTrain obj = new ListTrain();

					listall(row, obj);

					task.add(obj);
				}
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}
		} catch (SQLException e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS);
		}
		return task;
	}
/**
 * Get train Details and inserting into DB
 */
	public void insertnewTrain(ListTrain lt) throws DbException {

		try (Connection connection = TestConnect.getConnection();

				Statement stmt = connection.createStatement();) {

			String sql = "insert into viewtrain values(" + lt.getTrainnumber() + ",'" + lt.getTrainname() 
			+ "',to_date('"+lt.getDate()+"','yyyy-MM-dd'),'"+ lt.getBoardingstation() + "','" + lt.getDestinationstation() 
			+ "',to_timestamp('"+ lt.getArrivaltime() + "','HH:MI:SS'),to_timestamp('" 
			+ lt.getDepaturetime() + "','HH:MI:SS'),'"
			+ lt.getRoute() + "','" + lt.getStatus() + "'," + lt.getAmount() + ")";
System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			//throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
			e.printStackTrace();
		}
	}

	public ArrayList<ListTrain> getAllTrainsDetails() throws DbException {
		try (Connection connection = TestConnect.getConnection();

				Statement stmt = connection.createStatement();) {

			String query = "select * from viewtrain";
			System.out.println(query);
			try (ResultSet row = stmt.executeQuery(query);) {

				ArrayList<ListTrain> task = new ArrayList<ListTrain>();

				while (row.next()) {
					ListTrain obj = new ListTrain();
					listall(row, obj);

					task.add(obj);
				}

				return task;
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}
	}
/**
 * Search Trains By Getting Source , Destination , Travel date
 * return Train list
 */
	public ArrayList<ListTrain> getTrainDetails(String boardingStation, String destinationStation, LocalDate traveldate)
			throws DbException {
		String sql = "select * from viewtrain where Boarding_station=? and destination_station=? and traveldate=?";
		try (Connection connection = TestConnect.getConnection();

				PreparedStatement stmt = connection.prepareStatement(sql);) {
			System.out.println(toString());
			stmt.setString(2, destinationStation);
			stmt.setString(1, boardingStation);
			java.sql.Date date1 = java.sql.Date.valueOf(traveldate);
			stmt.setDate(3, date1);

			ArrayList<ListTrain> task = new ArrayList<ListTrain>();
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					ListTrain obj = new ListTrain();

					listall(rs, obj);

					obj.setDate(traveldate);
					obj.setAmount(rs.getInt("amount"));
					task.add(obj);
				}
				return task;
			} catch (Exception e) {
				throw new DbException(ErrorMessages.INVALID_DATA);
			}
		} catch (Exception e) {
			throw new DbException(ErrorMessages.UNABLE_TO_PROCESS_QUERY);
		}

	}

	public ArrayList<String> getTrainDetailsByBoardingStation() throws SQLException, Exception {

		ArrayList<String> task = new ArrayList<>();
	
		try (Connection connection = TestConnect.getConnection(); Statement stmt = connection.createStatement();) {
			String sql = "select distinct boarding_station from viewtrain";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ListTrain obj = new ListTrain();
				String list=obj.setBoardingstation(rs.getString("boarding_station"));
				task.add(list);
				}	
		}
		
		return task;
	}
	public ArrayList<String> getTrainDetailsByDestinationStation() throws SQLException, Exception {

		ArrayList<String> task = new ArrayList<>();
	
		try (Connection connection = TestConnect.getConnection(); Statement stmt = connection.createStatement();) {
			String sql = "select distinct destination_station from viewtrain";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ListTrain obj = new ListTrain();
				String list2=obj.setBoardingstation(rs.getString("destination_station"));
				task.add(list2);
				}	
		}
		
		return task;
	}

}
