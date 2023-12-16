package ie.atu.dip;

public class Calculator {
	//constants for insurance calculation
	private static final int BASIC_INSURANCE = 500; //base cost
	private static final int YOUNG_AGE_SURCHARGE = 100;//additional cost for young drivers
	private static final int[] ACCIDENT_SURCHARGES = new int[] {0, 50, 125, 225, 375, 575}; //charges according the number of accidents
	
	//method to determine if insurance should be denied based on age and number of accidents
	public static void isInsuranceDenied(int age, int accidents) throws Exception{
		if (age < 16 || accidents > ACCIDENT_SURCHARGES.length ) {
			throw new Exception("No insurance"); //throws an exception if driver too younge or number of accidents doesnt meet criteria 
		}
	}
	//calculation of total cost based on age, number of accidents
	public int calculateInsurance (int age, int accidents) throws Exception {
		int total = BASIC_INSURANCE; //starting with base cost
		if (accidents > ACCIDENT_SURCHARGES.length) {
		throw new Exception ("Insurance not feasible for the given accident count.");
	}
	
	if (age <25) { //adding cost for younger
		total += YOUNG_AGE_SURCHARGE;
	}
	if (accidents >=0 && accidents < ACCIDENT_SURCHARGES.length) {
		total += ACCIDENT_SURCHARGES[accidents]; //add accident surcharge based on 
	}
	return total;
	

}
}