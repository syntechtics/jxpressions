package syntechtics.jxpression.functions;

public class Not extends AbstractFunction<Boolean> {

	private Boolean t;
	
	public Not() {
		super(1, 1);
	}
	
	@Override
	public Boolean evaluate() {
		if(t==null) {
			t = !((Boolean)arguments.get(0).evaluate());
		}
		return t;
	}

}
