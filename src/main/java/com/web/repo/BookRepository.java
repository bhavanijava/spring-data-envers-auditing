package com.web.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, RevisionRepository<Book, Integer, Integer> {
}
