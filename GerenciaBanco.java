package com.mycompany.gerenciabanco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jeanz
 */
public class GerenciaBanco {
    
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
        
    }
    
    public static void operacoes(){
        System.out.println("----------------------------------------------------------");
        System.out.println("--------------Bem vindos a nossa Agencia------------------");
        System.out.println("********* Selecione uma operacao que deseja realizar ******");
        System.out.println("-      Opcao 1 - Criar conta   -");
        System.out.println("-      Opcao 2 - Depositar     -");
        System.out.println("-      Opcao 3 - Sacar         -");
        System.out.println("-      Opcao 4 - Transferir    -");
        System.out.println("-      Opcao 5 - Listar        -");
        System.out.println("-      Opcao 6 - Sair          -");
        
        int operacao = input.nextInt();
        
        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
           case 6:
                System.out.println("Obrigado pela preferencia");
                System.exit(0);
                
           default:
               System.out.println("Opcao invalida!");
               operacoes();
               break;
                  
                
        }
    }
    
    public static void criarConta(){
        System.out.println("\nNome:  ");
        String nome = input.next();
        
        System.out.println("\nCPF:  ");
        String cpf = input.next();
        
        System.out.println("\nEmail:  ");
        String email = input.next();
        
        Pessoa pessoa = new Pessoa(nome, cpf, email);
        
        Conta conta = new Conta(pessoa);
        
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");
        
        operacoes();
        

    }
    
    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for(Conta c : contasBancarias) {
                if(c.getNumeroConta() == numeroConta){
                conta = c;
                }
            }
        }
        return conta;
    }
    
    public static void depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = input.nextInt();
        
        Conta conta = encontrarConta(numeroConta);
        
        if(conta != null){
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            
            conta.depositar(valorDeposito);
        }else{
            System.out.println(" Conta nao encotnrada! ");
        }
        operacoes();
    }
    
    public static void sacar(){
        System.out.println("Numero da conta:");
        int numeroConta = input.nextInt();
        
        Conta conta = encontrarConta(numeroConta);
        
        if(conta != null){
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = input.nextDouble();
        }else{
            System.out.println("Conta nao encontrada!");
        }
        operacoes();
    }
    
    public static void transferir() {
        System.out.println("Numero da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();
        
        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        
        if(contaRemetente != null){
            System.out.println("Numero da conta do destinatario");
            int numeroContaDestinatario = input.nextInt();
            
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            
            if(contaDestinatario != null){
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();
                
                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                System.out.println("A conta para deseposito nao foi encontarada");
            }
        }else {
            System.out.println("Conta para Transferencia nao econtrada");
        }
        operacoes();
    }
    
    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias){
                System.out.println(conta);
                
            }
        } else {
            System.out.println("Nao ha contas cadastradas!");
        }
        operacoes();
    }

}
