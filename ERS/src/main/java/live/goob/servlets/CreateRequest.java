package live.goob.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import live.goob.connectionutil.ConnectionUtility;
import live.goob.dao.ReimburseDAOImpl;
import live.goob.dao.UserDAOImpl;
import live.goob.model.Reimburse;
import live.goob.model.User;

/**
 * Servlet implementation class CreateRequest
 */
public class CreateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User usr = new User();
		Reimburse rem = new Reimburse();
		
		ReimburseDAOImpl remdao = new ReimburseDAOImpl();
		UserDAOImpl usedao = new UserDAOImpl();
		
		HttpSession session = request.getSession();

		
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO ers.reimburse (username, reason, reimburseStatus, reimburseAmount, reimbursedate)"
					+ "VALUES(?, ?, ?, ?, ?)");//VALUES( same # of inputs as columns)
			

//			ps.setInt(1, usr.getUser_id());
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String user = request.getParameter("empName");
			String reason = request.getParameter("reason");
			String amountString = request.getParameter("amount");
			int amount = Integer.parseInt(amountString);
			
			
			usr = (User)session.getAttribute("nam");
			rem = (Reimburse)session.getAttribute("reason");
			
			
			String name = usr.getUserName();
			System.out.println(name);
			
			ps.setString(1, name);
			ps.setString(2, reason);
			ps.setString(3, "pending");
			ps.setInt(4, amount);
			
			 Calendar cal=Calendar.getInstance();
			 
			ps.setDate(5, new java.sql.Date(cal.getTimeInMillis()));
			
			//BAM SQL has been sent from prepared statement down below
			ps.executeUpdate();
			//usr = (User)session.getAttribute("username");
			
			out.print("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"utf-8\">\r\n"
					+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "<title>Employee Page</title>\r\n"
					+ "\r\n"
					+ "<!-- Bootstrap -->\r\n"
					+ "<link\r\n"
					+ "	href=\"file:///C|/Users/Goob/AppData/Roaming/Adobe/Dreamweaver 2020/en_US/Configuration/Temp/Assets/eam4BCE.tmp/css/bootstrap-4.3.1.css\"\r\n"
					+ "	rel=\"stylesheet\">\r\n"
					+ "<link\r\n"
					+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\r\n"
					+ "	rel=\"stylesheet\" type=\"text/css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n"
					+ "		<a class=\"navbar-brand\" href=\"#\">Navbar</a>\r\n"
					+ "		<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n"
					+ "			data-target=\"#navbarSupportedContent\"\r\n"
					+ "			aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n"
					+ "			aria-label=\"Toggle navigation\">\r\n"
					+ "			<span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "		</button>\r\n"
					+ "		<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
					+ "			<ul class=\"navbar-nav mr-auto\">\r\n"
					+ "				<li class=\"nav-item active\"><a class=\"nav-link\"\r\n"
					+ "					href=\"/logout\">Home/Logout <span class=\"sr-only\">(current)</span></a>\r\n"
					+ "				</li>\r\n"
					+ "\r\n"
					+ "			</ul>\r\n"
					+ "\r\n"
					+ "		</div>\r\n"
					+ "	</nav>\r\n"
					+ "\r\n"
					+ "	<div class=\"jumbotron jumbotron-fluid text-center\">\r\n"
					+ "		<h1 class=\"display-4\">Welcome, " + name + "!</h1>\r\n"
					+ "\r\n"
					+ "				<p class=\"lead\">What would you like to do?</p>\r\n"
					+ "		<form action=\"EmpView\"><input type=\"Submit\" value=\"View Requests\"></form><div></div> <br>\r\n"
					+ "			<form action=\"CreateRequest\" method=\"post\">\r\n"
					+ "				Reason: <input type=\"text\" name = \"reason\"> <br>Amount: <input type=\"number\" name = \"amount\"> <br>\r\n"
					+ " <input type=\"Submit\" value=\"Create New Request\"><br> <p class=\" badge badge-info\">Successfully added to your requests!</p></form><br>"
					+ "		\r\n"
					+ "			<form><input type=\"Submit\" value=\"Update/View Information\"></form>"
					+ "\r\n"
					+ "	</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "	<br>\r\n"
					+ "	<hr>\r\n"
					+ "	<br>\r\n"
					+ "\r\n"
					+ "	<div class=\"row\">\r\n"
					+ "		<div class=\"text-center col-lg-6 offset-lg-3\">\r\n"
					+ "			<h4>Footer</h4>\r\n"
					+ "			<p>Copyright &copy; 2021 &middot; All Rights Reserved\r\n"
					+ "				&middot;Revature ERS</p>\r\n"
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "	</div>\r\n"
					+ "	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n"
					+ "	<script\r\n"
					+ "		src=\"file:///C|/Users/Goob/AppData/Roaming/Adobe/Dreamweaver 2020/en_US/Configuration/Temp/Assets/eam4BCE.tmp/js/jquery-3.3.1.min.js\"></script>\r\n"
					+ "\r\n"
					+ "	<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n"
					+ "	<script\r\n"
					+ "		src=\"file:///C|/Users/Goob/AppData/Roaming/Adobe/Dreamweaver 2020/en_US/Configuration/Temp/Assets/eam4BCE.tmp/js/popper.min.js\"></script>\r\n"
					+ "	<script\r\n"
					+ "		src=\"file:///C|/Users/Goob/AppData/Roaming/Adobe/Dreamweaver 2020/en_US/Configuration/Temp/Assets/eam4BCE.tmp/js/bootstrap-4.3.1.js\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n");
			
		} catch (SQLException e) {
			e.printStackTrace();

		}

		}
	}

	
