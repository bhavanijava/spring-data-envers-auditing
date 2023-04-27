package com.web.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import com.web.model.Book;
import com.web.repo.BookRepository;

@Service
public  class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void updateBook(int id, int pages) {
        Book book = repository.findById(id).get();
        book.setPages(pages);
        repository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        repository.deleteById(id);
    }

//    @Override
//    public Optional<Revision<Integer, Book>> findLastChangeRevision(int id) {
//        return repository.findLastChangeRevision(id);
//    }


}
