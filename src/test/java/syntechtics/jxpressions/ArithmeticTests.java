package syntechtics.jxpressions;

import org.junit.Assert;
import org.junit.Test;

import parser.ExpressionEvaluator;

public class ArithmeticTests {

	@Test
	public void sum() {
		tester("3+4;", 7D);
		tester("2+1;", 3D);
	}
	
	@Test
	public void minus() {
		tester("2-3;", -1D);
		tester("2-1;", 1D);
	}
	
	@Test
	public void uminus() {
		tester("-2-3;",-5D);
		tester("2+-3;",-1D);
		tester("-2+-3;",-5D);
	}
	
	@Test
	public void multiply() {
		tester("2*3;",6D);
		tester("2*-3;",-6D);
		tester("7*0;",0D);
	}
	
	@Test
	public void divide() {
		tester("4/2;",2D);
		tester("-5/2;",-2.5D);
		tester("7/0;",Double.POSITIVE_INFINITY);
	}
	
	@Test
	public void mod() {
		tester("7%4;", 3D);
	}
	
	@Test
	public void precedence() {
		tester("3+4/2-1*(1+4%3);",3D);
	}
	
	@Test
	public void brackets() {
		tester("2/(1+1);",1D);
	}
	
	private static void tester(String expression, Double expected) {
		try {
			Double actual = (Double) ExpressionEvaluator.evaluate(expression);
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
}
