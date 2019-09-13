package com.southwind.repository;

import com.southwind.entity.Book;
import com.southwind.entity.BookCase;

import java.util.List;

public interface BookRepository {
    public List<Book> findAll(int index, int limit);
    public int count();
    public List<BookCase> bookCaseFindAll();
    public void addBook(Book book);
    public void Borrow(int bookId, int readerId, String borrowTime, String returnTime, int state);
    public void bookDelete(int id);
    public Book bookFind(int id);
}
