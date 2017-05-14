package com.svecw.greenbus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svecw.greenbus.dao.PassengerDetailsDAO;
import com.svecw.greenbus.dao.TicketDAO;
import com.svecw.greenbus.dao.UserDAO;
import com.svecw.greenbus.dto.PassengerDetails;
import com.svecw.greenbus.dto.Ticket;
import com.svecw.greenbus.dto.User;
import com.svecw.greenbus.exception.GreenBusException;
import com.svecw.greenbus.util.DateUtility1;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getParameter("action");
		if (action.equals("signup")) {
			User user = new User();
			user.setEmailId(request.getParameter("emailid"));
			user.setPassword(request.getParameter("password"));
			user.setPhoneNumber(Integer.parseInt(request.getParameter("phno")));
			user.setUserName(request.getParameter("username"));
			try {
				if (new UserDAO().insert(user)) {
					request.setAttribute("successMessage", "Sign Up Successfull!!!");
					//request.getRequestDispatcher("userSignup.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("userSignup.jsp").forward(request, response);
			}

		} else if (action.equals("login")) {
			User user = new User();
			String email = request.getParameter("emailid");
			String password = request.getParameter("password");
			try {
				user = new UserDAO().getUser(email); 
				if(user.getPassword().equals(password)) {
					request.setAttribute("successMessage", "Login Successfull !!!");
					//request.getRequestDispatcher("userLogin.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("userLogin.jsp").forward(request, response);
			}
		}
			else if (action.equals("passenger_details")) {
				PassengerDetails pd = new PassengerDetails();
				PassengerDetailsDAO dao = new PassengerDetailsDAO();
				pd.setTicketId(Integer.parseInt(request.getParameter("ticketId")));
				pd.setSeatNo(Integer.parseInt(request.getParameter("seatNo")));
				pd.setAge(Integer.parseInt(request.getParameter("age")));
				pd.setName(request.getParameter("name"));
				pd.setGender(request.getParameter("gender"));
				try {
					if (dao.insert(pd)) {
						request.setAttribute("successMessage", "Passenger details  entered Successfully !!!");
						request.getRequestDispatcher("PassengerDetails.jsp").forward(request, response);
					}
					dao.getReservedCount();
				} catch (GreenBusException e) {
					request.setAttribute("errorMessage", e.toString());
					request.getRequestDispatcher("PassengerDetails.jsp").forward(request, response);
				}
		}
			else if (action.equals("ticket")) {
				Ticket ticket = new Ticket();
				TicketDAO dao = new TicketDAO();
				ticket.setJourneyDate(DateUtility1.convertStringToDate(request.getParameter("journeyDate")));
				ticket.setRegistrationNo(request.getParameter("registrationNo"));
				ticket.setRouteId(Integer.parseInt(request.getParameter("routeId")));
				ticket.setUserId(Integer.parseInt(request.getParameter("userId")));
				try {
					if (dao.insert(ticket)) {
						request.setAttribute("successMessage", "Ticket Generated Successfully !!!");
						request.getRequestDispatcher("Ticket.jsp").forward(request, response);
					}
				} catch (GreenBusException e) {

					request.setAttribute("errorMessage", e.toString());
					request.getRequestDispatcher("Ticket.jsp").forward(request, response);
				}

			}
		

	}

}
