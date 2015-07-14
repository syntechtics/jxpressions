package syntechtics.jxpression.functions;

public class Subtract extends AbstractFunction<Double> {

	private Double t;
	
	public Subtract() {
		super(2, 2);
	}
	
	@Override
	public Double evaluate() {
		if(t==null) {
			t = (double)arguments.get(0).evaluate() - (double)arguments.get(1).evaluate();
		}
		return t;
	}

}
