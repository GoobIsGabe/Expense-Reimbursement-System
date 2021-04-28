package live.goob.dao;

import java.util.List;


import live.goob.model.User;

public interface UserDAO {

	public User selectUser(String name);
	public Boolean alterUser(String user_level, Integer id);
	public List<User> selectAllUsers();
	
}
