package ru.nuto.studyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nuto.studyproject.dto.SubjectDto;
import ru.nuto.studyproject.mapper.SubjectMapper;
import ru.nuto.studyproject.model.Subject;
import ru.nuto.studyproject.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper mapper;

    public Subject saveSubject(Subject subject){
        Subject savedSubject = subjectRepository.save(subject);
        return savedSubject;
    }

    public List<SubjectDto> getSubjects(){
        List<SubjectDto> subjectsDto = mapper.toDto(subjectRepository.findAll());
        return subjectsDto;
    }

    public List<Subject> findSubjectsById(List<Long> ids){
        List<Subject> subjects = subjectRepository.findAllById(ids);
        return subjects;
    }
}
