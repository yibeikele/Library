package com.southwind.repository;

import com.southwind.entity.Borrow;
import com.southwind.entity.Reader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository {
    public Reader save(String username, String password);
    public List<Borrow> reader_borrow_findAll(int readerId, int page, int limit);
    public int reader_borrow_count(int readerId);
    public int reader_borrow_all();
    public List<Borrow> admin_borrow_finaAll(int page, int limit);
    public List<Borrow> reader_findAll(int id);
}
