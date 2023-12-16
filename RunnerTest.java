package ie.atu.dip;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.jupiter.api.Test;

@Suite //to run to testing classes
@SelectClasses({
	CalculatorTest.class, 
	CalculatorSecondTest.class
})
class RunnerTest {

	
}
