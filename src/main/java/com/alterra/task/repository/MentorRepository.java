package com.alterra.task.repository;

import com.alterra.task.entity.Mentor;
import org.springframework.data.repository.CrudRepository;

public interface MentorRepository extends CrudRepository<Mentor, Integer> {
//    User findByUserName(String name);
}
