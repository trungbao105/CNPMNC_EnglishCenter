//package com.javaweb.api.admin;
//
//import com.javaweb.model.dto.BookDTO;
//import com.javaweb.model.dto.BorrowDTO;
//import com.javaweb.model.dto.BuildingDTO;
//import com.javaweb.service.BookService;
//import com.javaweb.service.BorrowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController(value = "customerAPIOfAdmin")
//@RequestMapping("/api/book")
//public class BookAPI {
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private BorrowService borrowService;
//    @PostMapping
//    public BookDTO addOrUpdateBook(@RequestBody BookDTO bookDTO){
//        bookService.addOrUpdateBook(bookDTO);
//        return bookDTO;
//    }
//    @DeleteMapping("/{ids}")
//    public void deleteBook(@PathVariable List<Long> ids){
//        bookService.deleteBook(ids);
//    }
//    @PostMapping("/borrow")
//    public void addOrUpdateBorrow(@RequestBody BorrowDTO borrowDTO){
//        borrowService.addOrUpdateBorrow(borrowDTO);
//    }
//}
