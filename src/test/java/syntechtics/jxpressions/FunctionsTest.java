package syntechtics.jxpressions;

import org.junit.Assert;
import org.junit.Test;

import parser.ExpressionEvaluator;

public class FunctionsTest {

	@Test
	public void nested() {
		tester("Add(3, Subtract(4,1), 3) / 3 * Square(3) * Multiply(3, Add(2, Subtract(2,1)))==243;",Boolean.TRUE);
	}
	
	@Test
	public void ifThenElse1() {
		tester("IfThenElse(1==1,\"true\",\"false\");","true");
	}
	
	@Test
	public void ifThenElse2() {
		tester("IfThenElse(1==2,\"true\",\"false\");","false");
	}
	
	
	private static void tester(String expression, Object expected) {
		try {
			Object actual = ExpressionEvaluator.evaluate(expression);
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
}
