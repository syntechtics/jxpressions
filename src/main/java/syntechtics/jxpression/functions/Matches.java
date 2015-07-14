package syntechtics.jxpression.functions;

public class Matches extends BooleanFunction {

	@Override
	public Boolean performCheck() {
		String text = (String)arguments.get(0).evaluate();
		String pattern = (String)arguments.get(1).evaluate();
		return text.matches(pattern);
	}

}
