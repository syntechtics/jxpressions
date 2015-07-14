package syntechtics.jxpressions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import parser.ExpressionEvaluator;

public class IdentifierTest {

	private List<Person> persons = new ArrayList<>();
	
	@Before
	public void prepare() {
		persons.add(new Person("Sarita", 70, 63, "Female", "Worship"));
		persons.add(new Person("Shivam", 32, 72, "Male", "Software Development Manager"));
		persons.add(new Person("Divya", 32, 65, "Female", "Software Development Manager"));
		persons.add(new Person("Shaurya", 5, 48, "Male", "Make noise"));
		persons.add(new Person("Dia", 1, 36, "Female", "Break everything"));
		persons.add(new Person("SK Sharma", 62, 70, "Male", "India Air Force - Government of India"));
		persons.add(new Person("Pushpa Sharma", 62, 63, "Female", "India Air Force - Government of India"));
	}

	@Test
	public void calculateTrainTicketPrice()  {
		String formula = "IfThenElse(age<12, 500, 1000 * IfThenElse(age>=60, 0.7, 1) * IfThenElse(gender==\"Female\", 0.9, 1.0) * IfThenElse(Matches(occupation, \".*Government.*\"), 0.8, 1.0));";
		for(Person p : persons) {
			try {
				System.out.println(p.getName() + ":" +  ExpressionEvaluator.evaluate(formula, p));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
	private class Person {
		private final String name;
		private final int age;
		private final int height;
		private final String gender;
		private final String occupation;
		public Person(String name, int age, int height, String gender, String occupation) {
			super();
			this.name = name;
			this.age = age;
			this.height = height;
			this.gender = gender;
			this.occupation = occupation;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public int getHeight() {
			return height;
		}
		public String getGender() {
			return gender;
		}
		public String getOccupation() {
			return occupation;
		}
	}
	
}
