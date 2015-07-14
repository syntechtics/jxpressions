package syntechtics.jxpression.functions;


public class Multiply extends AbstractFunction<Double> {

	private Double t;
	
	public Multiply() {
		super(2, Integer.MAX_VALUE);
	}
	
	@Override
	public Double evaluate() {
		if(t==null) {
			double multiply = 1;
			for(Function<?> f : arguments) {
				multiply*=(double)f.evaluate();
			}
			t = multiply;
		}
		return t;
	}

}
