package com.coe7.domain.common;

public class ShoppingProduct extends BaseDomain{

	private static final long serialVersionUID = 2073277079609408973L;
	
	private String name;
	
	private Double price;
	
	private String url;
	
	private String description;
	
	private ProductStatus status;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
