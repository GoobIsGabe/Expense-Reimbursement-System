package live.goob.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import live.goob.connectionutil.ConnectionUtility;
import live.goob.dao.ReimburseDAO;
import live.goob.dao.ReimburseDAOImpl;
import live.goob.model.Reimburse;
import live.goob.model.User;

/**
 * Servlet implementation class EmpView
 */
public class EmpView extends HttpServlet {
	ReimburseDAO yes;
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpView() {
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
		Reimburse rem = (Reimburse)session.getAttribute("username");
		
		String name = usr.getNam();
		String username = usr.getUserName();		
		//String UserName = (String) session.getAttribute("username");
		
		
		//Reimburse test = selectUser(username);
		
	//	rem.setUsername(username);
		
		//System.out.println(usr.getUserName());
		//rem.setUsername(username);
		//work with this
		Reimburse rems = yes.selectReimburse(username);
		
		List<Reimburse> r = yes.selectAllFromUser(username);
		
		String toString = "<table><tr><th>ID</th><th>Username</th><th>Reason</th><th>Status</th><th>Amount</th><th>Date</th></tr>";
		
		for(int i=0; i<r.size(); i++) {
			Reimburse test = r.get(i);
			toString += "<tr><td>" +test.getReimburseid() + "<td>" +
			test.getUsername()+ "<td>" +test.getReason()+ "<td>" +
			test.getStatus()+ "<td>" +test.getAmount()+ "<td>" +test.getDate();
		}
		toString +="</tr></table>";
		//usr = (User)session.getAttribute("username");
		
		//List<Reimburse> rems = ReimburseDAO.selectAllUsers();
		
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
				+ "				<p class=\"lead\">What would you like to do?</p>\r\n"
				+ "		<form action=\"EmpView\"><input type=\"Submit\" value=\"View Requests\"></form><div></div> <br>\r\n"
				+ "			<form action=\"CreateRequest\" method=\"post\">\r\n"
				+ "				Reason: <input type=\"text\" name = \"reason\"> <br>Amount: <input type=\"number\" name = \"amount\"> <br>\r\n"
				+ "				<input type=\"Submit\" value=\"Create New Request\"> </form><br>\r\n"
				+ "		\r\n"
				+ "			<form><input type=\"Submit\" value=\"Update/View Information\"></form>"
				+ "\r\n"
				+ toString + "	</div>\r\n"
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
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		User usr = new User();
		usr = (User)session.getAttribute("username");
		System.out.println();
		//System.out.println(usr);
		//response.setContentType("text/html");
		
	}

	@Override
	public void init() throws ServletException {
		yes = new ReimburseDAOImpl();
	}

}
