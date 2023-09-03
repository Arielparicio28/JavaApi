package com.example.camperapi.Controller;

import com.example.camperapi.Service.ActivityService;
import com.example.camperapi.dto.ActivityDto;
import com.example.camperapi.entity.Activity;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ActivityController {

    private final ActivityService activityService;
    private final ModelMapper mapper;

    @Autowired
    public ActivityController(ActivityService activityService,ModelMapper mapper) {
        this.activityService = activityService;
        this.mapper = mapper;
    }

    @GetMapping("/activities")
    public ResponseEntity<List<ActivityDto>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        List<ActivityDto> activityDTOs = activities.stream()
                .map(activity -> mapper.map(activity, ActivityDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(activityDTOs);
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.getActivityById(id);
        return ResponseEntity.ok(mapper.map(activity, ActivityDto.class));
    }

    @PostMapping("/activity/post")
    public ResponseEntity<ActivityDto> createActivity(@Valid @RequestBody ActivityDto activityDTO) {
        Activity createdActivity = activityService.createActivity(activityDTO);
        return ResponseEntity.ok(mapper.map(createdActivity, ActivityDto.class));
    }

    @PutMapping("/activity/{id}")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Long id, @RequestBody @Valid ActivityDto activityDTO) {
        Activity updatedActivity = activityService.updateActivity(id, activityDTO);
        return ResponseEntity.ok(mapper.map(updatedActivity, ActivityDto.class));
    }

    @DeleteMapping("/activity/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        boolean deleted = activityService.deleteActivity(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ActivityDto convertToDto(Activity activity) {
        ActivityDto activityDto = mapper.map(activity, ActivityDto.class);
        return activityDto;
    }
}

