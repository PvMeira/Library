package br.library.infra.persistence.setup;

public class BDExeption extends RuntimeException {

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
