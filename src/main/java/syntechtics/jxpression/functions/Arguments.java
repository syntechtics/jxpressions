package syntechtics.jxpression.functions;


public class Arguments extends AbstractFunction<Function<Object>[]> {

	public Arguments() {
		super(1, Integer.MAX_VALUE);
	}
	
	public void addArgument(Function<Object> function) {
		arguments.add(function);
	}
	
	@Override
	public Function<Object>[] evaluate() {
		Function[] result = new Function[arguments.size()];
		int i=0;
		for(Function object : arguments) {
			result[i++]=object;
		}
		return result;
	}

}
