package live.goob.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import live.goob.connectionutil.ConnectionUtility;
import live.goob.dao.*;
import live.goob.model.User;

/**
 * Servlet implementation class ManLogin
 */
public class ManLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserDAO loginDAO;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("PostgreSQL Unable to load JDBC Driver");
		}
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManLogin() {
		super();
		// TODO Auto-generated constructor stub
		this.loginDAO = new UserDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User usr = new User();
		UserDAOImpl edao = new UserDAOImpl();

		HttpSession session = request.getSession();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("manName");
		String pass = request.getParameter("manPass");
		try (Connection conn = ConnectionUtility.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.associates WHERE username = ? AND pass = ? AND userlevel =?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setString(3, "a");
			ResultSet myRs = ps.executeQuery();


			if (myRs.next()) {

				int userid = myRs.getInt(1);
				System.out.println(userid);
				System.out.println("Login Successful!");
				out.print("Successful Login!\n");
				usr = edao.selectUser(user);

				session.setAttribute("nam", usr);
				response.sendRedirect("http://localhost:8080/Project/ManView");
			}

			else {
				out.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"utf-8\">\r\n"
						+ "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "<title>Manager Login</title>\r\n"
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
						+ "					href=\"index.html\">Home <span class=\"sr-only\">(current)</span></a></li>\r\n"
						+ "				<li class=\"nav-item active\"><a class=\"nav-link\"\r\n"
						+ "					href=\"empLogin.html\">Employee Login <span class=\"sr-only\">(current)</span></a>\r\n"
						+ "				</li>\r\n"
						+ "				<li class=\"nav-item active\"><a class=\"nav-link\" href=\"#\">Manager\r\n"
						+ "						Login<span class=\"sr-only\">(current)</span>\r\n"
						+ "				</a></li>\r\n"
						+ "\r\n"
						+ "			</ul>\r\n"
						+ "\r\n"
						+ "		</div>\r\n"
						+ "	</nav>\r\n"
						+ "\r\n"
						+ "	<div class=\"jumbotron jumbotron-fluid text-center\">\r\n"
						+ "		<h1 class=\"display-4\">Manager Login</h1>\r\n"
						+ "		<p class=\"lead\">Please input your credentials:</p>\r\n"
						+ "\r\n"
						+ "		<form name=\"ManLogin\" action=\"ManLogin\" method=\"post\">\r\n"
						+ "			Username: <input type=\"text\" name=\"manName\"> <br>\r\n"
						+ "			Password: <input type=\"password\" name=\"manPass\"> <br> Invalid username or password, please try again!<input\r\n"
						+ "				type=\"Submit\" value=\"Submit\"> <a href=\"index.html\"><input\r\n"
						+ "				type=\"button\" value=\"Go back\"></a>\r\n"
						+ "		</form>\r\n"
						+ "	</div>\r\n"
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
						+ "</html>\r\n"
						+ "");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
