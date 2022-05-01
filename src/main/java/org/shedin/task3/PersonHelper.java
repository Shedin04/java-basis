package org.shedin.task3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersonHelper {
	public static List<String> findUniqueNames(List<Person> people) {
		return Optional.ofNullable(people)
				.map(list -> list.stream()
						.filter(Objects::nonNull)
						.map(person -> person.getFirstName().replaceAll("[^a-zA-Z]", "").toUpperCase(Locale.ROOT))
						.filter(name -> name.length() > 0)
						.distinct()
						.collect(Collectors.toList()))
				.orElse(null);
	}
}
