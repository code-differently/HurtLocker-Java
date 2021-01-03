package com.codedifferently.hurt;

import java.util.Map;

public class Item {

	private String name;
	private String price;
	private String type;
	private String expiration;

	public Item(Map<String,String> rawDataMap){
		this.name = rawDataMap.get("name");
		this.price = rawDataMap.get("price");
		this.expiration = rawDataMap.get("expiration");
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	@Override
	public String toString() {
		return "Item{" + "name='" + name + '\'' + ", price='" + price + '\'' + ", type='" + type + '\'' + ", expiration='" + expiration + '\'' + '}';
	}
}
