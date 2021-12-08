package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBookDao extends BaseMapper<Book> {
}

// 旧写法, 注意是 class 而非 interface
//public class BookDao {
//    @Select("select * from book where id = #{id}")
//    Book getBookById(Integer id);
//}
