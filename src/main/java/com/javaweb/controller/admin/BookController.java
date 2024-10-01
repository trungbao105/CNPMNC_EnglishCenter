//package com.javaweb.controller.admin;
//
//
//
//import com.javaweb.repository.BorrowRepository;
//import com.javaweb.service.BookService;
//import com.javaweb.service.BorrowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller(value="bookControllerOfAdmin")
//public class BookController {
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private BorrowRepository borrowRepository;
//    @RequestMapping(value = "/admin/book-list", method = RequestMethod.GET)
//    public ModelAndView bookList(@ModelAttribute BookSearchRequest bookSearchRequest, HttpServletRequest request){
//        ModelAndView mav = new ModelAndView("admin/Book/list");
//        mav.addObject("modelSearchRequest", bookSearchRequest);
//        mav.addObject("books",bookService.findAll(bookSearchRequest));
//        BookSearchResponse bookSearchResponse = new BookSearchResponse();
//        List<BookSearchResponse> model = bookService.findAll(bookSearchRequest);
//        return mav;
//    }
//    @RequestMapping(value = "/admin/book-edit", method = RequestMethod.GET)
//    public ModelAndView bookEdit(@ModelAttribute("bookEdit") BookDTO bookDTO, HttpServletRequest request){
//        ModelAndView mav = new ModelAndView("admin/Book/edit");
//        return mav;
//    }
//    @RequestMapping(value = "/admin/book-edit-{id}", method = RequestMethod.GET)
//    public ModelAndView bookEdit(@PathVariable("id") Long Id, HttpServletRequest request){
//        ModelAndView mav = new ModelAndView("admin/Book/edit");
//        BookDTO bookDTO = bookService.findBookEntityById(Id);
//        mav.addObject("bookEdit",bookDTO);
//        mav.addObject("borrowBook",borrowRepository.findBookEntityById(Id));
//        return mav;
//    }
//
//
//}
