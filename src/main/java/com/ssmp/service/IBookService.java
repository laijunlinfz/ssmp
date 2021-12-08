package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.domain.Book;

import java.util.List;

// 基础的 cudr 都有了，NB 啊
public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(Integer id);

    Book getBookById(Integer id);

    List<Book> getAllBook();

    IPage<Book> getBookPage(int currentPage, int pageSize);

    IPage<Book> getBookPage(int currentPage, int pageSize, Book book);

}

