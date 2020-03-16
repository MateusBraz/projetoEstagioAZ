package br.com.selecao.test.locadora.business.exception;

public class ObjectExistingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectExistingException(String message) {
        super(message);
    }

    public ObjectExistingException(String message, Throwable cause) {
        super(message, cause);
    }
}
