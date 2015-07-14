package syntechtics.jxpression.functions;

public class Mod extends AbstractFunction<Double> {

	private Double t;
	
	public Mod() {
		super(2, 2);
	}
	
	@Override
	public Double evaluate() {
		if(t==null) {
			t = (double)arguments.get(0).evaluate() % (double)arguments.get(1).evaluate();
		}
		return t;
	}
}
