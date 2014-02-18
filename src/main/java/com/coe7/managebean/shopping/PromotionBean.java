package com.coe7.managebean.shopping;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.coe7.domain.common.ShoppingCart;
import com.coe7.domain.common.ShoppingItem;
import com.coe7.domain.common.ShoppingProduct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ManagedBean
@SessionScoped
public class PromotionBean {
	
	private final Logger LOG = LoggerFactory.getLogger(PromotionBean.class);
	
	private List<ShoppingProduct> promotionProducts;
	
	private ShoppingCart cart = new ShoppingCart();
	
	private ShoppingProduct currentProduct;
	

	@PostConstruct
	public void init() {
		LOG.info("init promotin product");
		updateCurrentPromotions();
	}
	
	public List<ShoppingProduct> getPromotionProducts() {
		return promotionProducts;
	}

	public void addToShoppingCart() {
		//create new item and add to the card
		if(null != currentProduct) {
			ShoppingItem item = new ShoppingItem();
			item.setCart(cart);
			item.setProduct(currentProduct);
			cart.addItem(item);
		}
	}

	public void setPromotionProducts(List<ShoppingProduct> promotionProducts) {
		this.promotionProducts = promotionProducts;
	}
	
	private void updateCurrentPromotions() {
		promotionProducts = new ArrayList<ShoppingProduct>();
		ShoppingProduct product1 = new ShoppingProduct();
		product1.setId(1l);
		product1.setName("Rebirth Excellent A");
		product1.setUrl("/images/shopping/rebirthA.jpg");
		
		ShoppingProduct product2 = new ShoppingProduct();
		product2.setId(2l);
		product2.setName("Rebirth Excellent B");
		product2.setUrl("/images/shopping/rebirthB.jpg");
		
		promotionProducts.add(product1);
		promotionProducts.add(product2);
		
	}
	public ShoppingProduct getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(ShoppingProduct currentProduct) {
		this.currentProduct = currentProduct;
	}
	
}
