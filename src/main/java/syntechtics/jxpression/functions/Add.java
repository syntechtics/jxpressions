package syntechtics.jxpression.functions;

public class Add extends AbstractFunction<Double> {

	public Add() {
		super(2, Integer.MAX_VALUE);
	}

	private Double t;
	
	@Override
	public Double evaluate() {
		if(t==null) {
			double sum = 0.0;
			for(Function<?> f : arguments) {
				sum+=(double)f.evaluate();
			}
			t = sum;
		}
		return t;
	}

}
