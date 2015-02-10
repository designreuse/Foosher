/**
 * 
 */
package com.yondu.foosher.inventory.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yondu.foosher.basic.domains.Logged;

/**
 * @author S.FORTUNATO
 *
 */
@Entity
public class Category extends Logged {

	private Long id;
	private String description;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
