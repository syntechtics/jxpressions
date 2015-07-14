package syntechtics.jxpression.functions;


public abstract class BooleanFunction extends AbstractFunction<Boolean> {

	private Boolean t;

	public BooleanFunction() {
		super(2, 2);
	}

	@Override
	public Boolean evaluate() {
		if(t==null) {
			t  = performCheck();
		}
		return t;
	}
	
	public abstract Boolean performCheck();

}
