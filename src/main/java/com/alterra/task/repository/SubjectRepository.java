package com.alterra.task.repository;

import com.alterra.task.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository <Subject, Integer> {
}
