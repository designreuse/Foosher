/**
 * 
 */
package com.yondu.foosher.cms.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.yondu.foosher.basic.domains.Logged;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Entity
public class User extends Logged {

	private List<Role> roles;
	
	private Long id;
	private String username;
	private String password;
	private String email;
	
	private String firstname;
	private String middlename;
	private String lastname;
	
	private String address;
	private String city;
	private String zipcode;
	
	private String contactno;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column
	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role", 
		joinColumns={@JoinColumn(name="user_id", nullable=false)},
		inverseJoinColumns={@JoinColumn(name="role_id", nullable=false)})
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Transient
	public String getFullName(){
		String fullname = "";
		if(middlename == null || middlename.length() < 1){
			fullname += firstname + " " + lastname;
		} else {
			fullname += firstname + " " + middlename + " " + lastname;
		}
		return fullname;
	}
}
