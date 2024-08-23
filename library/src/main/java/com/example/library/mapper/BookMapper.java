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

@Mapper
public interface BookMapper {
        /**
         * C
         */
        @Insert("insert into book(book_id,book_name,counts,createTime,updateTime)"
                        +
                        "values" +
                        "(#{book_id},#{book_name},#{counts},#{createTime},#{updateTime})")
        @AutoFill(value = OperationType.INSERT)
        void insert(Book book);

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
        Book checkLendListById(int book_id);

        /**
         * U
         */
        @Update("<script>"
                        + "UPDATE Book "
                        + "<set>"
                        + "<if test='book_name != null'> book_name = #{book_name}, </if>"
                        + "</set>"
                        + "WHERE book_id = #{book_id}"
                        + "</script>")
        void updateBookInfo(Book book); // debug这行不走 但注掉，就启动不起来

        // Update 借书 数量-1
        // @Update("update book set counts = counts - 1 where book_id = #{book_id}")
        // void borrowA(Book book2);

        // 借书 数量—1
        @Update("UPDATE book SET counts = counts - 1 WHERE book_id = #{book_id}")
        void decrementBookCount(int book_id);

}
