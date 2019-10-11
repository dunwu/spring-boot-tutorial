package io.github.dunwu.springboot;

public interface BookRepository {

	Book getByIsbn(String isbn);

}
