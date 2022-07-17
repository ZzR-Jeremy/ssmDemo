package com.zhang.dao;

import com.zhang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books books);
    int deleteBookById(@Param("bookID") int id);
    int updateBook(Books books);
    Books queryBookById(@Param("bookId") int id);
    List<Books> queryAllBooks();
    Books queryBookByName(@Param("queryBookName") String queryBookName);

}
