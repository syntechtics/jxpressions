package syntechtics.jxpressions;

import org.junit.Assert;
import org.junit.Test;

import parser.ExpressionEvaluator;

public class BooleanTests {

	@Test
	public void lt() {
		tester("2<3;", Boolean.TRUE);
		tester("3<3;", Boolean.FALSE);
		tester("4<3;", Boolean.FALSE);
	}
	
	@Test
	public void le() {
		tester("2<=3;", Boolean.TRUE);
		tester("3<=3;", Boolean.TRUE);
		tester("4<=3;", Boolean.FALSE);
	}
	
	@Test
	public void gt() {
		tester("2.1>3;", Boolean.FALSE);
		tester("3.2>3.2;", Boolean.FALSE);
		tester("4>3;", Boolean.TRUE);
	}
	
	@Test
	public void ge() {
		tester("2>=3;", Boolean.FALSE);
		tester("3>=3;", Boolean.TRUE);
		tester("4>=3;", Boolean.TRUE);
	}
	
	@Test
	public void equals() {
		tester("1==1;", Boolean.TRUE);
		tester("2==1;", Boolean.FALSE);
	}
	
	@Test
	public void notEquals() {
		tester("1!=1;", Boolean.FALSE);
		tester("2!=1;", Boolean.TRUE);
	}
	
	@Test
	public void and() {
		tester("2>3 && 1>2;", Boolean.FALSE);
		tester("2>3 && 3>2;", Boolean.FALSE);
		tester("4>3 && 1>2;", Boolean.FALSE);
		tester("4>3 && 3>2;", Boolean.TRUE);
	}
	
	@Test
	public void or() {
		tester("2>3 || 1>2;", Boolean.FALSE);
		tester("2>3 || 3>2;", Boolean.TRUE);
		tester("4>3 || 1>2;", Boolean.TRUE);
		tester("4>3 || 3>2;", Boolean.TRUE);
	}
	
	@Test
	public void not() {
		tester("!(2>3);", Boolean.TRUE);
		tester("!(2<3);", Boolean.FALSE);
	}
	
	@Test
	public void precedence() {
		tester("3>=3 || 3>2 && 3<2;", Boolean.TRUE);
	}
	
	@Test
	public void combination() {
		tester("1+1*4/2>=9/3 || 3>2 && 3<2;", Boolean.TRUE);
	}
	
	private static void tester(String expression, Boolean expected) {
		try {
			Boolean actual = (Boolean) ExpressionEvaluator.evaluate(expression);
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
