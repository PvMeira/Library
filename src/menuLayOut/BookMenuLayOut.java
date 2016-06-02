package menuLayOut;
/**
 * @author Pedro
 *
 */
public class BookMenuLayOut implements layOut{

	
	public String getOptionLayOut() {
		return ("\n----------------------------------------\n" 
	            + "1-Cadastrar novo livro                  :\n"
				+ "2-Deletar livro existente               :\n" 	           
				+ "3-Atualizar livro exixstente            :\n" 
				+ "4-Listar todos livros cadastrados       :\n" 
				+ "5-Buscar pelo nome                      :\n" 
				+ "6-Sair da aplicação                     :\n" 
	            + "\n--------------------------------------\n");
	}
}
