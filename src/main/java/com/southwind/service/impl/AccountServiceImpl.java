package com.southwind.service.impl;

import com.southwind.repository.BookAdminRepository;
import com.southwind.repository.ReaderRepository;
import com.southwind.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookAdminRepository bookAdminRepository;

    @Override
    public Object save(String type,String username, String password) {
        Object object = null;
        switch (type){
            case "reader":
                object = readerRepository.save(username,password);
                break;
            case "bookadmin":
                object = bookAdminRepository.login(username,password);
                break;
        }
        return object;
    }
}
