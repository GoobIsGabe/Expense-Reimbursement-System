package live.goob.dao;

import java.util.List;

import live.goob.model.Reimburse;
import live.goob.model.User;

public interface ReimburseDAO {

	public Reimburse selectUser(String name);
	public Reimburse selectReimburse(String name);
	public Boolean insertIntoUsers(User usr);
	//public Reimbursement selectReimburse(String name);
	public Boolean alterUser(String user_level, Integer id);
	public List<Reimburse> selectAllUsers();
	public List<Reimburse> selectAllFromUser(String name);
	Boolean insertIntoUsers(User usr, Reimburse rem);
	
}
