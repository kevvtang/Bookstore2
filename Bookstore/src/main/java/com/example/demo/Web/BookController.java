package com.example.demo.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;

public class BookController {

    @Autowired
    public BookService bookService;
    
    @RequestMapping("/book")
    public String viewHomePage(Model model) {
        List<Book> books = bookService.listAll();
        model.addAttribute("books", books);
         
        return "productPage";
    }
    
	/*
	 * @RequestMapping("/new") public String showNewProductPage(Model model) { Book
	 * book = new Book(); model.addAttribute("book", book);
	 * 
	 * return "new_product"; }
	 */
}
