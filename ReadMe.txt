TokenCreation-
This works by choosing 130 bits from a cryptographically secure random bit generator,
 and encoding them in base-32. 128 bits is considered to be cryptographically strong, 
but each digit in a base 32 number can encode 5 bits, 
so 128 is rounded up to the next multiple of 5. 
This encoding is compact and efficient, with 5 random bits per character.
 Compare this to a random UUID, which only has 3.4 bits per character in standard layout, 
and only 122 random bits in total.

If you allow session identifiers to be easily guessable (too short, flawed random number generator, etc.)
, attackers can hijack other's sessions. Note that SecureRandom objects are expensive to initialize, 
so you'll want to keep one around and reuse it.