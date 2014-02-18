package com.coe7.domain.common;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author JANLAKHONK
 * 
 * Base domain to crate member
 * 
 *
 */
public abstract class BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 4344101768446939526L;
	private Long Id;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Member getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Member createdBy) {
		this.createdBy = createdBy;
	}
	private Date createdDate;
	private Member createdBy;
}
