package org.codejudge.sb.reponse;

public class ComStatusResp {
	private String status;
	private String communication;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public ComStatusResp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComStatusResp(String status, String communication) {
		super();
		this.status = status;
		this.communication = communication;
	}
	@Override
	public String toString() {
		return "ComStatusResp [status=" + status + ", communication=" + communication + "]";
	}

}
