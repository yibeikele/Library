package com.southwind.controller;

import com.southwind.entity.*;
import com.southwind.service.AdminSevice;
import com.southwind.service.ReaderService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class AdminHandler {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private AdminSevice adminSevice;

    @RequestMapping("/getBorrows")
    @ResponseBody
    public BorrowVO getBorrows(HttpServletResponse response, Integer page, Integer limit){
        response.setContentType("text/json;charset=UTF-8");
        BorrowVO borrowVO = new BorrowVO();
        borrowVO.setCode(0);
        borrowVO.setMsg("");
        borrowVO.setData(readerService.admin_borrow_findAll(page,limit));
        borrowVO.setCount(readerService.Reader_borrow_all());
        return borrowVO;
    }

    @RequestMapping("/agreeBorrow/{id}")
    public ModelAndView agreeBorrow(HttpServletRequest request,@PathVariable("id") int borrowId){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession httpSession = request.getSession();
        BookAdmin bookAdmin = (BookAdmin)httpSession.getAttribute("object");
        int adminId = bookAdmin.getId();
        adminSevice.agreeBorrow(borrowId,adminId);
        modelAndView.setViewName("redirect:/borrow_manage.jsp");
        return modelAndView;
    }

    @RequestMapping("/disAgreeBorrow/{borrowId}/{readerId}")
    public ModelAndView disagreeBorrow(HttpServletRequest request,@PathVariable("borrowId") int borrowId,@PathVariable("readerId") int readerId){
            ModelAndView modelAndView = new ModelAndView();
            HttpSession httpSession = request.getSession();
            BookAdmin bookAdmin = (BookAdmin)httpSession.getAttribute("object");
            int adminId = bookAdmin.getId();
            adminSevice.disagreeBorrow(borrowId,adminId,readerId);
            modelAndView.setViewName("redirect:/borrow_manage.jsp");
            return modelAndView;
    }

    @RequestMapping("reader_findAll")
    @ResponseBody
    public ReaderVO reader_findAll(HttpServletResponse response, Integer page, Integer limit){
        response.setContentType("text/json:charset:UTF-8");
        ReaderVO readerVO = null;
        readerVO = adminSevice.reader_findAll(page,limit);
        return readerVO;
    }

    @RequestMapping("/returnBook")
    @ResponseBody
    public BorrowVO agreeReturn(HttpServletResponse response, Integer page, Integer limit){
        response.setContentType("text/json:charset:UTF-8");
        BorrowVO borrowVO = adminSevice.returnBook(page,limit);
        return borrowVO;
    }

    @RequestMapping("/addReader")
    public ModelAndView addReader(String username,String password,String name, String tel, String cardid, String gender ){
        Reader reader  = new Reader();
        reader.setUsername(username);
        reader.setPassword(password);
        reader.setCardid(cardid);
        reader.setName(name);
        reader.setTel(tel);
        reader.setGender(gender);
        ModelAndView  modelAndView = new ModelAndView();
        adminSevice.addReader(reader);
        modelAndView.setViewName("redirect:/reader_manage.jsp");
        return modelAndView;
    }

    @RequestMapping("/getBarData")
    @ResponseBody
    public BarData getBarData(HttpServletResponse response){
        response.setContentType("text/json:charset:UTF-8");
        return adminSevice.getBarData();
    }

    @RequestMapping("/getPieData")
    @ResponseBody
    public List<PieData> getPieData(HttpServletResponse response){
        response.setContentType("text/json:charset:UTF-8");
        return adminSevice.getPieData();
    }

    @RequestMapping("/exportBook")
    public void bookFindAll(HttpServletResponse response){
        HSSFWorkbook hssfWorkbook = adminSevice.getWorkbook();
        response.setContentType("application/x-msdownload");
        String fileName = null;
        try {
            fileName = URLEncoder.encode("图书信息.xls","UTF-8");
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            OutputStream outputStream = response.getOutputStream();
            hssfWorkbook.write(outputStream);
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
