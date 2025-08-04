package lanchonete.pedidos;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] nomeHamburguer = new String[100];
        Double[] precoHamburguer = new Double[100];
        int[] quantidadePedido = new int[100];

        int totalProdutos = 0;

        System.out.println("Cadastrar Produtos");
        for (int i = 0; i < 2; i++) {
            System.out.print("Digite o nome do Hambúrguer: ");
            nomeHamburguer[i] = input.nextLine();
            
            System.out.print("Digite o preço do Hambúrguer (Ex.: 10.99): ");
            String precoTexto = input.nextLine().replace(",", ".");
            precoHamburguer[i] = Double.parseDouble(precoTexto);

            totalProdutos++;
            System.out.println();
        }

        // Agora passa automaticamente para o pedido
        if (totalProdutos > 0) {
            System.out.println("Cardápio:");
            for (int i = 0; i < totalProdutos; i++) {
                System.out.println((i + 1) + " - " + nomeHamburguer[i] + " - R$ " + precoHamburguer[i]);
            }

            System.out.println("\nDigite a quantidade desejada de cada produto:");
            for (int i = 0; i < totalProdutos; i++) {
                System.out.print(nomeHamburguer[i] + ": ");
                quantidadePedido[i] = input.nextInt();
            }

            double totalPedido = 0;
            System.out.println("\nResumo do Pedido:");
            for (int i = 0; i < totalProdutos; i++) {
                if (quantidadePedido[i] > 0) {
                    double subtotal = quantidadePedido[i] * precoHamburguer[i];
                    totalPedido += subtotal;
                    System.out.printf("%dx %s - R$ %.2f\n", quantidadePedido[i], nomeHamburguer[i], subtotal);
                }
            }
            System.out.println("Total a pagar: R$ " + totalPedido);
        }

        input.close();
    }
}
