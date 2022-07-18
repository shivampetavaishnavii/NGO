package com.capgemini.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "needypeoples")
public class NeedyPeople {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int needypersonId;
    private String needypersonName;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String familyIncome;
	public NeedyPeople(int needypersonId, String needypersonName, String email, String phone, String username,
			String password, String familyIncome) {
		super();
		this.needypersonId = needypersonId;
		this.needypersonName = needypersonName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.familyIncome = familyIncome;
	}
	public NeedyPeople() {
		// TODO Auto-generated constructor stub
	}
	public  int getNeedypersonId() {
		return needypersonId;
	}
	public void setNeedypersonId(int needypersonId) {
		this.needypersonId = needypersonId;
	}
	public String getNeedypersonName() {
		return needypersonName;
	}
	public void setNeedypersonName(String needypersonName) {
		this.needypersonName = needypersonName;
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
	public String getFamilyIncome() {
		return familyIncome;
	}
	public void setFamilyIncome(String familyIncome) {
		this.familyIncome = familyIncome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, familyIncome, needypersonId, needypersonName, password, phone, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NeedyPeople other = (NeedyPeople) obj;
		return Objects.equals(email, other.email) && Objects.equals(familyIncome, other.familyIncome)
				&& needypersonId == other.needypersonId && Objects.equals(needypersonName, other.needypersonName)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "NeedyPeople [needypersonId=" + needypersonId + ", needypersonName=" + needypersonName + ", email="
				+ email + ", phone=" + phone + ", username=" + username + ", password=" + password + ", familyIncome="
				+ familyIncome + "]";
	}
    
    
    

}
