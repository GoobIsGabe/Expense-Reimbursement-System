package live.goob.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import live.goob.model.Reimburse;
import live.goob.model.User;
import live.goob.connectionutil.ConnectionUtility;

public class ReimburseDAOImpl implements ReimburseDAO {

	public static User usr = null;
	public static Reimburse rem = null;
	public static ResultSet rs = null;
	public static PreparedStatement ps = null;
	
	@Override
	public Reimburse selectUser(String name) {

		
		try {
			// selecting the entries from the database with your name...
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","Harper12");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.reimburse WHERE username =?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			// Look at the values from the result set, and use the set methods to
			// populate the appropriate fields
			while (rs.next()) {
				// When we use the get methods for our result set
				// we reference the column associated from our table
				// in our case:
				// userid is column 1
				// username is column 2
				// pass is column 3
				// nam is column 4
				// userlevel is column 5
				rem.setReimburseid(rs.getInt(1));
				rem.setUsername(rs.getString(2));
				rem.setReason(rs.getString(3));
				rem.setStatus(rs.getString(4));
				rem.setAmount(rs.getInt(5));
				rem.setDate(rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}
		// We want to return the created employee at the end of the method...
		return rem;
	}
	@Override
	public Reimburse selectReimburse(String name) {
		// This is our model that represents the data from our database
				User usr = null;
				Reimburse rem = null;
				
				// The ResultSet is a representation of the data from our DB
				ResultSet rs = null;
				
				// JDBC offers 3 statements, Simple, Prepared and Callable. We use
				// PreparedStatements when we want to pass parameters to the statement itself
				PreparedStatement ps = null;
				try (Connection conn = ConnectionUtility.getConnection()) {
					// SELECT * FROM examples.employees WHERE emp_id = 1000;
					ps = conn.prepareStatement("SELECT * FROM ers.reimburse WHERE username=?");
					ps.setString(1, name);
					rs = ps.executeQuery();

					while (rs.next()) {

						rem = new Reimburse(
								rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3),
								rs.getString(4),
								rs.getInt(5),
								rs.getString(6)
								);
						
						/*System.out.println("Reimburse ID: " + rs.getInt(1) + "\t UserName: " + rs.getString(2) + 
								"\tReason: " +rs.getString(3) + "\tStatus: " + rs.getString(4) +
								"\tAmount: " + rs.getInt(5) + "\tDate: " + rs.getString(6));*/
						StringBuilder test = new StringBuilder();
						StringBuilder str = test.append(rem).append(" <br>");
						System.out.println(str + " This is str");
						
						return rem;
						}
					

				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
				return rem;
	}
	@Override
	public Boolean alterUser(String user_level, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Reimburse> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean insertIntoUsers(User usr, Reimburse rem) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO project.users (username, reason, reimburseStatus, reimburseAmount, reimbursedate)"
					+ "VALUES(?, ?, ?, ?, ?)");//VALUES( same # of inputs as columns)
			
//			ps.setInt(1, usr.getUser_id());
			ps.setString(1, usr.getUserName());
			ps.setString(2, rem.getReason());
			ps.setString(3, "pending");
			ps.setInt(4, rem.getAmount());
			
			final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			String datenow = sdf.toString();
			
			//test to make sure date is right
			System.out.println(datenow);
			
			ps.setString(5, datenow);
			
			//BAM SQL has been sent from prepared statement down below
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public Boolean insertIntoUsers(User usr) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Reimburse> selectAllFromUser(String name) {
		// This is our model that represents the data from our database

		
		// The ResultSet is a representation of the data from our DB
		ResultSet rs = null;
		
		// JDBC offers 3 statements, Simple, Prepared and Callable. We use
		// PreparedStatements when we want to pass parameters to the statement itself
		PreparedStatement ps = null;
		ArrayList<Reimburse> rem = new ArrayList<Reimburse>();
		try (Connection conn = ConnectionUtility.getConnection()) {
			// SELECT * FROM examples.employees WHERE emp_id = 1000;
			ps = conn.prepareStatement("SELECT * FROM ers.reimburse WHERE username=?");
			ps.setString(1, name);
			rs = ps.executeQuery();

			while (rs.next()) {

				Reimburse list = new Reimburse();
				list.setReimburseid(rs.getInt(1));
				list.setUsername(rs.getString(2));
				list.setReason(rs.getString(3));
				list.setStatus(rs.getString(4));
				list.setAmount(rs.getInt(5));
				list.setDate(rs.getString(6));
				
				rem.add(list);
				/*System.out.println("Reimburse ID: " + rs.getInt(1) + "\t UserName: " + rs.getString(2) + 
						"\tReason: " +rs.getString(3) + "\tStatus: " + rs.getString(4) +
						"\tAmount: " + rs.getInt(5) + "\tDate: " + rs.getString(6));*/
//				StringBuilder test = new StringBuilder();
//				StringBuilder str = test.append(rem).append(" <br>");
//				System.out.println(str + " This is str");
//				
				//return rem;
				}
			

		} catch (SQLException e) {
			e.printStackTrace();
			return rem;
		}
		return rem;
	}
}
