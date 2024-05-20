package main;

import java.util.ArrayList;
import java.util.Scanner;

public class AdicionarEstoque {
    public static double adicionarEstoque(ArrayList<Produto> produtos, Scanner scanner, double saldoComercio) {
        System.out.print("Digite o código do produto para adicionar estoque: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                System.out.print("Digite a quantidade a ser adicionada ao estoque: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                if (quantidade > 0) {
                    produto.adicionarEstoque(quantidade);
                    System.out.println("Estoque atualizado para " + produto.getEstoque());
                } else {
                    System.out.println("Quantidade inválida. Tente novamente.");
                }
                return quantidade;
            }
        }

        System.out.println("Produto não encontrado.");
		return codigo;
    }
}
