package syntechtics.jxpression.functions;

public class Concat extends AbstractFunction<String> {

	public Concat() {
		super(2, 2);
	}
	
	private String t;
	
	@Override
	public String evaluate() {
		if(t==null) {
			t = (String)arguments.get(0).evaluate() + (String)arguments.get(1).evaluate();
		}
		return t;
	}

}
