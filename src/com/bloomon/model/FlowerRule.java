package com.bloomon.model;

public class FlowerRule {

	private String identifier; // A - Z
	private String size; // L S
    private Integer quantity;
	
	public FlowerRule(String flowerRuleString , String sizeBouquetRule) {
/*
10a
10b
15b
5c
20a
15c
20b
*/
		identifier = flowerRuleString.substring(flowerRuleString.length()-1,flowerRuleString.length()) ;
		quantity = new Integer(flowerRuleString.substring(0,flowerRuleString.length()-1));
		size = sizeBouquetRule;
	
	} 
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	
	
}
