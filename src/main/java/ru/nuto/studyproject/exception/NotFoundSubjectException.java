package ru.nuto.studyproject.exception;

public class NotFoundSubjectException extends RuntimeException {
  public NotFoundSubjectException(Long id) {super(String.format("not found subject by with id=%d",id));}
}
