package br.library.infra.util;

@SuppressWarnings("serial")
public class CustomExeption extends Exception {

    public CustomExeption(String s) {
        super(s);
    }

    public CustomExeption(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CustomExeption(Throwable throwable) {
        super(throwable);
    }
}
