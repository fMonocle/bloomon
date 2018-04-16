package com.bloomon.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bloomon.exception.StorageCapacityException;


public class ProductionFacility {
	//private static long STORAGE_CAPACITY = 256;
	private static long STORAGE_CAPACITY = 20;
	
	private List<Flower> flowersStock; // = new ArrayList<Flower>();
	private List<BouquetRule> bouquetRules;// = new ArrayList<BouquetRule>();

	private static  ProductionFacility myProductionFacility;

	public static ProductionFacility getProductionFacility() {
		if (myProductionFacility == null) {
			myProductionFacility = new ProductionFacility();
		}
		return myProductionFacility;
	}

	private ProductionFacility() {
		flowersStock = new ArrayList<Flower>();
		bouquetRules = new ArrayList<BouquetRule>();
	}


	public String calculate() {
		String result = "";
		
		//There is an error after remove bouquet
		for (Iterator <BouquetRule> iterator = bouquetRules.iterator(); iterator.hasNext();) {
			BouquetRule bouquetRule = (BouquetRule) iterator.next();
			result = checkRule(bouquetRule);
		}
		if (result != null) {
			return result;
		}
		return null; // If there is no new Bouquet return null;
	}
	
	private String checkRule(BouquetRule bouquetRule) {
		Boolean success = true;
		
		for (Iterator <FlowerRule> iterator = bouquetRule.getFlowerRules().iterator(); iterator.hasNext() && success;) {
			FlowerRule flowerRule = (FlowerRule) iterator.next();
			if (!flowersInStock(flowerRule)) {
				success = false;
			}
		}
		
		if (success) {
			String bouqueteId = bouquetRule.getIdentifier();
			String bouqueteSize = bouquetRule.getSize();
			
			List <FlowerRule> flowerRules = bouquetRule.getFlowerRules();
					
			String fRules = "";
			
			for (Iterator<FlowerRule> iterator = flowerRules.iterator(); iterator.hasNext();) {
				FlowerRule flowerRule = (FlowerRule) iterator.next();
				fRules += flowerRule.getQuantity()+flowerRule.getIdentifier();
			}
			
			
			Iterator<BouquetRule> it = bouquetRules.iterator();
			BouquetRule bRule;
			
			//Hago el remove del bouquet cumplido
			while (it.hasNext()) {
				bRule = it.next();
			    if (bRule.equals(bouquetRule)) {
			        it.remove();
			    }
			}
			
			return "Bouquete: "+ bouqueteId + bouqueteSize+fRules;
		}
		return null;
	}
	
	private boolean flowersInStock(FlowerRule flowerRule) {
		
		int flowerRuleQuantity = flowerRule.getQuantity();
		int flowerTypeQuantity = 0;
		
		for (Iterator <Flower> iterator = flowersStock.iterator(); iterator.hasNext();) {
			Flower flower = (Flower) iterator.next();
			if (flower.getSize().equals(flowerRule.getSize())) {
				if (flower.getIdentifier().equals(flowerRule.getIdentifier())) {
					flowerTypeQuantity += 1;
				}
			}
		}
		
		if (flowerRuleQuantity > flowerTypeQuantity) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addRoule(String bufferInput) {
		this.bouquetRules.add(new BouquetRule(bufferInput));
	}

	public void addFlower(String bufferInput) throws StorageCapacityException {
		this.flowersStock.add(new Flower(bufferInput));
		if (flowersStock.size()>ProductionFacility.STORAGE_CAPACITY){
			throw new StorageCapacityException();
		}
	}




}
