package com.southwind.controller;


import com.southwind.entity.BookAdmin;
import com.southwind.entity.BookVO;
import com.southwind.entity.Reader;
import com.southwind.service.AccountService;
import com.southwind.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountHandler {
    @Autowired
    private AccountService accountService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ModelAndView login(HttpServletRequest request, @Param("type") String type, @Param("username") String username, @Param("password") String password){
        ModelAndView modelAndView = new ModelAndView();
        Object object = accountService.save(type,username,password);
        request.getSession().setAttribute("object",object);
        if (object == null){
            modelAndView.setViewName("login");
        }else {
            switch (type){
                case "reader":
                    Reader reader = (Reader) object;
                    modelAndView.setViewName("index");
                    modelAndView.addObject("reader",reader);
                    break;
                case "bookadmin":
                    BookAdmin bookAdmin = (BookAdmin)object;
                    modelAndView.setViewName("main");
                    modelAndView.addObject("bookAdmin",bookAdmin);
                    break;
            }
        }
        return modelAndView;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public BookVO findAll(HttpServletResponse response, @Param("page") Integer page, @Param("limit") Integer limit){
        response.setContentType("text/json;charset=UTF-8");
        BookVO bookVO = bookService.findAll(page,limit);
        return bookVO ;
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
