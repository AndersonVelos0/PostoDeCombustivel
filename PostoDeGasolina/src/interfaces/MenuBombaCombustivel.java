package interfaces;

import java.util.Scanner;
import negocio.BombaCombustivel;

/**
 *
 * @author Anderson
 * 
 */
public class MenuBombaCombustivel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BombaCombustivel cliente = new BombaCombustivel("gasolina", 5.5, 200, "senha123", "gerente123", false);

		int opcao = 0;

		while (opcao != 8) {

			System.out.println("==========MENU==========");
			System.out.println("1 - LIBERAR");
			System.out.println("2 - ABASTECER");
			System.out.println("3 - ATUALIZAR PREÇO");
			System.out.println("4 - ATUALIZAR PREÇO");
			System.out.println("5 - EXIBIR MÉDIA DO PREÇO");
			System.out.println("6 - BLOQUEAR BOMBA");
			System.out.println("7 - LIBERAR(GERENTE)");
			System.out.println("8 - SAIR");
			System.out.println("==========XXXX==========");
			System.out.println("Digite uma opção!");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite a senha da bomba: ");
				String senhaEntrada = sc.next();
				cliente.liberar(senhaEntrada);
				break;
			case 2:
				System.out.println("Digite o valor em litros " + "para abastecer");
				double l = sc.nextDouble();
				cliente.abasteceCliente(l);
				break;

			case 3:
				System.out.println("Por favor, digite o novo preço " + "do litro do combustível!");
				double novoPreco = sc.nextDouble();
				cliente.setPrecoAtual(novoPreco);
				break;

			case 4:
				System.out.println(cliente.toString());
				break;

			case 5:
				System.out.println("O preço médio do combustível é: " + "" + cliente.mediaPreco());
				break;

			case 6:
				cliente.bloquear();
				break;

			case 7:
				System.out.println("Por favor, senhor gerente, " + "digite sua senha!");
				sc.nextLine();
				String senhaGerente = sc.nextLine();
				cliente.liberarGerente(senhaGerente);
				break;

			case 8:
				System.out.println("Obrigado e volte sempre!");
				break;

			default:
				System.out.println("Digite uma resposta válida!");
				break;
			}

		}

		sc.close();
	}
}
