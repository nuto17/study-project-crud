package ru.nuto.studyproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nuto.studyproject.dto.SubjectDto;
import ru.nuto.studyproject.exception.NotFoundSubjectException;
import ru.nuto.studyproject.mapper.SubjectMapper;
import ru.nuto.studyproject.model.Subject;
import ru.nuto.studyproject.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper mapper;

    public Subject saveSubject(Subject subject) {
        Subject savedSubject = subjectRepository.save(subject);
        return savedSubject;
    }

    public List<SubjectDto> getSubjects() {
        List<SubjectDto> subjectsDto = mapper.toDto(subjectRepository.findAll());
        return subjectsDto;
    }

    public Subject getSubject(Long id) throws NotFoundSubjectException {
        Subject subjectById = subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundSubjectException(id));
        return subjectById;
    }

    public Subject updateSubject(Long id,Subject subject) {
        Subject subjectById = getSubject(id);
        Subject updatedSubject = Subject.builder()
                .subjectName(subject.getSubjectName())
                .id(subjectById.getId())
                .build();
        Subject savedSubject = subjectRepository.save(updatedSubject);
        return savedSubject;
    }

    public void deleteSubject(Long id) {
        Subject subjectById = getSubject(id);
        subjectRepository.delete(subjectById);
    }
}