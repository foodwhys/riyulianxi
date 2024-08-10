package cn.itcast.dao;

import cn.itcast.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

    //查询所有图书
    @Select("select * from book")
    public List<Book> findAll();

    //根据id查询一个图书
    @Select("select * from book where id=#{id}")
    public Book findById(Integer id);


    //根据id删除图书
    @Delete("delete from book where id=#{id}")
    public void deleteById(Integer id);

    //修改图书
    @Update("update book set name=#{name},description=#{description},author=#{author},price=#{price},stock=#{stock} where id=#{id} ")
    public void update(Book book);

    //添加图书
    @Insert("insert into book(name,description,author,price,stock) values(#{name},#{description},#{author},#{price},#{stock})")
    public void add(Book user);


}
