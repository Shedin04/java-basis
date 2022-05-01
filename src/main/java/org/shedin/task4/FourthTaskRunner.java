package org.shedin.task4;

public class FourthTaskRunner {

	interface StringFunction {
		String run(String str);
	}

	interface ThreeFunction<T, U, V, R> {
		R run(T t, U u, V v);
	}

	public static void main(String[] args) {
		StringFunction exclaim = (s) -> s + "!";
		StringFunction ask = (s) -> s + "?";
		printFormatted("Hello", exclaim);
		printFormatted("Hello", ask);

		System.out.println("\nAnother variant:");
		ThreeFunction<String, String, String, String> askAndExclaim = (str, format1, format2) -> str + format1 + str + format2;
		System.out.println(askAndExclaim.run("Hello", "!", "?"));
	}

	public static void printFormatted(String str, StringFunction format) {
		String result = format.run(str);
		System.out.print(result);
	}
}