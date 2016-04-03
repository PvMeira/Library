package util;

import java.security.SecureRandom;
import java.util.Random;
import java.math.BigInteger;

public final class TokenCreation {
	private SecureRandom random = new SecureRandom();
	private Random generator = new Random();

	public String nextSessionId() {
		return new BigInteger(30, random).toString(25);
	}

	public final int codRentCreation() {
		int i = generator.nextInt(50);
		return i;
	}

}