package org.shedin.task1;

import java.util.Collection;


public class FirstTaskRunner {

	public static void main(String[] args) {
		final String fileName = "first-task.txt";
		String text = Utils.readFromFile(fileName);
		Collection<String> startsFromO = Utils.getWordsFromO(text);
		System.out.println(startsFromO);
	}
}