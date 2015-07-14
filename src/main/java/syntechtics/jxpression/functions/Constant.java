package syntechtics.jxpression.functions;

public class Constant<T> implements Function<T> {

	private final T t;
	
	public Constant(T t) {
		this.t = t;
	}
	
	@Override
	public T evaluate() {
		return t;
	}

	@Override
	public void setArgs(Function<?> ... arg) {
		throw new UnsupportedOperationException("setArgs not supported for constant values");
	}

	@Override
	public String toString() {
		return "Constant [t=" + t + "]";
	}

}
