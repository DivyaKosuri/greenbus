package com.svecw.greenbus.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Bus;
import com.svecw.greenbus.exception.GreenBusException;

public class BusDAO {
	public boolean insert(Bus bus) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into bus values(?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, bus.getRegistrationNo());
			ps.setInt(2, bus.getBusTypeId());
			ps.setInt(3, bus.getSeatCount());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {
			try {
				if (ps != null) {

					ps.close();
				}
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());
			}

		}
		return false;
	}

	public ArrayList<Bus> retriveAll() throws GreenBusException {

		Statement s = null;
		ArrayList<Bus> busList = null;
		try {
			s = DAOUtility.getConnection().createStatement();
			ResultSet rs = s.executeQuery("select * from bus");
			if (rs.next()) {
				busList = new ArrayList<>();
				do {
					Bus temp = new Bus();
					temp.setRegistrationNo(rs.getString(1));
					temp.setBusTypeId(rs.getInt(2));
					temp.setSeatCount(rs.getInt(3));
					busList.add(temp);
				} while (rs.next());
			}
		} catch (SQLException e) {
			throw new GreenBusException(e.toString());
		} finally {

			try {
				if (s != null) {
					s.close();
				}
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());

			}
		}

		return busList;
	}
}
