package com.coe7.domain.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ShoppingCart extends BaseDomain {

	private static final long serialVersionUID = -4310668997934947521L;

	private Customer customer;

	private String note;

	private ShoppingCartStatus status;

	private List<ShoppingItem> items;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<ShoppingItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingItem> items) {
		this.items = items;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void addItem(final ShoppingItem item) {
		if (items == null) {
			items = new ArrayList<ShoppingItem>();
			
		}
		items.add(item);
	}
	public void removeItem(final ShoppingItem item) {
		if (CollectionUtils.isEmpty(items)) {
			return;
		}
		items.remove(item);
	}

}
