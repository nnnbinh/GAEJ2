package gaej2;

import java.io.IOException;

import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import gaej2.Entity.*;
import gaej2.PMF;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class TelesalesServlet extends HttpServlet {
	static int total = 0;

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create the persistence manager instance
//		PersistenceManager pm = PMF.get().getPersistenceManager();

		PersistenceManager pm = PMF.get().getPersistenceManager();
		// display the lookup form
		if (request.getParameter("action").equals("accountLookup")) {
			// query for the entities by name
			String query = "select from " + Account.class.getName() + " where name == '"
					+ request.getParameter("accountName") + "'";
			List<Account> accounts = (List<Account>) pm.newQuery(query).execute();
			// pass the list to the jsp
			request.setAttribute("accounts", accounts);
			// forward the request to the jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accountLookup.jsp");
			dispatcher.forward(request, response);
			// display the create new account form
		} else if (request.getParameter("action").equals("accountCreate")) {
			response.sendRedirect("/accountCreate.jsp");
			// process the new account creation and send the user to the account display
			// page
		} else if (request.getParameter("action").equals("accountCreateDo")) {
			// create the new account
			Account a = new Account(request.getParameter("name"), request.getParameter("billingCity"),
					request.getParameter("billingState"), request.getParameter("phone"),
					request.getParameter("website"));
			// persist the entity
			try {
				pm.makePersistent(a);
			} finally {
				pm.close();
			}
			response.sendRedirect("telesales?action=accountDisplay&accountId=" + a.getId());

			// display the account details and opportunities
		} else if (request.getParameter("action").equals("accountDisplay")) {
			Key k = KeyFactory.createKey(Account.class.getSimpleName(),
					Long.parseLong(request.getParameter("accountId")));
			Account a = pm.getObjectById(Account.class, k);
			String query = "select from " + Opportunity.class.getName() + " where accountId == "
					+ request.getParameter("accountId") +" ORDER BY name RANGE 5,10";
			
			List<Opportunity> opportunities = (List<Opportunity>) pm.newQuery(query).execute();
			request.setAttribute("account", a);
			// pass the list to the jsp
			request.setAttribute("opportunities", opportunities);

			// forward the request to the jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accountDisplay.jsp");
			dispatcher.forward(request, response);

			// display the create new opportunity form
		} else if (request.getParameter("action").equals("opportunityCreate")) {
			Key k = KeyFactory.createKey(Account.class.getSimpleName(),
					Long.parseLong(request.getParameter("accountId")));
			Account a = pm.getObjectById(Account.class, k);

			request.setAttribute("accountName", a.getName());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/opportunityCreate.jsp");
			dispatcher.forward(request, response);
			// process the new opportunity creation and send the user to the account display
			// page
		} else if (request.getParameter("action").equals("opportunityCreateDo")) {
			Date closeDate = new Date();
			// try to parse the date
			try {
				DateFormat df = DateFormat.getDateInstance(3);
				closeDate = df.parse(request.getParameter("closeDate"));
			} catch (java.text.ParseException pe) {
				System.out.println("ParseExceptions: " + pe);
			}

			Opportunity opp = new Opportunity(request.getParameter("name"),
					new Double(request.getParameter("amount")).doubleValue(), request.getParameter("stageName"),
					new Integer(request.getParameter("probability")).intValue(), closeDate,
					new Integer(request.getParameter("orderNumber")).intValue(),
					new Long(request.getParameter("accountId")));
			try {
				pm.makePersistent(opp);
			} finally {
				pm.close();
			}
			response.sendRedirect("telesales?action=accountDisplay&accountId=" + request.getParameter("accountId"));

		} else if (request.getParameter("action").equals("Count")) {
			request.setAttribute("count", total);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Count.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("action").equals("addCount")) {
			total += 1;
			request.setAttribute("count", total);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Count.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
