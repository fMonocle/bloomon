package com.bloomon.model;

import java.util.ArrayList;
import java.util.List;

public class BouquetRule {

	private String identifier; // A - Z
	private String size; // L S
	private Integer total; // The total of flowers of the rule.
	private List<FlowerRule> flowerRules;
	
	public BouquetRule(String ruleString) {
		/*
		 * AL10a15b5c30
			AS10a10b25
			BL15b1c21
			BS10b5c16
			CL20a15c33
			DL20b28
					 * 
					 * */
		
		identifier = ruleString.substring(0,1);
		size = ruleString.substring(1,2);
		flowerRules = new ArrayList<FlowerRule>();
		
		char[] ruleCharArray = ruleString.substring(2).toCharArray();
		String flowerRuleString = "";
		int totalFlowerRules = 0;
		for (int i = 0; i < ruleCharArray.length; i++) {
			flowerRuleString += (char) ruleCharArray[i];
			if (Character.isAlphabetic(ruleCharArray[i])) {
				FlowerRule flowerRule = new FlowerRule(flowerRuleString,size);
				flowerRules.add(flowerRule);
				totalFlowerRules = totalFlowerRules + flowerRule.getQuantity();
				flowerRuleString = "";
			}
		}
		
		if (flowerRuleString!=""){ // Finalizo y es numerico, tenía el total
			total = new Integer(flowerRuleString);
		}else {
			total = totalFlowerRules;
		}
		
		
	
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<FlowerRule> getFlowerRules() {
		return flowerRules;
	}

	public void setFlowerRules(List<FlowerRule> flowerRules) {
		this.flowerRules = flowerRules;
	}



	
	
	
}
