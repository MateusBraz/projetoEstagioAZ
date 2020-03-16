package br.com.selecao.test.locadora.business.exception;

public class ObjectHasLink extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectHasLink(String message) {
        super(message);
    }

    public ObjectHasLink(String message, Throwable cause) {
        super(message, cause);
    }
}
