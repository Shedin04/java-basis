package org.shedin.task2;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BooksHelper {

	public static List<Book> getBooks(int count) {
		return Stream.generate(BooksHelper::getNewBook).limit(count).collect(Collectors.toList());
	}

	private static Book getNewBook() {
		String name = RandomStringUtils.randomAlphabetic(3, 10);
		BigDecimal price = BigDecimal.valueOf(RandomUtils.nextFloat(1, 99)).setScale(2, RoundingMode.HALF_EVEN);
		return new Book(name, price);
	}

	public static void printBooks(List<Book> books) {
		books.forEach(System.out::println);
	}

	private static List<String> getBooksName(List<Book> books) {
		return books.stream().map(Book::getName).collect(Collectors.toList());
	}

	public static void printBooksName(List<Book> books) {
		getBooksName(books).forEach(System.out::println);
	}

	public static BigDecimal getTotalPrice(List<Book> bookList) {
		return bookList.stream().map(Book::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public static List<Book> getBooksWithSymbol(int countOfBooks, String symbol, List<Book> bookList) {
		Predicate<Book> isBookContainsSymbol = book -> book.getName().toUpperCase(Locale.ROOT)
				.contains(symbol.toUpperCase(Locale.ROOT));
		return bookList.stream().filter(isBookContainsSymbol).limit(countOfBooks).collect(Collectors.toList());
	}

	public static String getBookWithHighestPrice(List<Book> bookList) {
		return bookList.stream().max(Comparator.comparing(Book::getPrice)).orElseThrow(NoSuchElementException::new).getName();
	}

	public static long getNumberOfBooksWhichLengthIsInteger(int countOfLetters, List<Book> bookList) {
		return bookList.stream().map(Book::getName)
				.collect(Collectors.toMap(Function.identity(), String::length))
				.entrySet().stream().filter(entry -> entry.getValue().equals(countOfLetters)).count();
	}

	public static List<Book> getBooksWithPriceLimit(BigDecimal priceLimit, List<Book> bookList) {
		Predicate<Book> isPriceLower = book -> book.getPrice().compareTo(priceLimit) < 0;
		return bookList.stream().filter(isPriceLower).collect(Collectors.toList());
	}

	public static List<Book> sortBooksByName(List<Book> bookList) {
		return bookList.stream()
				.sorted(Comparator.comparing(Book::getName, String.CASE_INSENSITIVE_ORDER).thenComparing(Book::getPrice)
								.reversed())
				.collect(Collectors.toList());
	}
}