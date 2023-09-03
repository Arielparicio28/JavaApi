package com.example.camperapi.Service;

import com.example.camperapi.Repository.ActivityRepository;
import com.example.camperapi.Repository.CamperRepository;
import com.example.camperapi.Repository.SignUpRepository;
import com.example.camperapi.dto.SignUpRequestDto;
import com.example.camperapi.entity.Activity;
import com.example.camperapi.entity.Camper;
import com.example.camperapi.entity.SignUp;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpService {


    private static final Logger log = LoggerFactory.getLogger(SignUpService.class);


    private final SignUpRepository signupRepository;
    private final CamperRepository camperRepository;
    private final ActivityRepository activityRepository;

    @Autowired //inject
    public SignUpService(SignUpRepository signupRepository, CamperRepository camperRepository, ActivityRepository activityRepository) {
        this.signupRepository = signupRepository;
        this.camperRepository = camperRepository;
        this.activityRepository = activityRepository;
    }

    public SignUp createSignup(SignUpRequestDto signupRequestDTO) {
        Camper camper = camperRepository.findById(signupRequestDTO.getCamperId())
                .orElseThrow(() -> new EntityNotFoundException("Camper not found with id: " + signupRequestDTO.getCamperId()));

        Activity activity = activityRepository.findById(signupRequestDTO.getActivityId())
                .orElseThrow(() -> new EntityNotFoundException("Activity not found with id: " + signupRequestDTO.getActivityId()));

        SignUp signup = new SignUp(null, camper, activity, signupRequestDTO.getTime());

        return signupRepository.save(signup);
    }






    public List<SignUp> getAllSignups() {
        Iterable<SignUp> allSignupsIterable = signupRepository.findAll();
        List<SignUp> allSignups = new ArrayList<>();
        allSignupsIterable.forEach(allSignups::add);
        return allSignups;
    }
}
