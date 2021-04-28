package live.goob.model;

public class User {
	private int userID;
	private String userName;
	private String pass;
	private String nam;
	private String userlevel;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userID, String userName, String pass, String nam, String userlevel) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.pass = pass;
		this.nam = nam;
		this.userlevel = userlevel;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nam == null) ? 0 : nam.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userlevel == null) ? 0 : userlevel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (nam == null) {
			if (other.nam != null)
				return false;
		} else if (!nam.equals(other.nam))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userlevel == null) {
			if (other.userlevel != null)
				return false;
		} else if (!userlevel.equals(other.userlevel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", pass=" + pass + ", nam=" + nam + ", userlevel="
				+ userlevel + "]";
	}	
}

