package ie.atu.dip;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;


class CalculatorSecondTest {
	
	public static Calculator calculator;
	
	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}
	

	
	@Test 
	void testInsuranceDeniedForUnderage() {
		Exception exception = assertThrows(Exception.class, () -> {
			Calculator.isInsuranceDenied(12, 0);
		});
		assertEquals("No insurance", exception.getMessage());
		}

	
	@AfterAll
	static void tested() {
		System.out.println("Testing for Underage completed.");
	}
 	
}