package com.alterra.task.controller;

import com.alterra.task.entity.Subject;
import com.alterra.task.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SubjectController {
    @Autowired(required = false)
    SubjectService subjectService;

    @PostMapping("/subjects/{userId}")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject addedSubject, @PathVariable Integer userId) {
        log.info("[JOVAN] /addSubject is called");
        log.info("ADDED SUBJECT " + addedSubject);
        log.info("ADDED SUBJECT USER ID " + userId);
        try {
            log.info("ADDED SUBJECT TRY" );
            return new ResponseEntity<>(subjectService.addSubject(addedSubject, userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getSubjects() {
        log.info("[JOVAN] /subjects is called");
        try {
            ResponseEntity<List<Subject>> response = new ResponseEntity<>(subjectService.getSubjects(), HttpStatus.OK);
            log.info("[JOVAN] response length is: "+ response.getBody().size());
            return response;
        } catch (InvalidDataAccessResourceUsageException e) { //db exists, tbl doesn't exist
            log.info("[JOVAN] exception message is: "+e);
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }

    @PutMapping("/subjects")
    public ResponseEntity<Subject> updateCountry(@RequestBody Subject updatedSubject) {
        log.info("[JOVAN] /updateUser is called");
        try {
            return new ResponseEntity<>(subjectService.updateSubject(updatedSubject), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("subjects/{subjectId}")
    public ResponseEntity<Subject> deleteCountry(@PathVariable Integer subjectId) {
        log.info("[JOVAN] subjects/{subjectId} is called");
        try {
            return new ResponseEntity<>(subjectService.deleteSubject(subjectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
