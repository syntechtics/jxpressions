package parser;

import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.tools.ant.filters.StringInputStream;

import java_cup.runtime.Symbol;
import syntechtics.jxpression.functions.*;

public class Main {

	public static void main(String[] args) throws Exception {

		parser p = new parser(new Scanner(new InputStreamReader(System.in)));
		Symbol symbol=p.parse();
		Function function = p.result;
		System.out.println(function.evaluate());
		
	}
	
}
