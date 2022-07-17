package com.zhang.controller;

import com.sun.tracing.dtrace.ProviderAttributes;
import com.zhang.pojo.Books;
import com.zhang.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list=bookService.queryAllBooks();
        model.addAttribute("list",list);
        return "allBook";
    }
    //跳转到增加界面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加图书
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books=bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int did){
        bookService.deleteBookById(did);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook1")
    public String deleteBook1(@Param("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books book=bookService.queryBookByName(queryBookName);
        List<Books> list=new ArrayList<Books>();
        list.add(book);
        if(book==null){
            list=bookService.queryAllBooks();
            model.addAttribute("error","无匹配项");
        }
        model.addAttribute("list",list);
        return "allBook";
    }

}
