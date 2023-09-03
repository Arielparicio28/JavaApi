package com.example.camperapi.Repository;

import com.example.camperapi.entity.Activity;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
