package main;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Relatorio {
    private double totalVendas;
    private ArrayList<String> historicoTransacoes = new ArrayList<>();

    public Relatorio(double saldoComercio) {
    
		this.totalVendas = (saldoComercio + totalVendas); 
    }

    public void registrarCompra(double valorCompra) {
        historicoTransacoes.add("Compra realizada em " + obterDataAtual() + ": R$" + valorCompra);
    }

    public void registrarVenda(double valorVenda) {
        totalVendas += valorVenda; 
        historicoTransacoes.add("Venda realizada em " + obterDataAtual() + ": R$" + valorVenda);
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Transações:");
        System.out.println();
       

        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }

        System.out.println("Total Vendas: R$" + totalVendas);
        System.out.println("_________________________________"
        		+ "");
    }

    private String obterDataAtual() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }
}
