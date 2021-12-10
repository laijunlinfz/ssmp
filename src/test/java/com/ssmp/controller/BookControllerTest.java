package com.ssmp.controller;

import com.ssmp.common.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookControllerTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testGetById() {
        Result result = bookController.getBookById(1);
        System.out.println("------------------- start");
        System.out.println(result);
        System.out.println("------------------- end");
    }
}
