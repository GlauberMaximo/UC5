package app;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClienteDAO dao = new ClienteDAO();
		
		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar Cliente");
			System.out.println("5 - Deletar CLiente");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção: ");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
				case 1:
					System.out.println("Nome: ");
					String nome = sc.nextLine();
					System.out.println("Email: ");
					String email = sc.nextLine();
					
					Cliente cliente = new Cliente(nome, email);
					dao.inserir(cliente);
					
					break;
				case 2:
					List<Cliente> clientes = dao.listarClientes();
					System.out.println("\n--- Lista de Clientes ---");
					for (Cliente c : clientes) {
						System.out.println(c.getId() + " - " + c.getNome() + " (" + c.getEmail() + ")");
					}
					break;
					
				case 3:
					System.out.println("Digite o ID do cliente a ser buscado: ");
				    int idBusca = sc.nextInt();
				    sc.nextLine(); // Limpa o buffer
				    
				    Cliente clienteEncontrado = dao.buscarPorId(idBusca);
				    
				    if (clienteEncontrado != null) {
				        System.out.println("\n--- Cliente Encontrado ---");
				        System.out.println("ID: " + clienteEncontrado.getId());
				        System.out.println("Nome: " + clienteEncontrado.getNome());
				        System.out.println("Email: " + clienteEncontrado.getEmail());
				    } else {
				        System.out.println("Cliente com ID " + idBusca + " não encontrado.");
				    }
				    break;
				case 4:
				    System.out.println("ID do cliente para atualizar: ");
				    int idAtualizar = sc.nextInt();
				    sc.nextLine();
				    
				    if (!dao.existeCliente(idAtualizar)) {
				        System.out.println("Cliente não encontrado com o ID: " + idAtualizar);
				        break;
				    }
				    
				    System.out.println("Novo nome: ");
				    String novoNome = sc.nextLine();
				    System.out.println("Novo email: ");
				    String novoEmail = sc.nextLine();
				    
				    Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoEmail);
				    dao.atualizar(clienteAtualizado);
				    break;
					
				case 5:
				    System.out.println("ID do cliente para deletar: ");
				    int idDeletar = sc.nextInt();
				    
				    if (!dao.existeCliente(idDeletar)) {
				        System.out.println("Cliente não encontrado com o ID: " + idDeletar);
				        break;
				    }
				    
				    dao.deletar(idDeletar);
				    break;
					
				case 0:
					System.out.println("Saindo... ");
					sc.close();
					break;
				default:
					System.out.println("Opção inválida!");
			}
			
		}
	}

}
