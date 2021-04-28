package live.goob.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import live.goob.connectionutil.ConnectionUtility;
import live.goob.model.User;

/**
 * Servlet implementation class ManView
 */
public class ManView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
	
		HttpSession session = request.getSession();
		User usr = (User)session.getAttribute("nam");
		String name = usr.getNam();
				
		//String UserName = (String) session.getAttribute("username");
		
		//System.out.println(request.getAttribute("nam"));
		
		usr = (User)session.getAttribute("username");

		
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
				+ "					href=\"index.html\">Home/Logout <span class=\"sr-only\">(current)</span></a>\r\n"
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
				+ "			<p class=\"lead\">What would you like to do?</p>\r\n"
				+ "			<form><input type=\"Submit\" value=\"Approve/Deny Requests\"></form> <br>\r\n"
				+ "			<form><input type=\"Submit\" value=\"View All Requests\"> </form><br>\r\n"
				+ "			<form><input type=\"Submit\" value=\"Check Employees\"></form>"
				+ "		<br>\r\n"
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		User usr = new User();
		usr = (User)session.getAttribute("username");
		System.out.println();
		//System.out.println(usr);
		//response.setContentType("text/html");
	}

}
