package live.goob.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import live.goob.model.User;
import live.goob.connectionutil.ConnectionUtility;

public class UserDAOImpl implements UserDAO {

	public static User usr = null;
	public static ResultSet rs = null;
	public static PreparedStatement ps = null;

	@Override
	public User selectUser(String name) {
		User usr = new User();
		try {
			// selecting the entries from the database with your name...
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"Harper12");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.associates WHERE username =?");
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
				usr.setUserID(rs.getInt(1));
				usr.setUserName(rs.getString(2));
				usr.setPass(rs.getString(3));
				usr.setNam(rs.getString(4));
				usr.setUserlevel(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}
		// We want to return the created employee at the end of the method...
		return usr;
	}

	@Override
	public Boolean alterUser(String user_level, Integer id) {
		try {
			// selecting the entries from the database with your name...
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"Harper12");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.associates WHERE username =?");
			ps.setString(1, user_level);
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> selectAllUsers() {
		User usr = new User();
		ArrayList<User> uList = new ArrayList<User>();
		try {
			// selecting the entries from the database with your name...
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"Harper12");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.associates");
			// ps.setString(1, name);
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
				usr.setUserID(rs.getInt(1));
				usr.setUserName(rs.getString(2));
				usr.setPass(rs.getString(3));
				usr.setNam(rs.getString(4));
				usr.setUserlevel(rs.getString(5));
				uList.add(usr);
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}
		// We want to return the created employee at the end of the method...
		return uList;

	}
}
