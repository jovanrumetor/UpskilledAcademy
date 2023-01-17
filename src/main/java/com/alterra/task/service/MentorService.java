package com.alterra.task.service;

import com.alterra.task.entity.Mentor;
import com.alterra.task.repository.MentorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MentorService {
    @Autowired(required = false)
    MentorRepository mentorRepository;

    public List<Mentor> getMentors() { return (List<Mentor>) mentorRepository.findAll(); }

    public Mentor addMentor(Mentor addedMentor) {
        long size = mentorRepository.count();
        log.info("[JOVAN] MENTOR REPOSITORY IS: "+size);
        Integer newId = (int) size + 1;
        log.info("[JOVAN] newId IS: " + newId);
        Mentor mentor = new Mentor(newId, addedMentor.getName(), addedMentor.getTopic());
        log.info("[JOVAN] newly added MENTOR IS: " + mentor.getId() + mentor.getName());
        mentorRepository.save(mentor);
        log.info("[JOVAN] newly added MENTOR in REPOSITORY IS: " + mentorRepository.findById(newId).get());
        return mentorRepository.findById(newId).get();
    }

    public Mentor updateMentor(Mentor updatedMentor) {
        mentorRepository.save(updatedMentor);
        return mentorRepository.findById(updatedMentor.getId()).get();
    }

    public Mentor deleteMentor(Integer mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId).get();
        mentorRepository.deleteById(mentor.getId());
        return mentor;
    }

}
