package com.alterra.task.controller;

import com.alterra.task.entity.Mentor;
import com.alterra.task.service.MentorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MentorController {
    @Autowired(required = false)
    MentorService mentorService;

    @PostMapping("/mentors")
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor addedMentor) {
        log.info("[JOVAN] /addMentor is called");
        log.info("ADDED MENTOR " + addedMentor);
        try {
            log.info("ADDED MENTOR TRY" );
            return new ResponseEntity<>(mentorService.addMentor(addedMentor), HttpStatus.OK);
        } catch (Exception e) {
            log.info("ADDED MENTOR CATCH" + e);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/mentors")
    public ResponseEntity<List<Mentor>> getMentors() {
        log.info("[JOVAN] /user is called");
        try {
            ResponseEntity<List<Mentor>> response = new ResponseEntity<>(mentorService.getMentors(), HttpStatus.OK);
            log.info("[JOVAN] response length is: "+ response.getBody().size());
            return response;
        } catch (InvalidDataAccessResourceUsageException e) { //db exists, tbl doesn't exist
            log.info("[JOVAN] exception message is: "+e);
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }

    @PutMapping("/mentors")
    public ResponseEntity<Mentor> updateCountry(@RequestBody Mentor updatedMentor) {
        log.info("[JOVAN] /updateUser is called");
        try {
            return new ResponseEntity<>(mentorService.updateMentor(updatedMentor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("mentors/{mentorId}")
    public ResponseEntity<Mentor> deleteCountry(@PathVariable Integer mentorId) {
        log.info("[JOVAN] deleteMentors/{mentorId} is called");
        try {
            return new ResponseEntity<>(mentorService.deleteMentor(mentorId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
