package main;

import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int codigo;
    private int estoque;
    private Categoria categoria;

    public Produto(String nome, int codigo, int estoque, Categoria categoria) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getEstoque() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public void vender(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    @Override
    public String toString() {
        return nome + " (cód.: " + codigo + " | estoque: " + estoque + ")";
    }
}
