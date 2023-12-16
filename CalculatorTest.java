package ie.atu.dip;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class CalculatorTest {
	
	public static Calculator calculator; //static variable for the Calculator instance
	
	//Setup method to run once before all tests
	@BeforeAll
	static void setup( ) {
		System.out.println("Test for Calculator.");
	}
	
	@BeforeEach  //to run before each test
	void init() {
		calculator = new Calculator(); //initialize a new Calculator object before each test
		System.out.println("New test atarted.");
	}
	
	@Test  //verify the basic insurance calculation without any accidents
	void testBasicInsurance () {
		assertDoesNotThrow(() ->  {
			int cost = calculator.calculateInsurance(30, 0);
			assertEquals(500, cost, "Basic insurance - 500");
		});
	}
	
	@ParameterizedTest //parameterized test to verify insurance calculation with varying numbers of accidents
	@ValueSource(ints = {1, 2, 3, 4, 5})  //input for number of accidents
	void testInsuranceWithAccidents(int accidents) {
		//assert that the method does not throw an exception
		assertDoesNotThrow(() -> {
			//calculation of cost for 52 years old person withgiven number of accidents
			int cost = calculator.calculateInsurance(52, accidents);
			assertTrue(cost>500, "Insurance should increase with accidents.");
		});
	}
	
	@Test //to verify that the insurance calculation completes within a given time frame
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS) //set timeout for test
	void testInsuranceCalculationTime() {//Without exception
		assertDoesNotThrow(() -> calculator.calculateInsurance(30, 2));
	}
	
	@Test  //cost for drivers younger 25, 
	void testInsuranceForYoungerDrivers() {
		assertDoesNotThrow(() -> {
			int cost = calculator.calculateInsurance(22, 0);
			assertTrue(cost > 500, "Young driver should have a surcharge.");
		});
	}
	
	@Test //verifying exceprtion thrown for high number of accidents 
	void testExceptionForHighAccidents() {
		Exception exception = assertThrows(Exception.class, () -> {
			calculator.calculateInsurance(30, 16);
		});
		assertEquals("Insurance not feasible for the given accident count.",
		exception.getMessage());
	}
	
	@AfterEach //after each test
	void tearDown() {
		System.out.println("Test completed.");
	}
	
	@AfterAll //indication that testing is completed
	static void tested() {
		System.out.println("Testing is completed.");
	}
 	
}
