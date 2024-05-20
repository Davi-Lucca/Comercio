package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaDeDados {
    private static final String ARQUIVO_PRODUTOS = "produtos.txt";
    private static final String ARQUIVO_CAIXA = "caixa.txt";

    public static ArrayList<Produto> carregarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PRODUTOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 4) {
                    String nome = partes[0];
                    int codigo = Integer.parseInt(partes[1]);
                    int estoque = Integer.parseInt(partes[2]);
                    double valorVenda = Double.parseDouble(partes[3]);
                    Categoria categoria = new Categoria("Categoria Padrão", 0, valorVenda);
                    Produto produto = new Produto(nome, codigo, estoque, categoria);
                    produtos.add(produto);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
        }
        return produtos;
    }

    public static double carregarCaixa() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CAIXA))) {
            String valor = reader.readLine();
            if (valor != null) {
                return Double.parseDouble(valor);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar saldo do comércio: " + e.getMessage());
        }
        return 0.0;
    }

    public static void salvarProdutos(List<Produto> produtos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PRODUTOS))) {
            for (Produto produto : produtos) {
                String linha = produto.getNome() + "," + produto.getCodigo() + "," + produto.getEstoque() + "," + produto.getCategoria().getValorVenda();
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    public static void salvarCaixa(double saldoComercio) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CAIXA))) {
            writer.write(Double.toString(saldoComercio));
        } catch (IOException e) {
            System.err.println("Erro ao salvar saldo do comércio: " + e.getMessage());
        }
    }
}
