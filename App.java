package com.mycompany.gerenciabanco;
import java.util.Scanner; // Esse trecho permite que o código receba entrada de dados

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String nome, sobrenome, cpf;
        int opcao;
        
        System.out.println("Bem vindo ao Banco Ouro!\nDigite seu nome:");
        nome = scanner.next();
        System.out.println("\nDigite seu sobrenome:");
        sobrenome = scanner.next();
        System.out.println("\nDigite seu CPF:");
        cpf = scanner.next();
        
        // Esse trecho de código cria um novo objeto da classe conta bancária
        
        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf, 2000);
        double saldo = conta.getSaldo();
        
        // DO...WHILE
        // Enquanto o usuário não digitar 4 o sistema continuara funcionando.
        
        do {
            System.out.println("Bem-vindo ao Banco Ouro\n\n" + conta.getNome() + " " + conta.getSobrenome() + "\t\t\tCPF: " + conta.getCpf() + "\n\n1-Consultar Saldo\n2-Depositar\n3-Sacar\n4-Sair\n\n");
            opcao = scanner.nextInt();
            
            // O controle de fluxo switch é o menu principal, de acordo com cada opção digitada uma ação será tomada
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

//CLASSE CONTA BANCÁRIA

class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private int saldo;
    
    public ContaBancaria(String nome, String sobrenome, String cpf, int saldo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = saldo;
    }
    
    //MÉTODOS
    
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
    
    public String getNome () {
        return nome;
    }
    
    public String getSobrenome () {
        return sobrenome;
    }
    
        public String getCpf () {
        return cpf;
    }
     
}
