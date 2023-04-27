package com.web.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Book;
import com.web.repo.BookRepository;
import com.web.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    
    @Autowired
    private BookRepository repo;

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/{id}/{pages}")
    public String updateBook(@PathVariable int id, @PathVariable int pages) {
        bookService.updateBook(id, pages);
        return "book updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "book deleted";
    }

    @GetMapping("/getInfo/{id}")
    @ResponseBody
    public ResponseEntity<Revision<Integer, Book>> last(@PathVariable int id) {
        Optional<Revision<Integer, Book>> revision = repo.findLastChangeRevision(id);
        if (revision.isPresent()) {
            System.out.println("Last revised book name: " + revision.get().getEntity().getName());
            return ResponseEntity.ok(revision.get());
        } else {
            System.out.println("No revisions found for book id: " + id);
            return ResponseEntity.notFound().build();
        }
    }



    

}
