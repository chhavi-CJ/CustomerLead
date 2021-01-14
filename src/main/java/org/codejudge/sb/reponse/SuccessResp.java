package org.codejudge.sb.reponse;

public class SuccessResp {
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SuccessResp(String status) {
		super();
		this.status = status;
	}

	public SuccessResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SuccessResp [status=" + status + "]";
	}
	
}
