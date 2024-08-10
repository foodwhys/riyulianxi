package cn.itcast.service;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookDao bookDao;

    //查询所有图书
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    //根据id查询一个图书
    public Book findById(Integer id){
        return bookDao.findById(id);
    }


    //根据id删除图书
    public void deleteById(Integer id){
        bookDao.deleteById(id);
    }

    //修改图书
    public void update(Book book){
        bookDao.update(book);
    }

    //添加图书
    public void add(Book user){
        bookDao.add(user);
    }

}
