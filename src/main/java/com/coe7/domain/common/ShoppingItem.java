package com.coe7.domain.common;


public class ShoppingItem extends BaseDomain{

	private static final long serialVersionUID = 3801548325641433995L;
	
	private ShoppingProduct product;
	
	private ShoppingCart cart;
	
	public ShoppingProduct getProduct() {
		return product;
	}
	public void setProduct(ShoppingProduct product) {
		this.product = product;
	}
	
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	
}
