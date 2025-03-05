package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.library.annotation.AutoFill;
import com.example.library.enumeration.OperationType;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.vo.BookVO;

@Mapper
public interface BookMapper {
        /**
         * C
         */
        @Insert("insert into book(book_name,counts,category_id,price,description,status) "
                        +
                        "values" +
                        "(#{book_name},#{counts},#{categoryId},#{price},#{description},#{status})")
        @AutoFill(value = OperationType.INSERT)
        void insert(BookVO newbook);

          // batch  .xml file
        int insertBookBatch(@Param("list") List<Book> books); 
          
        /**
         * D
         */
        @Delete("delete from book where book_id = #{book_id}")
        void deleteById(@Param("book_id") int book_id);

        /**
         * R
         */
        @Select("select * from book")
        List<Book> readAll();

        /**
         * Read by ID
         * 
         * @return
         */
        @Select("select * from book where book_id = #{book_id}")
        Book getBookById(int book_id);

        /**
         * U
         */
        // @Update("<script>" 脚本形式也ok，但加条件容易报错
        // + "UPDATE Book "
        // + "<set>"
        // + "<if test='book_name != null'> book_name = #{book_name}, </if>"

        // + "</set>"
        // + "WHERE book_id = #{book_id}"
        // + "</script>")
        @Update("UPDATE Book SET "
                        + "book_name = #{book_name}, "
                        + "counts = #{counts}, "
                        + "category_id = #{categoryId}, "//TODO: 这里需要处理 category_id 的赋值 新加一个表就要动这个？
                        + "price = #{price}, "
                        + "status = #{status}, "
                        + "`description` = #{description} " // `description`是 MySQL 的保留关键字，所以加上反引号：`description`
                        + "WHERE book_id = #{bookId}")
        void updateBookInfo(BookVO bookvo);
        // Update 借书 数量-1
        // @Update("update book set counts = counts - 1 where book_id = #{book_id}")
        // void borrowA(Book book2);

        // 借书 数量—1
        @Update("UPDATE book SET counts = counts - 1 WHERE book_id = #{book_id}")
        void decrementBookCount(int book_id);

}
