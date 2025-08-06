package app; // Define o pacote da classe.

import java.util.Scanner; //Importa biblioteca para leitura de dados.

public class MenuApp {// Classe da aplicação.
	//ponto de partida da aplicação.
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);//cria objeto para capturar dados digitados.
		UsuarioService usuarioService = new UsuarioService(); //gerencia usuarios.
		int opcao = 0; //armazena a escolha do menu.
		do {
			System.out.println(" ========== MENU ==========");
			System.out.println("1 - Cadastrar Usuários");
			System.out.println("2 - Listar Usuários");
			System.out.println("3 - Sair");
			System.out.println("Escolha uma opção: ");
			opcao = scanner.nextInt(); //Armazena a opção digitada em opcao.
			scanner.nextLine(); //Limpra o buffer do teclado.
			switch (opcao) { //inicia a estrutura de repetição baseada em opcao.
			case 1: // opcao = 1
				System.out.println("Digite o nome do usuário: ");
				String nome = scanner.nextLine();
				usuarioService.cadastrarUsuario(nome);		
				break;
			case 2: // opcao = 2
				usuarioService.listarUsuarios();
				break;
			case 3: // opcao = 3
				break;
			default: // opcao diferente de 1, 2 ou 3.
				System.out.println("Opção Inválida! Tente Novamente.");
			}
			System.out.println();
		}while(opcao != 3); // finaliza se a opcao for igual a 3
		
		scanner.close();
	}

}