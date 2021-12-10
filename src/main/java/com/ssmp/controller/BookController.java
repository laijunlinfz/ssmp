package com.ssmp.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.common.Result;
import com.ssmp.domain.Book;
import com.ssmp.dto.BookQuery;
import com.ssmp.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/book")
public class BookController {

//    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private IBookService bookService;

    @Autowired
    public void setBookService (IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("save")
    public Result<Boolean> saveBook(@RequestBody Book book) {
        boolean res = bookService.saveBook(book);
        return Result.condition(res);
    }

    @PostMapping("update")
    public Result<Boolean> updateBook(@RequestBody Book book) {
        boolean res = bookService.updateBook(book);
        return Result.condition(res);
    }

    @PostMapping("delete")
    public Result<Boolean> deleteBook(@RequestBody Book book) {
        Integer id = book.getId();
        boolean res = bookService.deleteBook(id);
        return Result.condition(res);
    }

    @SaCheckLogin
    @GetMapping("{id}")
    public Result<Book> getBookById(@PathVariable Integer id) {
        Book res = bookService.getBookById(id);
        return Result.data(res);
    }

//    使用继承自 mybatis plus 的 getById 。 Mybatis Plus NB !
    @GetMapping("test/{id}")
    public Result<Book> getBookByIdUseMP(@PathVariable Integer id) {
        Book res = bookService.getById(id);
        return Result.data(res);
    }

    @GetMapping("all")
    public Result<List<Book>> getAllBook() {
        return Result.data(bookService.getAllBook());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result<IPage<Book>> getBookPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        IPage<Book> res = bookService.getBookPage(currentPage, pageSize);
        return Result.data(res);
    }

    @PostMapping("search")
    public Result<IPage<Book>> getBookPage(@Validated @RequestBody BookQuery data) throws IOException {
//        if (true) throw new IOException();
        int currentPage = data.getCurrentPage();
        int pageSize = data.getPageSize();
        Book book = data.getBook();
        IPage<Book> res = bookService.getBookPage(currentPage, pageSize, book);
        return Result.data(res);
    }

    @GetMapping("/test")
    public String test() {
        log.error("err .......");
        return  "Hello Spring Boot";
    }

}
