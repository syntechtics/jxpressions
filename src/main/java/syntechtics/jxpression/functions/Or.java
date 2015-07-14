package syntechtics.jxpression.functions;

public class Or extends AbstractFunction<Boolean> {

	private Boolean t;

	public Or() {
		super(2, Integer.MAX_VALUE);
	}
	
	@Override
	public Boolean evaluate() {
		if(t==null) {
			t = Boolean.FALSE;
			for(Function<?> f : arguments) {
				t = t || (Boolean)f.evaluate();
				if(t) {
					break;
				}
			}
		}
		return t;
	}
}
