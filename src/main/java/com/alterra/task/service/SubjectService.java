package com.alterra.task.service;

import com.alterra.task.entity.Subject;
import com.alterra.task.entity.Mentor;
import com.alterra.task.repository.SubjectRepository;
import com.alterra.task.repository.MentorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubjectService {

    @Autowired(required = false)
    SubjectRepository subjectRepository;

    @Autowired(required = false)
    MentorRepository mentorRepository;


    public List<Subject> getSubjects() { return (List<Subject>) subjectRepository.findAll();}

    public Subject addSubject(Subject addedSubject, Integer userId) {
        long size = subjectRepository.count();
        log.info("[JOVAN] SUBJECT REPOSITORY IS: "+size);
        Integer newId = (int) size + 1;
        log.info("[JOVAN] newId IS: " + newId);
        log.info("[JOVAN] user ID IS: " + mentorRepository.findById(userId).get());
        Mentor mentor = mentorRepository.findById(userId).get();
        log.info("[JOVAN] USER IS: " + mentor);
        Subject subject = new Subject(newId, mentor.getName() ,addedSubject.getSubjectName(), addedSubject.getSubjectDay());
        log.info("[JOVAN] newly added SUBJECT IS: " + subject.getId() + subject.getSubjectName());
        subjectRepository.save(subject);
        log.info("[JOVAN] newly added SUBJECT in REPOSITORY IS: " + subjectRepository.findById(newId).get());
        return subjectRepository.findById(newId).get();
    }

    public Subject updateSubject(Subject updatedSubject) {
        subjectRepository.save(updatedSubject);
        return subjectRepository.findById(updatedSubject.getId()).get();
    }

    public Subject deleteSubject(Integer subjectId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        subjectRepository.deleteById(subject.getId());
        return subject;
    }
}
