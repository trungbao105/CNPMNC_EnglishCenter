//package com.javaweb.service.impl;
//
//import com.javaweb.entity.BookEntity;
//import com.javaweb.model.dto.BookDTO;
//import com.javaweb.model.request.BookSearchRequest;
//import com.javaweb.model.response.BookSearchResponse;
//import com.javaweb.model.response.BuildingSearchResponse;
//import com.javaweb.repository.BookRepository;
//import com.javaweb.service.BookService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class BookServiceImpl implements BookService {
//    @Autowired
//    private BookRepository bookRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Override
//    public List<BookSearchResponse> findAll(BookSearchRequest bookSearchRequest) {
//        List<BookEntity> book =bookRepository.findAll(bookSearchRequest);
//        List<BookSearchResponse> bookSearchResponses = new ArrayList<>();
//        for(BookEntity it : book ){
//            BookSearchResponse bookSearchResponse = modelMapper.map(it, BookSearchResponse.class); ;
//            bookSearchResponses.add(bookSearchResponse);
//        }
//        return bookSearchResponses;
//    }
//
//    @Override
//    public void addOrUpdateBook(BookDTO bookDTO) {
//        BookEntity bookEntity = modelMapper.map(bookDTO, BookEntity.class);
//        bookRepository.save(bookEntity);
//    }
//
//    @Override
//    public BookDTO findBookEntityById(Long id) {
//        BookEntity bookEntity=bookRepository.findById(id).get();
//        BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
//        return bookDTO;
//    }
//
//    @Override
//    public void deleteBook(List<Long> Id) {
//        List<BookEntity> book =bookRepository.findAllById(Id);
//        bookRepository.deleteAll(book);
//    }
//}
