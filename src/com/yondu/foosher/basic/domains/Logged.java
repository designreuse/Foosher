/**
 * 
 */
package com.yondu.foosher.basic.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author S.FORTUNATO
 *
 */
@MappedSuperclass
public abstract class Logged {
	
	public final static String ID = "id";
	public final static String CREATED_AT = "createdAt";
	public final static String UPDATED_AT = "updatedAt";
	public final static String ENABLED = "enabled";
	
	protected Date createdAt;
	protected Date updatedAt;
	protected boolean enabled;
	
	@Column(name=ENABLED)
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name=CREATED_AT)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name=UPDATED_AT)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
