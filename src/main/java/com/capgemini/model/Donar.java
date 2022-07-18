package com.capgemini.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "donars")
public class Donar {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donarId;
    private String donarName;
    private String email;
    private String phone;
    private String username;
    private String password;
    
    
    
	public Donar(int donarId, String donarName, String email, String phone, String username, String password) {
		super();
		this.donarId = donarId;
		this.donarName = donarName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		
		
	}
	public Donar() {
		// TODO Auto-generated constructor stub
	}
	public int getDonarId() {
		return donarId;
	}
	public void setDonarId(int donarId) {
		this.donarId = donarId;
	}
	public String getDonarName() {
		return donarName;
	}
	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(donarId, donarName, email, password, phone, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donar other = (Donar) obj;
		return donarId == other.donarId && Objects.equals(donarName, other.donarName)
				&& Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Donar [donarId=" + donarId + ", donarName=" + donarName + ", email=" + email + ", phone=" + phone
				+ ", username=" + username + ", password=" + password + "]";
	}
    
    

}
