package org.shedin.task3;

import java.util.ArrayList;
import java.util.List;

import static org.shedin.task3.PersonHelper.findUniqueNames;


public class ThirdTaskRunner {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Peter", "Patterson", 21));
		personList.add(new Person("Paul", "Walker", 31));
		personList.add(new Person("Steve", "Runner", 17));
		personList.add(new Person("Arnold", "", -1));
		personList.add(new Person(" ", "Stevenson", 19));
		personList.add(new Person("   ", "Stevenson", 19));
		personList.add(new Person("      ", "Stevenson", 19));
		personList.add(new Person(" Arnold", "Stevenson", 19));
		personList.add(null);
		personList.add(new Person("Aaron", "Bortnicker", 18));

		System.out.println("All unique names from the list for adults: " + findUniqueNames(personList));
	}
}