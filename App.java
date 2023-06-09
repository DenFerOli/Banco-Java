package com.mycompany.gerenciabanco;
import java.util.Scanner;                           // Esse trecho do código permite que o código receba entrada de dados


public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Esse trecho cria um novo objeto da classe conta bancaria.
        ContaBancaria conta = new ContaBancaria("Denis Fernando", "123.321.456-8", 2000);
        
        int opcao;
        double saldo = conta.getSaldo();

        //  LAÇO DO...WHILE
        //  Enquanto o usuário não digitar 4 o sistema continuará funcionando.
        
        do {
            System.out.println("Bem-vindo ao Banco Ouro\n\n" + conta.getTitular() + "\t\t\tCPF: " + conta.getCpf() + "\n\n1-Consultar Saldo\n2-Depositar\n3-Sacar\n4-Sair\n\n");
            opcao = scanner.nextInt();
        
        //  O controle de fluxo switch é o menu principal de acordo com cada opção digitada uma ação será tomada.

            switch(opcao) {
                case 1:
                    System.out.println("\nSeu Saldo atual é R$" + conta.getSaldo() + "\n\n");
                    System.out.println("-----------------------------------------------------");
                    break;
                case 2:
                    System.out.println("\nQual o valor que você deseja depositar?\n");
                    int valorDeposito = scanner.nextInt();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito efetuado com sucesso\n\n");
                    System.out.println("\nSeu Saldo atual é R$" + conta.getSaldo() + "\n\n");
                    System.out.println("-----------------------------------------------------");
                    break;
                case 3:
                    System.out.println("\nQual o valor que você deseja sacar?\n");
                    int valorSaque = scanner.nextInt();
                    
                    if (valorSaque <= conta.getSaldo()) {
                        conta.sacar(valorSaque);
                        System.out.println("Saque efetuado com sucesso\n\n");
                        System.out.println("\nSeu Saldo atual é R$" + conta.getSaldo() + "\n\n");
                    } else {
                        conta.sacar(valorSaque);
                    }

                    System.out.println("-----------------------------------------------------");
                default:
                    break;
            }
            
        } while (opcao != 4);
        System.out.println("Obrigado por usar o Banco Ouro! \nVolte sempre!");
        
        scanner.close();
    }
}

// CLASSE CONTA BANCARIA

class ContaBancaria {
    private String titular;
    private String cpf;
    private int saldo;
    
    public ContaBancaria(String titular, String cpf, int saldo) {
        this.titular = titular;
        this.cpf = cpf;
        this.saldo = saldo;
    }

// MÉTODOS
    
    public void depositar (int valor) {
        saldo += valor;
    }
    
    public void sacar (int valor) {
        if(valor <= saldo ) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    public double getSaldo () {
        return saldo;
    }
    
    public String getTitular () {
        return titular;
    }
    
    public String getCpf () {
        return cpf;
    }
     
}