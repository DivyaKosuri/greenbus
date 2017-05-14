package com.svecw.greenbus.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.svecw.greenbus.dao.BusDAO;
import com.svecw.greenbus.dao.BusRouteDAO;
import com.svecw.greenbus.dao.BusTypeDAO;
import com.svecw.greenbus.dao.RouteDAO;
import com.svecw.greenbus.dto.Bus;
import com.svecw.greenbus.dto.BusRoute;
import com.svecw.greenbus.dto.BusType;
import com.svecw.greenbus.dto.Route;
import com.svecw.greenbus.exception.GreenBusException;
import com.svecw.greenbus.util.DateUtility;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("bus_type")) {
			try {
				List<BusType> busTypesList = new BusTypeDAO().retriveAll();
				request.setAttribute("busTypesList", busTypesList);
				request.getRequestDispatcher("addBus.jsp").forward(request, response);
			} catch (GreenBusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (action != null && action.equals("bus_route")) {
			try {
				List<Route> routeList = new RouteDAO().retriveAll();
				List<Bus> busList = new BusDAO().retriveAll();
				request.setAttribute("routeList", routeList);
				request.setAttribute("busList", busList);
				request.getRequestDispatcher("addBusRoute.jsp").forward(request, response);
			} catch (GreenBusException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("route")) {
			Route route = new Route();
			RouteDAO dao = new RouteDAO();
			route.setDestination(request.getParameter("destination"));
			route.setSource(request.getParameter("source"));
			route.setDistance(Integer.parseInt(request.getParameter("distance")));
			try {
				if (dao.insert(route)) {
					request.setAttribute("successMessage", "Route Added Successfully !!!");
					request.getRequestDispatcher("addRoute.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addRoute.jsp").forward(request, response);
			}
		} else if (action.equals("bus")) {
			Bus bus = new Bus();
			BusDAO dao = new BusDAO();
			bus.setRegistrationNo(request.getParameter("registrationNo"));
			bus.setBusTypeId(Integer.parseInt(request.getParameter("busTypeId")));
			bus.setSeatCount(Integer.parseInt(request.getParameter("seatCount")));
			try {
				if (dao.insert(bus)) {
					request.setAttribute("successMessage", "Bus Added Successfully !!!");
					request.getRequestDispatcher("addBus.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addBus.jsp").forward(request, response);
			}
		} else if (action.equals("bus_type")) {
			BusType busType = new BusType();
			BusTypeDAO dao = new BusTypeDAO();
			busType.setName(request.getParameter("busType"));
			try {
				if (dao.insert(busType)) {
					request.setAttribute("successMessage", "Bus Type Added Successfully !!!");
					request.getRequestDispatcher("addBusType.jsp").forward(request, response);
				}
			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addBusType.jsp").forward(request, response);
			}
		} else if (action.equals("bus_route")) {

			BusRoute busRoute = new BusRoute();
			BusRouteDAO dao = new BusRouteDAO();
			try {

				Route route = new RouteDAO().getRoute(request.getParameter("source"),
						request.getParameter("destination"));
				busRoute.setRouteId(route.getRouteId());
				busRoute.setRegistrationNo(request.getParameter("registrationNo"));
				busRoute.setArrivalTime(DateUtility.convertStringToDate(request.getParameter("arrivalTime")));
				busRoute.setDepartureTime(DateUtility.convertStringToDate(request.getParameter("departureTime")));
				if (dao.insert(busRoute)) {
					request.setAttribute("successMessage", "Bus Route Added Successfully !!!");
					request.getRequestDispatcher("addBusRoute.jsp").forward(request, response);
				}

			} catch (GreenBusException e) {
				request.setAttribute("errorMessage", e.toString());
				request.getRequestDispatcher("addBusRoute.jsp").forward(request, response);
			}
		}

	}

}
