package main;

import java.util.ArrayList;

public class ListarProdutos {
    public static void listarProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no sistema.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.toString() + " | Categoria: " + produto.getCategoria().getNome()
                        + " | Custo de Compra: " + produto.getCategoria().getCustoCompra()
                        + " | Valor de Venda: " + produto.getCategoria().getValorVenda());
            }
        }
    }
}
