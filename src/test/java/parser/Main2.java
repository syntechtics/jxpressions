package parser;

import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.tools.ant.filters.StringInputStream;

import java_cup.runtime.Symbol;
import syntechtics.jxpression.functions.*;

public class Main2 {

	private static final String rule = "Concat(name, IfThenElse(age>18 || height/12>4 && Matches(name, \"^Sh.*\"),\" Allowed\",\" Restricted\"));";

	public static void main(String[] args) throws Exception {

		Person p1 =  new Person("Shivam", 32, 72);
		parser p = new parser(new Scanner(new InputStreamReader(new StringInputStream(rule))));
		p.setObject(p1);
		Symbol symbol=p.parse();
		Function function = p.result;
		System.out.println(function.evaluate());
		
		Person p2 =  new Person("Shaurya", 5, 50);
		p = new parser(new Scanner(new InputStreamReader(new StringInputStream(rule))));
		p.setObject(p2);
		symbol=p.parse();
		function = p.result;
		System.out.println(function.evaluate());
		
		p2 =  new Person("Divya", 32, 65);
		p = new parser(new Scanner(new InputStreamReader(new StringInputStream(rule))));
		p.setObject(p2);
		symbol=p.parse();
		function = p.result;
		System.out.println(function.evaluate());
		
		p2 =  new Person("Dia", 1, 30);
		p = new parser(new Scanner(new InputStreamReader(new StringInputStream(rule))));
		p.setObject(p2);
		symbol=p.parse();
		function = p.result;
		System.out.println(function.evaluate());
	}
	
	private static Class<?> loadFunction(String functionName) {
		try {
			return Class.forName("syntechtics.jxpression.functions." + functionName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Constant loadConstant(Object object) {
		Class<?> clazz = loadFunction("Constant");
		Constructor<Constant> function = (Constructor<Constant>) clazz.getConstructors()[0];
		Constant constant;
		try {
			constant = function.newInstance(object);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return constant;
	} 
}
