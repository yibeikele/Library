package com.southwind.controller;

import com.southwind.entity.Book;
import com.southwind.entity.BookCase;
import com.southwind.entity.Reader;
import com.southwind.service.BookService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;


@Controller
@RequestMapping
public class BookHandler {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findBookCase")
    public ModelAndView findBookCase(){
        ModelAndView modelAndView = new ModelAndView();
        List<BookCase> bookCase = bookService.bookCaseFindAll();
        modelAndView.setViewName("book_add");
        modelAndView.addObject("list",bookCase);
        return modelAndView;
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook(@Param("name") String name, @Param("author") String author,@Param("publish") String publish,@Param("pages") int pages, @Param("price") float price,@Param("bookCaseId") int bookCaseId){
        ModelAndView modelAndView = new ModelAndView();
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPublish(publish);
        book.setBookcaseid(bookCaseId);
        book.setPages(pages);
        book.setPrice(price);
        bookService.addBook(book);
        modelAndView.setViewName("book_manage");
        return modelAndView;
    }

    @RequestMapping("/bookDelete/{id}")
    public ModelAndView bookDelete(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        bookService.bookDelete(id);
        modelAndView.setViewName("redirect:/book_manage.jsp");
        return modelAndView;
    }

    @RequestMapping("/bookFind/{id}")
    public ModelAndView bookUpdate(@PathVariable("id") int bookId){
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.bookFind(bookId);
        List<BookCase> bookCases = bookService.bookCaseFindAll();
        modelAndView.addObject("list",bookCases);
        modelAndView.addObject("book",book);
        modelAndView.setViewName("book_edit");
        return modelAndView;
    }

 }
