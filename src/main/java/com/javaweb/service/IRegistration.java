package com.javaweb.service;

import com.javaweb.model.dto.RegistrationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRegistration {
    List<RegistrationDTO> getAllRegistration();
    ResponseEntity<?> Registration(RegistrationDTO registrationDTO);

}
