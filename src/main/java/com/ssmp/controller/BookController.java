package com.ssmp.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.utils.R;
import com.ssmp.domain.Book;
import com.ssmp.dto.BookQuery;
import com.ssmp.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public R saveBook(@RequestBody Book book) {
        boolean result = bookService.saveBook(book);
        return new R(result ? 1 : 0);
    }

    @PostMapping("update")
    public R updateBook(@RequestBody Book book) {
        boolean result = bookService.updateBook(book);
        return new R(result ? 1 : 0);
    }

    @PostMapping("delete")
    public R deleteBook(@RequestBody Book book) {
        Integer id = book.getId();
        boolean result = bookService.deleteBook(id);
        return new R(result ? 1 : 0);
    }

    @SaCheckLogin
    @GetMapping("{id}")
    public R getBookById(@PathVariable Integer id) {
        Book res = bookService.getBookById(id);
        return new R(1, res);
    }

//    使用继承自 mybatis plus 的 getById 。 Mybatis Plus NB !
    @GetMapping("test/{id}")
    public R getBookByIdUseMP(@PathVariable Integer id) {
        Book res = bookService.getById(id);
        return new R(1, res);
    }

    @GetMapping("all")
    public R getAllBook() {
        return new R(1, bookService.getAllBook());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getBookPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        IPage<Book> result = bookService.getBookPage(currentPage, pageSize);
        return new R(1, result);
    }

    @PostMapping("search")
    public R getBookPage(@Validated @RequestBody BookQuery data) throws IOException {
//        if (true) throw new IOException();
        int currentPage = data.getCurrentPage();
        int pageSize = data.getPageSize();
        Book book = data.getBook();
        IPage<Book> result = bookService.getBookPage(currentPage, pageSize, book);
        return new R(1, result);
    }

    @GetMapping("/test")
    public String test() {
        log.error("err .......");
        return  "Hello Spring Boot";
    }

}
