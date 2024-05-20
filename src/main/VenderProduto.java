package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VenderProduto {
    public static double venderProduto(ArrayList<Produto> produtos, Scanner scanner, double saldoComercio) {
        System.out.print("Digite o código do produto a ser vendido: ");
        int codigo = -1; 
        boolean codigoValido = false;

        while (!codigoValido) {
            try {
                codigo = scanner.nextInt();
                scanner.nextLine(); 

                for (Produto produto : produtos) {
                    if (produto.getCodigo() == codigo) {
                        codigoValido = true;
                        break;
                    }
                }

                if (!codigoValido) {
                    System.out.println("Código do produto não encontrado. Tente novamente: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine(); 
            }
        }

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                boolean quantidadeValida = false;
                int quantidade = 0;

                while (!quantidadeValida) {
                    try {
                        System.out.print("Digite a quantidade a ser vendida: ");
                        quantidade = scanner.nextInt();
                        scanner.nextLine(); 

                        if (quantidade >= 0 && quantidade <= produto.getEstoque()) {
                            quantidadeValida = true;
                        } else {
                            System.out.println("Quantidade inválida. Tente novamente: ");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Digite um número inteiro.");
                        scanner.nextLine(); 
                    }
                }

                if (quantidade > 0) {
                    produto.vender(quantidade);
                    double valorTotalVenda = quantidade * produto.getCategoria().getValorVenda();
                    saldoComercio += valorTotalVenda;
                    System.out.println("Produto vendido com sucesso. Saldo do comércio atualizado: " + saldoComercio);
                } else {
                    System.out.println("Nenhum produto vendido.");
                }
                return quantidade;
            }
        }

        System.out.println("Produto não encontrado.");
		return codigo;
    }
}
