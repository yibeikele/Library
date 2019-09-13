package com.southwind.service;

import com.southwind.entity.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

public interface AdminSevice {
    public void agreeBorrow(int borrowId, int adminId);
    public ReaderVO reader_findAll(int page, int limit);
    public void disagreeBorrow(int borrowId, int adminId, int readerId);
    public BorrowVO returnBook(int page, int limit);
    public void addReader(Reader reader);
    public BarData getBarData();
    public List<PieData> getPieData();
    public HSSFWorkbook getWorkbook();
}
