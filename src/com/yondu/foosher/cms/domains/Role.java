/**
 * 
 */
package com.yondu.foosher.cms.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;


import com.yondu.foosher.basic.domains.Logged;

/**
 * @author Sean Ross M. Fortunato
 *
 */
@Entity
public class Role extends Logged {
	
	public static final String DESCRIPTION = "description";
	public static final String CODE = "code";

	private List<User> users;
	private Long id;
	private String code;
	private String description;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=ID)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name=DESCRIPTION)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(mappedBy="roles")
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Column(name=CODE)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Transient	//Kailangan to gawing string para sa initbinder :D
	public String getIdString(){
		return new Long(id).toString();
	}
	
}
