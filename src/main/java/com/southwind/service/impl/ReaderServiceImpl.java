package com.southwind.service.impl;


import com.southwind.entity.Borrow;
import com.southwind.repository.ReaderRepository;
import com.southwind.service.ReaderService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Borrow> reader_borrow_findAll(int readerId, int page, int limit) {
        List<Borrow> borrowList = null;
        borrowList =  readerRepository.reader_borrow_findAll(readerId,(page-1)*limit,limit);
        for (Borrow borrow: borrowList) {
            String str = borrow.getState();
            switch (str){
                case "0":
                    borrow.setState("未审核");
                    break;
                case "1":
                    borrow.setState("审核通过");
                    break;
                case "2":
                    borrow.setState("审核未通过");
                    break;
                case "3":
                    borrow.setState("已归还");
                    break;
            }
        }
        return borrowList;
    }

    @Override
    public int reader_borrow_count(int readerId) {
        return readerRepository.reader_borrow_count(readerId);
    }

    @Override
    public int Reader_borrow_all() {
        return readerRepository.reader_borrow_all();
    }

    @Override
    public List<Borrow> admin_borrow_findAll(int page, int limit) {
        List<Borrow> borrowList = null;
        borrowList = readerRepository.admin_borrow_finaAll((page-1)*limit,limit);
        for (Borrow borrow: borrowList) {
            borrow.setState("借书未审核");
        }
        return borrowList;
    }

    @Override
    public HSSFWorkbook getWorkbook(int id) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        Sheet sheet = hssfWorkbook.createSheet("借书记录");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("图书名称");
        cell = row.createCell(1);
        cell.setCellValue("读者名称");
        cell = row.createCell(2);
        cell.setCellValue("借书时间");
        cell = row.createCell(3);
        cell.setCellValue("还书时间");
        cell = row.createCell(4);
        cell.setCellValue("状态");
        List<Borrow> list = readerRepository.reader_findAll(id);
        for(int i = 0; i < list.size(); i++){
            Borrow borrow = list.get(i);
            row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(borrow.getBookName());
            cell = row.createCell(1);
            cell.setCellValue(borrow.getReaderName());
            cell = row.createCell(2);
            cell.setCellValue(borrow.getBorrowTime());
            cell = row.createCell(3);
            cell.setCellValue(borrow.getReturnTime());
            cell = row.createCell(4);
            String state = borrow.getState();
            switch (state){
                case "0":
                    borrow.setState("未审核");
                    break;
                case "1":
                    borrow.setState("审核通过");
                    break;
                case "2":
                    borrow.setState("审核未通过");
                    break;
                case "3":
                    borrow.setState("已归还");
                    break;
            }
            cell.setCellValue(borrow.getState());
        }
        return hssfWorkbook;
    }
}
