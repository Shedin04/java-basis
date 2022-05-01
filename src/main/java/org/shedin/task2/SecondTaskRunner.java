package org.shedin.task2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.shedin.task2.BooksHelper.getBooks;
import static org.shedin.task2.BooksHelper.printBooks;
import static org.shedin.task2.BooksHelper.printBooksName;
import static org.shedin.task2.BooksHelper.getTotalPrice;
import static org.shedin.task2.BooksHelper.getBooksWithSymbol;
import static org.shedin.task2.BooksHelper.getBookWithHighestPrice;
import static org.shedin.task2.BooksHelper.getNumberOfBooksWhichLengthIsInteger;
import static org.shedin.task2.BooksHelper.getBooksWithPriceLimit;
import static org.shedin.task2.BooksHelper.sortBooksByName;


public class SecondTaskRunner {

	public static void main(String[] args) {
		System.out.println("/-/-/ Sub task 1 /-/-/");
		subTask1();
		System.out.println("/-/-/ Sub task 2 /-/-/");
		subTask2();
	}
	private static void subTask1() {
		final int countOfBooks = 10;
		List<Book> bookList = getBooks(countOfBooks);
		System.out.println("All books:");
		printBooks(bookList);

		System.out.println("Title of books:");
		printBooksName(bookList);

		System.out.println("Total price of books: " + getTotalPrice(bookList));
		final String symbolToFindBooks = "A";

		System.out.printf("Any book with symbol \"%s\" - ", symbolToFindBooks);
		printBooks(getBooksWithSymbol(1, symbolToFindBooks, bookList));

		System.out.println("The book name with highest price: " + getBookWithHighestPrice(bookList));

		final long countOfLetter = 5;
		System.out.printf("Count of books that consist of %s letters: %s%n", countOfLetter,
						  getNumberOfBooksWhichLengthIsInteger(5, bookList));

		final BigDecimal priceLimit = BigDecimal.valueOf(30);
		System.out.printf("All books with a price less than '%s':%n", priceLimit);
		printBooks(getBooksWithPriceLimit(priceLimit, bookList));

		System.out.println("Sorted books by name in desc order: ");
		printBooks(sortBooksByName(bookList));
	}

	private static void subTask2() {
		Book book1 = new Book("myBook", BigDecimal.valueOf(5));
		Book book2 = new Book("myBook", BigDecimal.valueOf(5));
		Map<Book, String> mapWithBook = new HashMap<>();
		mapWithBook.put(book1, "some library name");
		String library = mapWithBook.get(book2);
		System.out.println("Hackerman: " + library);
	}
}