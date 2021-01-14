package org.codejudge.sb.reponse;

import org.codejudge.sb.enums.Location_type;
import org.codejudge.sb.enums.Status;

public class CreatedResp {
	
	private Integer id;
	private String first_name;
	private String last_name;
	private String mobile;
	private String email;
	private Location_type location_type;
	private String location_string;
	private Status status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Location_type getLocation_type() {
		return location_type;
	}
	public void setLocation_type(Location_type location_type) {
		this.location_type = location_type;
	}
	public String getLocation_string() {
		return location_string;
	}
	public void setLocation_string(String location_string) {
		this.location_string = location_string;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public CreatedResp(Integer id, String first_name, String last_name, String mobile, String email,
			Location_type location_type, String location_string, Status status) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.email = email;
		this.location_type = location_type;
		this.location_string = location_string;
		this.status = status;
	}
	public CreatedResp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CreatedResp [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", mobile="
				+ mobile + ", email=" + email + ", location_type=" + location_type + ", location_string="
				+ location_string + ", status=" + status + "]";
	}
	
}
