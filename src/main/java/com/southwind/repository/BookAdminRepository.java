package com.southwind.repository;

import com.southwind.entity.*;

import java.util.List;

public interface BookAdminRepository {
    public BookAdmin login(String username, String password);
    public void agreeBorrow(int borrowId, int adminId);
    public List<Reader> reader_findAll(int page, int limit);
    public int reader_findCount();
    public void disagreeBorrow(int borrowId, int adminId, int readerId);
    public List<Borrow> returnBook(int page, int limit);
    public int returnBookCount();
    public void addReader(Reader reader);
    public List<String> getName();
    public List<Integer> getCount();
    public List<PieData> getValue();
    public List<Book> bookFindAll();
}
