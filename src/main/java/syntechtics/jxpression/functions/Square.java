package syntechtics.jxpression.functions;

public class Square extends AbstractFunction<Double> {

	private Double t;
	
	public Square() {
		super(1, 1);
	}
	
	@Override
	public Double evaluate() {
		if(t==null) {
			t = (double)arguments.get(0).evaluate();
			t = t * t;
		}
		return t;
	}

}
