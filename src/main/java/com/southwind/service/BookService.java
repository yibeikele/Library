package com.southwind.service;

import com.southwind.entity.Book;
import com.southwind.entity.BookCase;
import com.southwind.entity.BookVO;

import java.util.List;


public interface BookService {
    public BookVO findAll(int page, int limit);
    public List<BookCase> bookCaseFindAll();
    public void addBook(Book book);
    public void Borrow(int bookId, int readerId, String borrowTime, String returnTime, int state);
    public void bookDelete(int id);
    public Book bookFind(int id);

}
