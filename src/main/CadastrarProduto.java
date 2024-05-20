package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastrarProduto {
    public static void cadastrarProduto(ArrayList<Produto> produtos, int proximoCodigo, Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a categoria do produto: ");
        String categoriaNome = scanner.nextLine();

        System.out.print("Digite o custo de compra: ");
        double custoCompra = 0;
        boolean custoValido = false;

        while (!custoValido) {
            try {
                custoCompra = scanner.nextDouble();
                scanner.nextLine();
                if (custoCompra >= 0) {
                    custoValido = true;
                } else {
                    System.out.println("Custo de compra deve ser maior ou igual a zero. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }

        System.out.print("Digite o valor de venda: ");
        double valorVenda = 0;
        boolean valorValido = false;

        while (!valorValido) {
            try {
                valorVenda = scanner.nextDouble();
                scanner.nextLine();
                if (valorVenda >= 0) {
                    valorValido = true;
                } else {
                    System.out.println("Valor de venda deve ser maior ou igual a zero. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }

        Categoria categoria = new Categoria(categoriaNome, custoCompra, valorVenda);
        int codigo = proximoCodigo++;
        Produto produto = new Produto(nome, codigo, 0, categoria);
        produtos.add(produto);

        System.out.println(nome + " cadastrado com sucesso. Código: " + codigo + ", Estoque: " + produto.getEstoque());
    }
}
