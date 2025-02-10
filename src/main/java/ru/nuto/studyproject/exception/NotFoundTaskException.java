package ru.nuto.studyproject.exception;

public class NotFoundTaskException extends Throwable {
    public NotFoundTaskException(Long id) {
        super(String.format("задачи с id: %d\n не найдено", id));
    }
}
