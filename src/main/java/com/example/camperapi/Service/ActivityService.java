package com.example.camperapi.Service;

import com.example.camperapi.Repository.ActivityRepository;
import com.example.camperapi.Repository.SignUpRepository;
import com.example.camperapi.dto.ActivityDto;
import com.example.camperapi.entity.Activity;
import com.example.camperapi.entity.SignUp;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final SignUpRepository signupRepository;
    private ModelMapper mapper;
    @Autowired
    public ActivityService(ActivityRepository activityRepository, SignUpRepository signupRepository,ModelMapper mapper) {
        this.activityRepository = activityRepository;
        this.signupRepository = signupRepository;
        this.mapper = mapper;
    }


    public List<Activity> getAllActivities() {
        Iterable<Activity> activitiesIterable = activityRepository.findAll();
        List<Activity> activities = new ArrayList<>();

        activitiesIterable.forEach(activities::add);

        if (activities.isEmpty()) {
            throw new EntityNotFoundException("No activities found.");
        }

        return activities;
    }

    public Activity getActivityById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity with ID " + id + " not found."));
    }

    public Activity createActivity(ActivityDto activityDto) {
        Activity newActivity = new Activity();
        newActivity.setName(activityDto.getName());
        newActivity.setDifficulty(activityDto.getDifficulty());
        return activityRepository.save(newActivity);

    }


    public Activity updateActivity(Long id, @Valid ActivityDto activityDto) {
        Activity existingActivity = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found with id: " + id));

        if (activityDto.getName() != null && !activityDto.getName().isEmpty()) {
            existingActivity.setName(activityDto.getName());
        }

        if (activityDto.getDifficulty() != null) {
            existingActivity.setDifficulty(activityDto.getDifficulty());
        }

        return activityRepository.save(existingActivity);
    }


    public boolean deleteActivity(Long id) {
        Optional<Activity> activityOptional = activityRepository.findById(id);

        if (activityOptional.isPresent()) {
            Activity activity = activityOptional.get();

            // Delete associated signups
            List<SignUp> signups = signupRepository.findByActivity(activity);
            signupRepository.deleteAll(signups);

            // Delete the activity
            activityRepository.delete(activity);
            return true;
        }

        throw new EntityNotFoundException("Activity not found with id: " + id);
    }

}
