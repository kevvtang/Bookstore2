package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepository;
 
@Service
@Transactional
public class BookService {
 
    @Autowired
    private BookRepository bookRepository;
     
    public List<Book> listAll() {
        return bookRepository.findAll();
    }
     
    public void save(Book book) {
    	bookRepository.save(book);
    }
     
    public Book get(int id) {
        return bookRepository.findById(id).get();
    }
     
    public void delete(int id) {
    	bookRepository.deleteById(id);
    }
}