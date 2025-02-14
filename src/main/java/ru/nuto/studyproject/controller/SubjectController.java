package ru.nuto.studyproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nuto.studyproject.dto.SubjectDto;
import ru.nuto.studyproject.mapper.SubjectMapper;
import ru.nuto.studyproject.model.Subject;
import ru.nuto.studyproject.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping(path = "api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectMapper mapper;

    @PostMapping
    public SubjectDto saveSubjectDto(@RequestBody SubjectDto subjectDto){
        Subject subject = mapper.toModel(subjectDto);
        Subject savedSubject = subjectService.saveSubject(subject);
        SubjectDto savedSubjectDto = mapper.toDto(savedSubject);
        return savedSubjectDto;
    }

    @GetMapping
    public List<SubjectDto> getSubjectsDto(){
        List<SubjectDto> subjectsDto = subjectService.getSubjects();
        return subjectsDto;
    }
}
