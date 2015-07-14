package syntechtics.jxpression.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFunction<T> implements Function<T> {

	private final int minArgs;
	private final int maxArgs;
	protected final List<Function<?>> arguments;
	
	public AbstractFunction(int minArgs, int maxArgs) {
		this.minArgs=minArgs;
		this.maxArgs=maxArgs;
		this.arguments=new ArrayList<>();
	}
	
	@Override
	public void setArgs(Function<?>... operand) {
		if(operand.length < minArgs || operand.length > maxArgs) {
			throw new IllegalArgumentException("Invalid number of arguments (" + operand.length + "). The arguments for function " + getClass() + " should be between " + minArgs +  " and "  + maxArgs + ".");
		}
		arguments.addAll(Arrays.asList(operand));
	}
}
