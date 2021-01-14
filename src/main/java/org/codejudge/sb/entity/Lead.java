package org.codejudge.sb.entity;

import org.codejudge.sb.enums.Location_type;
import org.codejudge.sb.enums.Status;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "customerLead")
public class Lead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	private String first_name;
	
	@NotNull
	private String last_name;
	
	@NotNull
	@Size(min=10, max=80, message="should have a minimum length of 10 characters.")
	@Column(unique = true)
	private String mobile;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Column(name = "loaction_type")
	@Enumerated(EnumType.STRING)
	private Location_type location_type;
	
	@NotNull
	private String location_string;
	
	@NotNull
	@Column(name = "status" )
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(columnDefinition="varchar(255) default null")
	private String communication;
	
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
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public Lead(Integer id, String first_name, String last_name, String mobile, String email,
			Location_type location_type, String location_string, Status status, String communication) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.email = email;
		this.location_type = location_type;
		this.location_string = location_string;
		this.status = status;
		this.communication = communication;
	}
	public Lead() {
		super();
	}
	@Override
	public String toString() {
		return "Lead [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", mobile=" + mobile
				+ ", email=" + email + ", location_type=" + location_type + ", location_string=" + location_string
				+ ", status=" + status + ", communication=" + communication + "]";
	}
	
}
