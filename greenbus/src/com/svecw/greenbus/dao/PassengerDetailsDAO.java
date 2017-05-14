package com.svecw.greenbus.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.PassengerDetails;
import com.svecw.greenbus.dto.Ticket;
import com.svecw.greenbus.exception.GreenBusException;

public class PassengerDetailsDAO {
	public boolean insert(PassengerDetails pd) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into passenger_details values(?,?,?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setInt(1, pd.getTicketId());
			ps.setInt(2, pd.getSeatNo());
			ps.setInt(3, pd.getAge());
			ps.setString(4, pd.getName());
			ps.setString(5, pd.getGender());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new GreenBusException(e.toString());
				}
			}

		}
		return false;
	}

	public void getReservedCount() throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "select count(seat_no) from passenger_details where ticket_id in(select ticket_id from ticket where registration_no = ? && journey_date = ?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, "AP1");
			ps.setString(2, "2017-09-01");
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new GreenBusException(e.toString());

			}
		}

	}
}
