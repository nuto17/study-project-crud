package ru.nuto.studyproject.exception;

public class NotFoundTaskException extends RuntimeException {
    public NotFoundTaskException(Long id) {
        super(String.format("задача с id: %d\n не найдена", id));
    }
}
