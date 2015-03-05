/**
 * 
 */
package com.yondu.foosher.basic.dto;

import java.util.List;

import org.springframework.beans.support.PagedListHolder;

/**
 * @author Sean Ross M. Fortunato
 * @param <E>
 *
 */
public class FoosherPagedListHolder<E> extends PagedListHolder<E> {

	private String column;
	private Boolean isAscending;
	private String searchName;
	private String searchCategory;
	private Integer countTotal;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FoosherPagedListHolder(List<E> list){
		super((List<E>) list);
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}


	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public Integer getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(Integer countTotal) {
		this.countTotal = countTotal;
	}

	public Boolean getIsAscending() {
		return isAscending;
	}

	public void setIsAscending(Boolean isAscending) {
		this.isAscending = isAscending;
	}

	
}
