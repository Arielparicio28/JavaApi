package com.example.camperapi.Repository;

import com.example.camperapi.entity.Activity;
import com.example.camperapi.entity.SignUp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignUpRepository extends CrudRepository<SignUp, Long> {
    List<SignUp> findByActivity(Activity activity);
}
