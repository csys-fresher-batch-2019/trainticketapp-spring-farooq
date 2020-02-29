package com.chainsys.dao;

import com.chainsys.exception.DbException;
import com.chainsys.model.Seats;;

public interface SeatsDAO {

	public int updateSeatsCount(Seats s) throws DbException;

	
	public void getSeatsCount(Seats s) throws DbException;

}
