package cn.itcast.controller;

import cn.itcast.domain.Book;
import cn.itcast.domain.ResultInfo;
import cn.itcast.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //查询所有图书
    @RequestMapping(path = "/findAllBook",method = RequestMethod.GET)
    public ResultInfo findAllBook(){
        List<Book> books = bookService.findAll();
        return new ResultInfo(true,books,"查询成功");
    }


    //根据id查询一个图书
    @RequestMapping(path = "/findBookById",method = RequestMethod.GET)
    public ResultInfo findBookById(Integer id){
        Book book = bookService.findById(id);
        return new ResultInfo(true,book,"查询成功");
    }

    //修改图书
    @RequestMapping(path = "/updateBook",method = RequestMethod.POST)
    public ResultInfo updateBook(Book book){
        bookService.update(book);
        return new ResultInfo(true,null,"修改成功");
    }

    //添加图书
    @RequestMapping(path = "/addBook",method = RequestMethod.POST)
    public ResultInfo addBook(Book book){
        bookService.add(book);
        return new ResultInfo(true,null,"添加成功");
    }

    //删除图书
    @RequestMapping(path = "/deleteBookById",method = RequestMethod.GET)
    public ResultInfo deleteBookById(Integer id){
        bookService.deleteById(id);
        return new ResultInfo(true,null,"删除成功");
    }
}
