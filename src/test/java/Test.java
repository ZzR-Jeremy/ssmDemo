import com.zhang.controller.BookController;

import com.zhang.service.BookServiceImpl;

import java.util.List;

public class Test
{
    public static void main(String[] args) {
        BookServiceImpl im=new BookServiceImpl();
        int i=im.deleteBookById(5);
        System.out.println(i);

    }

}
