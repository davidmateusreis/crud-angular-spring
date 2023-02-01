package com.david.crudspring.exception;

public class RecordNotFountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordNotFountException(Long id) {
        super("Registro não encontrado com o id: " + id);
    }
}
