package br.library.controller.register;
/**
 * @author Pedro
 *
 */
import java.util.InputMismatchException;

import br.library.controller.service.ClientService;
import br.library.domain.profile.Client;
import br.library.infra.util.ConsoleReader;

public class ClientRegister {
	private ClientService service;
	
	public ClientRegister(){
		service=new ClientService();
	}
	
	public void registerNewClient() {
        try {
            long cpf = ConsoleReader.scanLong("CPF: ");
            service.clientExist(cpf);
            if (service.clientExist(cpf) == true) {
                System.out.println("Cpf já está cadastrado");
                return;
            }
            String name = ConsoleReader.scanString("Nome: ");
            while (service.nameValidation(name) || name == null) {
                name = ConsoleReader.scanString("Nome inválido, digite novamente:");
            }
            String phone = ConsoleReader.scanString("Telefone (xx) xxxx-xxxx: ");
            while ( phone == null) {
                phone = ConsoleReader.scanString("Número de telefone inválido, digite novamente:");
            }
            long register;
            do {
                register = service.registerGenerator();
            } while (service.registerExist(register) == true);
            service.addClient(new Client(name, cpf, phone, register));
            System.out.println("Cliente " + name + " cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
        }
    }

    public void showClient() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CPF") + "\t"
                + String.format("%-20s", "|Nome") + "\t"
                + String.format("%-20s", "|Telefone")
                + String.format("%-20s", "|Matrícula")
                + String.format("%-20s", "|Livros em posse")
                + String.format("%-20s", "|Quantidade de livros alugados")
                + String.format("%-20s", "    |Quantidade de atrasos"));
        for (Client client : service.listClients()) {
            System.out.println(String.format("%-10s", client.getCpf()) + "\t"
                    + String.format("%-20s", "|" + client.getName()) + "\t"
                    + String.format("%-20s", "|" + client.getPhone() + "\t"
                            + String.format("%-20s", "    |" + client.getRegister() + "\t"
                                    + String.format("%-20s", "|" + client.getBooksRent() + "\t"
                                            + String.format("%-20s", "            |" + client.getQuantityOfBooksRent()
                                                    + String.format("%-20s", "                                |" + client.getLate()))))));
        }
    }

    public void editClient() {
        try {
            long cpf = ConsoleReader.scanLong("Cpf do cliente a ser editado: ");
            if (service.clientExist(cpf) == false) {
                System.out.println("Cpf não existente no cadastro");
                return;
            }
            Client client = service.searchByCpf(cpf);
            System.out.println(client);
            String op = ConsoleReader.scanString("O que deseja alterar? \n1- Nome e Sobrenome: \n2- Telefone: \n3- CPF: \n");
            switch (op) {
                case "1": {
                    String name = ConsoleReader.scanString("Digite o novo nome: ");
                    while (!service.nameValidation(name) || name == null) {
                        name = ConsoleReader.scanString("Nome inválido, digite novamente: ");
                    }
                    service.editClient(op, name, client);
                    System.out.println("Nome alterado com sucesso!");
                    break;
                }
                case "2": {
                    String phone = ConsoleReader.scanString("Digite o novo Telefone (xx) xxxx-xxxx: ");
                    while ( phone == null) {
                        phone = ConsoleReader.scanString("Número de telefone inválido, digite novamente: ");
                    }
                    service.editClient(op, phone, client);
                    System.out.println("Telefone alterado com sucesso!");
                    break;
                }
                case "3": {
                    long newCpf = ConsoleReader.scanLong("Digite o novo Cpf: ");
                    while (service.clientExist(newCpf) == true) {
                        newCpf = ConsoleReader.scanLong("Cpf já está cadastrado, digite novamente: ");
                    }
                    service.editClient(op, newCpf, client);
                    System.out.println("RG alterado com sucesso!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
        }
    }

    public void deleteClient() {
        try {
            long rg = ConsoleReader.scanLong("Cpf do cliente a ser deletado: ");
            if (!service.clientExist(rg)) {
                System.out.println("Cpf não existente no cadastro");
                return;
            }
            Client client = service.searchByCpf(rg);
            System.out.println("Informações do Cliente:");
            System.out.println("ID: " + client.getId());
            System.out.println("RG: " + client.getCpf());
            System.out.println("Nome: " + client.getName());
            System.out.println("Telefone: " + client.getPhone());
            System.out.println("Matrícula: " + client.getRegister());
            System.out.println("Total de livros alugados: " + client.getQuantityOfBooksRent());

            String confirmacao = ConsoleReader.scanString("Deseja realmente remover este cadastro "
                    + client.getName() + "? (Sim/Não)");
            if (confirmacao.equalsIgnoreCase("sim")) {
                if (client.getQuantityOfBooksRent() > 0) {
                    System.out.println("Livro alugado registrado no nome deste cliente, favor retornar todos os livros antes de deletar este registro");
                } else {
                    service.deleteClient(client);
                    System.out.println("Cliente " + client.getName() + " deletado com sucesso!");
                }
            } else {
                System.out.println("Operação cancelada!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
        }
    }

    public void searchClient() {
        String op = ConsoleReader.scanString("Busca do cliente, opções: \n1- Procurar por Cpf \n2- Procurar por Nome \n3- Voltar \n");
        try {
            switch (op) {
                case "1": {
                    long cpf = ConsoleReader.scanLong("Digite o CPF: ");
                    if (service.clientExist(cpf) == false) {
                        System.out.println("Cliente não cadastrado!");
                        return;
                    }
                    Client client = service.searchByCpf(cpf);
                    System.out.println(client);
                    break;
                }
                case "2": {
                    String name = ConsoleReader.scanString("Digite o ID do cliente: ");
                    if (service.nameExist(name) == false) {
                        System.out.println("Cliente não cadastrado!");
                        return;
                    }
                    Client client = service.searchClientByName(name);
                    System.out.println(client);
                    break;
                }
                case "3": {
                    return;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
        }
    }
}
