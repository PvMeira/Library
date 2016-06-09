package br.library.infra.persistence.setup;

public class BDExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BDExeption(String s) {
		super(s);
	}

	public BDExeption(String s, Throwable throwable) {
		super(s, throwable);
	}

	public BDExeption(Throwable throwable) {
		super(throwable);
	}
}
