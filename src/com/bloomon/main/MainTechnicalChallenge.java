package com.bloomon.main;

import com.bloomon.exception.StorageCapacityException;
import com.bloomon.model.ProductionFacility;

public class MainTechnicalChallenge {

	private static int NEW_LINE = 10;
	private static int RETURN_LINE = 13;

	public static void main(String[] args) throws java.io.IOException {

		int inputCharacter;
		String bufferInput = new String();
		boolean rulesInputStage = true; // Until <new line>

		ProductionFacility productionFacility = ProductionFacility.getProductionFacility(); // SINGLETON

		while ((inputCharacter = System.in.read()) != -1 && !productionFacility.isCompleted()) {
			if (inputCharacter != NEW_LINE) {
				if (inputCharacter != RETURN_LINE) {
					bufferInput += (char) inputCharacter;
				}
			} else {
				if (bufferInput.equals("")) { // <empty line> Flowers inputs started
					rulesInputStage = false;
				} else	if (rulesInputStage) {
					productionFacility.addRoule(bufferInput);
				} else { // Flower
					try {
						productionFacility.addFlower(bufferInput);
					} catch (StorageCapacityException e) {
						System.exit(1);
					}

					String resultBouquet = productionFacility.calculate();
					if (resultBouquet != null) {
						System.out.println(resultBouquet);
					}
				}

				bufferInput = "";
			}
		}

	}

}
