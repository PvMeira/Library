TokenCreation-----------------------------------------------------------------------------------------------
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



---------------------------------------------TRABALHO----------------------------------------------------------------
Funcionalidades:
- Cadastro de livros: anota-se para cada livro o ISBN, nome,
autor(es), editora e ano de publicação. Autor(es) e editora podem
ser relacionados como String.(DONE)

- Cadastro de clientes: cliente contém como informação a
matrícula, o nome e telefone.(DONE)

- Retirada de livros: registra a retirada de livros de um cliente. Um
cliente pode retirar no máximo três livros e o livro deve estar
disponível na biblioteca. Essa funcionalidade calcula uma data
para entrega.( DONE)

- Devolução de livros: registra a devolução de livros de um
cliente. Durante a devolução, o livro torna-se disponível
novamente na biblioteca. Verifica se o livro está com atraso e
calcula o número de dias de atraso.( DONE)

- Relatórios: por livros, livros disponíveis(----STILL HAVE TO LOOK, cannot invoke bollean on stream()---), livros mais retirados(DONE),
clientes que mais retiraram um livro, clientes que mais atrasaram(NOT DONE),
etc.( DONE)
--------------------------------------------BUG´S----------------------------------------------------------------------
->treat, when wrong token is type in menu search (DONE)
->treat, when ask the option int in the mune search, client,(DONE) 
book etc, when type other thing than INT, java.util.InputMismatchException( DONE)
-------------------------------------------NOTA----------------------------------------------------------------------------
Realização de testes: testes unitários e testes funcionais bem documentados (documento contendo os testes que foram realizados 
– não precisa estar em uma especificação padrão);
