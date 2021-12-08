package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.BookDao;
import com.ssmp.domain.Book;
import com.ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    public boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    public boolean updateBook(Book book) {
        return bookDao.updateById(book) > 0;
    }

    public boolean deleteBook(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    public Book getBookById(Integer id) {
        return bookDao.selectById(id);
    }

    public List<Book> getAllBook() {
        List<Book> result = bookDao.selectList(null);
        return result;
    }

    public IPage<Book> getBookPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    public IPage<Book> getBookPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, lqw);
        return page;
    }

}
