package live.goob.model;

import java.sql.Date;

public class Reimburse {
	private int reimburseid;
	private String username;
	private String reason;
	private String status;
	private int amount;
	private String date; //
	public Reimburse() {
		super();
	}

	public Reimburse(int reimburseid, String username, String reason, String status, int amount, String date) {
		super();
		this.reimburseid = reimburseid;
		this.username = username;
		this.reason = reason;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}

	public int getReimburseid() {
		return reimburseid;
	}
	public void setReimburseid(int reimburseid) {
		this.reimburseid = reimburseid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimburseid;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Reimburse other = (Reimburse) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimburseid != other.reimburseid)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimburseid=" + reimburseid + ", username=" + username + ", reason=" + reason
				+ ", status=" + status + ", amount=" + amount + ", date=" + date + "]";
	}
}
