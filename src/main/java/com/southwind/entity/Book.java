package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    private int pages;
    private float price;
    private int bookcaseid;
    private int abled;
    private String bookcasename;

}
