package main;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldoComercio = 1000.0;
        Relatorio relatorio = new Relatorio(saldoComercio);
        ArrayList<Produto> produtos1 = new ArrayList<>();

        int proximoCodigo1 = 1;

        Date dataAtual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateFormat.format(dataAtual);
        System.out.println("Data atual: " + dataFormatada);
        
        

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1)- Listar todos os produtos");
            System.out.println("2)- Cadastrar um novo produto");
            System.out.println("3)- Adicionar estoque de um produto");
            System.out.println("4)- Remover um produto do comércio");
            System.out.println("5)- Vender algum produto existente");
            System.out.println("6)- Relatório");
            System.out.println("7)- Sair do programa");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    ListarProdutos.listarProdutos(produtos1);
                    break;
                case 2:
                    CadastrarProduto.cadastrarProduto(produtos1, proximoCodigo1, scanner);
                    proximoCodigo1++;
                    break;
                case 3:
                    saldoComercio = AdicionarEstoque.adicionarEstoque(produtos1, scanner, saldoComercio);
                    break;
                case 4:
                    RemoverProduto.removerProduto(produtos1, scanner);
                    break;
                case 5:
                    saldoComercio = VenderProduto.venderProduto(produtos1, scanner, saldoComercio);
                    break;
                case 6:
                    relatorio.gerarRelatorio(); 
                    break;
                case 7:
                    SairDoPrograma.sairDoPrograma(produtos1, saldoComercio);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
   
}

//ALUNOS: David Lucas Cordeiro De Vasconcelos
//Jeferson Tiago Ribeiro Costa
//Thawan De Azevedo Teles
//Matheus Medeiros Torres
