package com.ssmp.dto;

import com.ssmp.domain.Book;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class BookQuery {
    @Min(value = 1, message = "页码至少为1")
    public int currentPage;
    @Min(value = 1, message = "每页条数至少为1")
    @Max(value = 100, message = "每页条数至多为100")
    public int pageSize;
    public Book book;
}
