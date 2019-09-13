package com.southwind.service;

import com.southwind.entity.Borrow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface ReaderService {
    public List<Borrow> reader_borrow_findAll(int readerId, int page, int limit);
    public int reader_borrow_count(int readerId);
    public int Reader_borrow_all();
    public List<Borrow> admin_borrow_findAll(int page, int limit);
    public HSSFWorkbook getWorkbook(int id);
}
