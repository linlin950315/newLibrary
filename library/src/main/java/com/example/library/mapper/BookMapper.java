package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.library.pojo.entity.Book;

@Mapper
public interface BookMapper {
        /**
         * C
         */
        @Insert("insert into book(book_id,book_name,counts)"
                        +
                        "values" +
                        "(#{book_id},#{book_name},#{counts})")
        void insert(Book book);

        /**
         * D
         */
        @Delete("delete from book where book_id = #{book_id}")
        void delete(@Param("book_id") int book_id);

        /**
         * R
         */
        @Select("select * from book")
        List<Book> readAll();

        /**
         * U
         */
        @Update("<script>"
                        + "UPDATE Book "
                        + "<set>"
                        + "<if test='name != null'> name = #{name}, </if>"
                        + "</set>"
                        + "WHERE id = #{id}"
                        + "</script>")
        void update(Book book); // debug这行不走 但注掉，就启动不起来
}
