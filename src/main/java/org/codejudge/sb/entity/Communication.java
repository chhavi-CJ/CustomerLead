package org.codejudge.sb.entity;

public class Communication {
	private String communication;

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Override
	public String toString() {
		return "Communication [communication=" + communication + "]";
	}

	public Communication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Communication(String communication) {
		super();
		this.communication = communication;
	}
}
