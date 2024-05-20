package main;

import java.util.ArrayList;

public class SairDoPrograma {
    public static void sairDoPrograma(ArrayList<Produto> produtos, double saldoComercio) {
        exibirInformacoesSalvas(produtos, saldoComercio);
        System.out.println("Saindo do programa.");
        System.exit(0);
    }

    private static void exibirInformacoesSalvas(ArrayList<Produto> produtos, double saldoComercio) {
        System.out.println("-Informações Salvas-");
        
        System.out.println("Quantidade de vendas:");
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }

        System.out.println("Saldo do Comércio: R$" + saldoComercio);
    }
}
