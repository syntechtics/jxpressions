package syntechtics.jxpression.functions;


public interface Function<T> {

	
	
	void setArgs(Function<?> ... operand);
	
	T evaluate();
	
}
