package org.codejudge.sb.reponse;

public class FailureResponse {
	private String status;
	private String reason;
	
	@Override
	public String toString() {
		return "FailureResponse [status=" + status + ", reason=" + reason + "]";
	}
	public FailureResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FailureResponse(String status, String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
