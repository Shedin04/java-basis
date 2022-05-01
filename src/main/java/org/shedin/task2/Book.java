package org.shedin.task2;

import java.math.BigDecimal;
import java.util.Objects;


public class Book {
	private String name;
	private BigDecimal price;

	public Book(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name: " + name + ", price: " + price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return Objects.equals(name, book.name) && Objects.equals(price, book.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
}