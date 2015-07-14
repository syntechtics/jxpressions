package syntechtics.jxpression.functions;

public class And extends AbstractFunction<Boolean> {

	public And() {
		super(2, Integer.MAX_VALUE);
	}

	private Boolean t;
	
	@Override
	public Boolean evaluate() {
		if(t==null) {
			t = Boolean.TRUE;
			for(Function<?> f : arguments) {
				t = t && (Boolean)f.evaluate();
				if(!t) {
					break;
				}
			}
		}
		return t;
	}

}
