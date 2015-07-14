package syntechtics.jxpression.functions;

public class IfThenElse<T> extends AbstractFunction<T> {

	T result;

	public IfThenElse() {
		super(3, 3);
	}

	@Override
	public T evaluate() {
		if(result == null) {
			Function<Boolean> f1 = (Function<Boolean>) arguments.get(0);
			Function<T> f2 = (Function<T>) arguments.get(1);
			Function<T> f3 = (Function<T>) arguments.get(2);
			if(f1.evaluate()) {
				result = f2.evaluate();
			}
			else {
				result = f3.evaluate();
			}
		}
		return result;
	}
}
