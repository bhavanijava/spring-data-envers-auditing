package com.web.service;

import java.util.Optional;

import org.springframework.data.history.Revision;

import com.web.model.Book;

public interface BookService {
	   public Book saveBook(Book book);
	   public void updateBook(int id, int pages);
	   public void deleteBook(int id);
	 //  public Optional<Revision<Integer, Book>> findLastChangeRevision(int id);
}
