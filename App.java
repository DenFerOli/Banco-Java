package com.mycompany.gerenciabanco;
import java.util.Scanner;

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ContaBancaria conta = new ContaBancaria("Denis Fernando", "123.321.456-8", 2000);
        
        int opcao;
        double saldo = conta.getSaldo();
        
        do {
            System.out.println("Bem vindo ao Banco Ouro\n\n" + conta.getTitular() + "\t\t\tCPF: " + conta.getCpf() + "\n\n1-Consultar Saldo\n2-Depositar\n3-Sacar\n4-Sair\n\n");
            opcao = scanner.nextInt();
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
                    conta.sacar(valorSaque);
                    System.out.println("Saque efetuado com sucesso\n\n");
                    System.out.println("\nSeu Saldo atual é R$" + conta.getSaldo() + "\n\n");
                    System.out.println("-----------------------------------------------------");
                default:
                    System.out.println("Obrigado por usar o Banco");
                    break;
            }
            
        } while (opcao != 4);
        
        
        scanner.close();
    }
}

class ContaBancaria {
    private String titular;
    private String cpf;
    private int saldo;
    
    public ContaBancaria(String titular, String cpf, int saldo) {
        this.titular = titular;
        this.cpf = cpf;
        this.saldo = saldo;
    }
    
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