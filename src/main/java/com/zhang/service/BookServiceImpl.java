package com.zhang.service;

import com.zhang.dao.BookMapper;
import com.zhang.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookmapper;

    public BookMapper getBookmapper() {
        return bookmapper;
    }

    public void setBookMapper(BookMapper bookmapper) {
        this.bookmapper = bookmapper;
    }

    public int addBook(Books books) {
        return bookmapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookmapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookmapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookmapper.queryBookById(id);
    }

    public List<Books> queryAllBooks() {
        return bookmapper.queryAllBooks();
    }

    public Books queryBookByName(String queryBookName){
        return bookmapper.queryBookByName(queryBookName);
    }
}
