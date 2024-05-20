package main;

import java.io.Serializable;

public class Categoria implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String nome;
    private double custoCompra;
    private double valorVenda;

    public Categoria(String nome, double custoCompra, double valorVenda) {
        this.nome = nome;
        this.custoCompra = custoCompra;
        this.valorVenda = valorVenda;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoCompra() {
        return custoCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }
}
