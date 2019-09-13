package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    private int id;
    private String username;
    private String password;
    private String name;
    private String tel;
    private String cardid;
    private String gender;

}