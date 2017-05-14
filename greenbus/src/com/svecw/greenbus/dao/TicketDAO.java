package com.svecw.greenbus.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.svecw.greenbus.dao.util.DAOUtility;
import com.svecw.greenbus.dto.Ticket;
import com.svecw.greenbus.exception.GreenBusException;

public class TicketDAO {
	public boolean insert(Ticket ticket) throws GreenBusException {
		PreparedStatement ps = null;
		final String qstr = "insert into ticket(registration_no,route_id,journey_date,user_id) values(?,?,?,?)";
		try {
			ps = DAOUtility.getConnection().prepareStatement(qstr);
			ps.setString(1, ticket.getRegistrationNo());
			ps.setInt(2, ticket.getRouteId());
			ps.setDate(3, new java.sql.Date(ticket.getJourneyDate().getTime()));
			ps.setInt(4, ticket.getUserId());
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

}
