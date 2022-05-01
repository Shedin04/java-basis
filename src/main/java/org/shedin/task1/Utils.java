package org.shedin.task1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Utils {
	public static Collection<String> getWordsFromO(String text) {
		List<String> words = splitTextIntoWord(text);
		Predicate<String> isStartFromO = word -> String.valueOf(word.charAt(0)).equalsIgnoreCase("O");
		return words.stream().filter(isStartFromO).collect(Collectors.toList());
	}

	private static List<String> splitTextIntoWord(String text) {
		return Arrays.stream(text.split("[^A-Za-z]")).filter(str -> str.length() > 0).collect(Collectors.toList());
	}

	public static String readFromFile(String fileName) {
		String PATH_TO_RESOURCES = "src/main/resources";
		try {
			return FileUtils.readFileToString(new File(PATH_TO_RESOURCES, fileName), StandardCharsets.UTF_8);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}