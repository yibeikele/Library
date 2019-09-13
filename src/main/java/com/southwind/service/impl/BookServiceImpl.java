package com.southwind.service.impl;

import com.southwind.entity.Book;
import com.southwind.entity.BookCase;
import com.southwind.entity.BookVO;
import com.southwind.repository.BookRepository;
import com.southwind.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookVO findAll(int page, int limit) {
        BookVO bookVO = new BookVO();
        List<Book> bookList = bookRepository.findAll((page-1)*limit,limit);
        List<BookCase> bookCases = bookRepository.bookCaseFindAll();
        String name = null;
        for (Book book: bookList){
            name = bookCases.get(book.getBookcaseid()-1).getName();
            book.setBookcasename(name);
        }
        bookVO.setData(bookList);
        bookVO.setCount(bookRepository.count());
        bookVO.setMsg("");
        bookVO.setCode(0);
        return bookVO;
    }

    @Override
    public List<BookCase> bookCaseFindAll() {
        return bookRepository.bookCaseFindAll();
    }

    @Override
    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    @Override
    public void Borrow(int bookId, int readerId, String borrowTime, String returnTime, int state) {
            bookRepository.Borrow(bookId,readerId,borrowTime,returnTime,state);
    }

    @Override
    public void bookDelete(int id) {
        bookRepository.bookDelete(id);
    }

    @Override
    public Book bookFind(int id){
        return bookRepository.bookFind(id);
    }
}
