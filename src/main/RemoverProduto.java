package main;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoverProduto {
    public static void removerProduto(ArrayList<Produto> produtos, Scanner scanner) {
        System.out.print("Digite o código do produto a ser removido: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                System.out.println("Produto encontrado: " + produto.getNome());
                System.out.print("Confirma a remoção deste produto? (S/N): ");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("S")) {
                    produtos.remove(produto);
                    System.out.println("Produto removido com sucesso.");
                } else {
                    System.out.println("A remoção do produto foi cancelada.");
                }
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}
