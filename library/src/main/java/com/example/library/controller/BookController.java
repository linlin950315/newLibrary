package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.BookVO;
import com.example.library.service.BookService;
import com.example.library.util.Result;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/book")
@Api(tags = "--------------BOOK--------------")
public class BookController {

    @Autowired
    private BookService bookService;


    /*
     * C //TODO 对category扩展，category表；每个cayegory_id对应duoge book_id，一个string
     */
    @PostMapping("/insert")
    public int insert(@RequestBody BookDTO bookDTO) { // 注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
        System.out.println("@RequestBodybookDTO: " + bookDTO);
        BookVO book1 = bookService.insert(bookDTO);
        return book1.getBookId();
    }

    @PostMapping("/insertBatch")//TODO 加category
    public Result<Integer> insertBookBatch(@RequestBody List<BookDTO> bookDTO) {
        int rows = bookService.insertBookBatch(bookDTO);
        return Result.success(rows);
    }

    /*
     * D
     */
    // 根据book_id删除书籍
    @DeleteMapping("/{book_id}")
    public void deleteById(@PathVariable int book_id) {
        // 调用bookService的deleteById方法，根据book_id删除书籍
        bookService.deleteById(book_id);
    }

    /*
     * Read ALL
     */
    // @GetMapping()
    // public List<Book> readAll() {
    //     return bookService.readAll();
    // }
    @GetMapping() //http://localhost:8080/admin/book?page=0&size=5
    public Page<Book> getBooks(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return bookService.readAll(page, size);
    }

    @GetMapping("/sortBy")//http://localhost:8080/admin/book/sortBy?page=0&size=10&sortBy=bookName&descOrAsc=asc ,http://localhost:8080/admin/book/sortBy?page=0&size=10&sortBy=bookId&descOrAsc=asc
    public Page<Book> readAllsortBy(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "bookName") String sortBy,
            @RequestParam() String descOrAsc) {//把(defaultValue = "asc")去掉检查 
        System.out.println("sortBy Start------: " + "page" + page + "//size" + size + "//sortBy" + sortBy + "//sort" + descOrAsc);
        return bookService.readAllsortBy(page, size, sortBy, descOrAsc);
    }

    /*
     * Read by Id
     */
    // @GetMapping("/{book_id}") //TODO 查不到category的json
    // public Result<Book> getBookById(@PathVariable int book_id) {
    //     Book bookInfo = bookService.getBookById(book_id);
    //     return Result.success(bookInfo);
    // }
    @GetMapping("/{book_id}")
    public Result<Book> getBookByIdJPA(@PathVariable int book_id) {
        Book bookInfo = bookService.findByBookId(book_id);
        return Result.success(bookInfo);
    }

    //search according to input (name)  http://localhost:8080/admin/book/search?keyword=a&page=0&size=10&sortBy=bookName&descOrAsc=DESC&categoryId=88
    // 根据bookname categoryId搜索书籍
    @GetMapping("/search")
    public Page<Book> searchBooks(@RequestParam String keyword,@RequestParam() int page,
    @RequestParam() int size, @RequestParam() String sortBy,
    @RequestParam() String descOrAsc,@RequestParam(required = false) Long categoryId) {
        System.out.println("----------Controller:----- ");
        // 调用bookService的findByBookName方法，根据关键词搜索书籍
        return bookService.findByBookNamAndCategoryId(keyword,page,size,sortBy,descOrAsc,categoryId);
    }

     
    // load and search 根据categoryId搜索书籍 http://localhost:8080/admin/book/search?keyword=a&page=0&size=10&sortBy=bookName&descOrAsc=DESC&categoryId=88
    // @GetMapping("/searchFromCategoryIdOrName")
    // public Page<Book> findAllByCategoryIdContaining(@RequestParam String keyword,@RequestParam() int page,
    // @RequestParam() int size, @RequestParam() String sortBy,
    // @RequestParam() String descOrAsc,@RequestParam() Long categoryId) {
    //     // 调用bookService的findByBookName方法，根据关键词搜索书籍
    //     return bookService.findAllByCategoryIdContaining(keyword,page,size,sortBy,descOrAsc,categoryId);
    // }

    /*
     * Update
     */
    @PutMapping()
    public void updateBookInfo(@RequestBody BookDTO bookDTO) {
        System.out.println("----------@RequestBodybookDTO:----- " + bookDTO);
        bookService.updateBookInfo(bookDTO);
    }

    // /*
    // * Update 借书 数量-1
    // */
    // @PutMapping("/{book_id}")
    // public void updateBook(@RequestBody Book book) {
    // bookService.borrowABook(book);
    // }
    // /**
    // * 还书 数量+1
    // */
    // // @PutMapping()
    // public void updateBookReturn(@RequestBody Book book) {
    // bookService.returnABook(book);
    // }
    /**
     * 批量借书
     */

    /*
     * TEST
     */
    @PostMapping("/Post/{id}")
    public String test1(@PathVariable int id, @RequestBody Student student) {
        return "http://localhost:8080/testPost/123? body-row-json//" + student;
    }

    @PostMapping("/testPost/{id}")
    public String test00(@PathVariable int id, @RequestBody Student student) {
        return "http://localhost:8080/testPost/123? body-row-json//" + student;
    }

    @GetMapping("/testGET/{id}/{ids}")
    public String test2(@PathVariable() int id, @PathVariable int ids,
            @RequestParam(required = false) String name) {
        return "http://localhost:8080/testGET/111/222?" + ";name=" + name + ";ids=" + ids + ";id=" + id;
    }

    @PutMapping("/testput/{id}")
    public String test3(@PathVariable int id, @RequestParam String name) {
        return "http://localhost:8080/testput/123?name=aaa" + name + id;
    }

    // if@RequestBody "error": "Bad Request"
    @PutMapping("/RequestBody/{id}")
    public String test4(@PathVariable int id, @RequestBody String name) {
        return "http://localhost:8080/RequestBody/123?name=aaa" + id + name;
    }

    // "error": "Bad Request"
    // @PutMapping("/testput/{id2}")
    // public String test3(@PathVariable int id2) {
    // return "http://localhost:8080/testput/123?" + id2;
    // }
    // "error": "Bad Request"
    // @PutMapping("/testput")
    // public String test3(@RequestParam String name) {
    // return "http://localhost:8080/testput/name=aaa?" + name;
    // }
    @DeleteMapping("/testdelete")
    public String testdelete() {
        return "@DeleteMapping(\"/testdelete\")";
    }

}
