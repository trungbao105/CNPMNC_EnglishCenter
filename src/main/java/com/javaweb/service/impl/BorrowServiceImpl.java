//package com.javaweb.service.impl;
//
//import com.javaweb.entity.BookEntity;
//import com.javaweb.entity.BorrowEntity;
//import com.javaweb.model.dto.BorrowDTO;
//import com.javaweb.repository.BookRepository;
//import com.javaweb.repository.BorrowRepository;
//import com.javaweb.service.BorrowService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class BorrowServiceImpl implements BorrowService {
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private BookRepository bookRepository;
//    @Autowired
//    private BorrowRepository borrowRepository;
//    @Override
//    public void addOrUpdateBorrow(BorrowDTO borrowDTO) {
//        BorrowEntity borrowEntity  = modelMapper.map(borrowDTO, BorrowEntity.class);
//        BookEntity bookEntity = bookRepository.findById(borrowDTO.getBookId()).get();
//        borrowEntity.setBookEntity(bookEntity);
//        LocalDate currentDate = LocalDate.now();
//        LocalDate returnLocalDate = currentDate.plusDays(10);
//        Date returnDate = Date.from(returnLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        borrowEntity.setReturnDate(returnDate);
//        borrowRepository.save(borrowEntity);
//    }
//
//
//}
