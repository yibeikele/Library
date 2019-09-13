package com.southwind.service.impl;

import com.southwind.entity.*;
import com.southwind.repository.BookAdminRepository;
import com.southwind.repository.BookRepository;
import com.southwind.service.AdminSevice;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminSevice {

    @Autowired
    private BookAdminRepository bookAdminRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void agreeBorrow(int borrowId, int adminId) {
        bookAdminRepository.agreeBorrow(borrowId, adminId);
    }

    @Override
    public ReaderVO reader_findAll(int page, int limit){
        ReaderVO readerVO = new ReaderVO();
        readerVO.setCode(0);
        readerVO.setMsg("");
        readerVO.setCount(bookAdminRepository.reader_findCount());
        readerVO.setData(bookAdminRepository.reader_findAll((page-1)*limit,limit));
        return readerVO;
    }

    @Override
    public void disagreeBorrow(int borrowId,int adminId,int readerId){
        bookAdminRepository.disagreeBorrow(borrowId,adminId,readerId);
    }

    @Override
    public BorrowVO returnBook(int page, int limit) {
        List<Borrow> borrowList = null;
        borrowList = bookAdminRepository.returnBook((page-1)*limit,limit);
        for (Borrow borrow: borrowList) {
            borrow.setState("还书未审核");
        }
        BorrowVO borrowVO = new BorrowVO();
        borrowVO.setCode(0);
        borrowVO.setCount(bookAdminRepository.returnBookCount());
        borrowVO.setData(borrowList);
        borrowVO.setMsg("");
        return borrowVO;
    }

    @Override
    public void addReader(Reader reader) {
        bookAdminRepository.addReader(reader);
    }

    @Override
    public BarData getBarData() {
        BarData barData = new BarData();
        barData.setCount(bookAdminRepository.getCount());
        barData.setName(bookAdminRepository.getName());
        return barData;
    }

    @Override
    public List<PieData> getPieData() {
        return bookAdminRepository.getValue();
    }

    @Override
    public HSSFWorkbook getWorkbook() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("图书");
        List<Book> list = bookAdminRepository.bookFindAll();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("图书名称");
        cell = row.createCell(1);
        cell.setCellValue("作者");
        cell = row.createCell(2);
        cell.setCellValue("出版社");
        cell = row.createCell(3);
        cell.setCellValue("总页数");
        cell = row.createCell(4);
        cell.setCellValue("售价");
        cell = row.createCell(5);
        cell.setCellValue("图书分类");
        List<BookCase> bookCases = bookRepository.bookCaseFindAll();
        String name = null;
        for (Book book: list) {
            name = bookCases.get(book.getBookcaseid()-1).getName();
            book.setBookcasename(name);
        }
        for(int i = 0; i < list.size(); i++){
            Book book = list.get(i);
            row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(book.getName());
            cell = row.createCell(1);
            cell.setCellValue(book.getAuthor());
            cell = row.createCell(2);
            cell.setCellValue(book.getPublish());
            cell = row.createCell(3);
            cell.setCellValue(book.getPages());
            cell = row.createCell(4);
            cell.setCellValue(book.getPrice());
            cell = row.createCell(5);
            cell.setCellValue(book.getBookcasename());
        }
        return workbook;
    }
}
