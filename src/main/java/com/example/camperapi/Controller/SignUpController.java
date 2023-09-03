package com.example.camperapi.Controller;

import com.example.camperapi.Service.SignUpService;
import com.example.camperapi.dto.SignUpDto;
import com.example.camperapi.dto.SignUpRequestDto;
import com.example.camperapi.entity.SignUp;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    private static final Logger log = LoggerFactory.getLogger(SignUpService.class);

    private final SignUpService signupService;
    private final ModelMapper mapper;

    @Autowired
    public SignUpController(SignUpService signupService, ModelMapper mapper) {
        this.signupService = signupService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SignUpDto> createSignup(@Valid @RequestBody SignUpRequestDto signupRequestDTO) {
        SignUp createdSignup = signupService.createSignup(signupRequestDTO);
        SignUpDto responseDTO = mapper.map(createdSignup, SignUpDto.class);
        return ResponseEntity.ok().body(responseDTO);
    }



    private SignUpDto convertSignupToDto(SignUp signup) {
        SignUpDto signUpDto = mapper.map(signup, SignUpDto.class);
        return signUpDto;

    }

    @GetMapping
    public ResponseEntity<List<SignUpDto>> getAllSignups() {
        List<SignUp> allSignups = signupService.getAllSignups();
        Type listType = new TypeToken<List<SignUpDto>>() {}.getType();
        List<SignUpDto> responseDTOs = mapper.map(allSignups, listType);
        return ResponseEntity.ok().body(responseDTOs);
    }

}


