package syntechtics.jxpression.functions;

public class GreaterThan extends BooleanFunction {

	@Override
	public Boolean performCheck() {
		return ((Comparable)arguments.get(0).evaluate()).compareTo(arguments.get(1).evaluate())>0;
	}

}
