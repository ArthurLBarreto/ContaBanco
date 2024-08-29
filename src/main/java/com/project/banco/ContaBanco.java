package com.project.banco;

import java.util.Random;
import java.util.Scanner;

public class ContaBanco {

    /*Variaveis e Instâncias*/
    Scanner sc = new Scanner(System.in);

    private int numeroConta;
    private int agencia;
    private String nomeCliente;
    private float saldo;
    private boolean estadoConta;
    private char pronome;

    /*Contrutores*/
    public ContaBanco() {
    }

    public ContaBanco(int numeroConta, int agencia, String nomeCliente, float saldo) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.estadoConta = true;
    }

    /*Metodos*/
    /**
     * *
     * Pagina Inical Do Banco
     */
    public void index() {
        int i = 0;
        while (i == 0) {
            while (i == 0) {
                System.out.println("Banco Olá Mundo");
                quebraLinha();
                System.out.println("Digite:\n1 - Entrar em uma conta\n2 - Criar uma conta\n3 - Fechar banco");
                int teste = sc.nextInt();
                switch (teste) {
                    case 1 -> {
                        entrarConta();
                        i++;
                    }
                    case 2 -> {
                        abrirConta();
                        i++;
                    }
                    case 3 ->
                        i--;
                    default ->
                        System.out.println("Opção invalido. Por favor digite um opção valido");
                }
            }

            while (i == 1) {
                
                quebraLinha();
                System.out.println("Olá, senhor" + getPronome() + " " + getNomeCliente());
                quebraLinha();
                System.out.println("O que deseja fazer:\n1 - Sacar\n2 - Depositar\n3 - Checar Conta\n4 - Fechar Conta\n5 - Sair Banco");
                int teste = sc.nextInt();
                switch (teste) {
                    /*Sacar*/
                    case 1 -> {
                    }
                    /*Depositar*/
                    case 2 -> {
                    }
                    /*Checar Conta*/
                    case 3 -> {
                        checarConta();
                    }
                    /*Fechar conta*/
                    case 4 -> {
                        fecharConta();
                    }
                    /*Sair do banco*/
                    case 5 -> {
                        i--;
                    }
                    default ->
                        System.out.println("Opção invalido. Por favor digite um opção valido");
                }
            }
        }

    }

    /**
     * *
     * Abre uma conta no banco
     */
    public void abrirConta() {
        int i = 0;
        if (!isEstadoConta()) {
            while (i == 0) {
                if (getNomeCliente() == null) {
                    System.out.println("Olá, obrigado pela preferencia em escolher o nosso banco\nPara começarmos qual o seu nome?");
                    System.out.println();
                    setNomeCliente(sc.nextLine());
                }

                System.out.println("Seu nome está correto ? (" + getNomeCliente() + ")\n1 - Sim\n2 - Não ");
                int teste = sc.nextInt();
                sc.nextLine();
                switch (teste) {
                    case 1 -> {
                        System.out.println("OK, seu nome será salvo como: " + getNomeCliente());
                        i++;
                    }
                    case 2 -> {
                        System.out.println("Ok, Vamos começar novamente.");
                        setNomeCliente(null);
                    }
                    default ->
                        System.out.println("Opção invalido. Por favor digite um opção valido.");
                }
            }

            while (i == 1) {
                System.out.println("Qual pronome deveriamos charma-lo?\n1 - Ele\n2 - Ela\n3 - Prefiro não falar ");
                int teste = sc.nextInt();

                switch (teste) {
                    case 1 -> {
                        System.out.println("Ok, obrigado Senhor " + getNomeCliente());
                        i++;
                    }
                    case 2 -> {
                        System.out.println("Ok, obrigado senhora " + getNomeCliente());
                        setPronome('a');
                        i++;
                    }
                    case 3 -> {
                        System.out.println("Tem certaza? iremos lhe tratar pelo pronome ele.\n Exemplo: Senhor\n1 - Sim\n2 - Não");
                        int testePronome = sc.nextInt();
                        switch (testePronome) {
                            case 1:
                                System.out.println("Ok, obrigado senhor " + getNomeCliente());
                                i++;
                            case 2:
                                System.out.println("Ok, irei perguntar novamente.");
                            default:
                                System.out.println("Opção invalido. Por favor digite um opção valido");
                        }
                    }
                    default -> {
                        System.out.println("Opção invalido. Por favor digite um opção valido");
                    }
                }

            }

        }

        setAgencia(new Random().nextInt(1000, 9999));
        setNumeroConta(new Random().nextInt(10000, 99999));
        setSaldo(0);
        setEstadoConta(true);
        System.out.println("Obrigado por confiar em nos senhor" + getPronome() + " " + getNomeCliente());
        System.out.println("O número da sua conta é " + getNumeroConta() + " e o número da agência é " + getAgencia());
    }

    /**
     * *
     * Fecha uma conta do banco
     */
    public void fecharConta() {
        if (isEstadoConta()) {
            quebraLinha();
            System.out.println("Tem certeza que deseja fechar a sua conta?\n1 - Sim\n2 - Não ");
            int confirmação = sc.nextInt();

            switch (confirmação) {
                case 1:
                    if (getSaldo() == 0) {
                        System.out.println("Ok, foi uma honra telo como cliente Sr(a). " + getNomeCliente() + "\nEstamos encerrando sua conta.");
                        System.out.println("Caso deseje pode abrir uma conta novamente. Ficariamos honrado em telo(a) como cliente novamente");
                        setEstadoConta(false);
                    } else {
                        System.out.println("O senhor" + getPronome() + " ainda possui saldo na conta, por favor zere ele para poder fechar a conta");
                    }
                case 2:
                    System.out.println("Obrigado por confiar em nós mais uma vez");

                    break;
                default:
                    System.out.println("Opção invalido. Por favor digite um opção valido");
            }

        }

    }

    /**
     * *
     * Metodo para sacar um valor
     */
    public void sacar() {
        int i = 0;

        while (i == 0) {
            quebraLinha();
            System.out.println("Seu saldo é: " + getSaldo());
            System.out.println("Digite o valor a ser sacado");
            int valor = sc.nextInt();
            if (valor < 0) {
                System.out.println("Digite um valor valido para sacar");
            } else if (valor <= getSaldo()) {
                setSaldo(getSaldo() - valor);
                System.out.println("Valor sacado");
                System.out.println("Saldo atual: " + getSaldo());
                System.out.println("Deseja sacar mais?\n1 - Sim\n2 - Não");
                int teste = sc.nextInt();
                switch (teste) {
                    case 1 -> {
                    }
                    case 2 -> {
                        i++;
                    }
                    default ->
                        System.out.println("Opção  invalido. Por favor digite um opção  valido");
                }
            } else if (valor > getSaldo()) {
                System.out.println("Você não possui o valor Digitado. \nPor favor digite um valor valido");
            }
        }

    }

    /**
     * *
     * Metodo para depositar um valor
     */
    public void depositar() {
        int i = 0;

        while (i == 0) {
            quebraLinha();
            System.out.println("Seu saldo é: " + getSaldo());
            System.out.println("Digite o valor a ser depositado");
            int valor = sc.nextInt();
            if (valor > 0) {
                setSaldo(valor);
                System.out.println("Valor adicionado");
                System.out.println("Seu saldo é: " + getSaldo());
                System.out.println("Deseja depositar mais?\n1 - Sim\n2 - Não");
                int teste = sc.nextInt();
                switch (teste) {
                    case 1 -> {
                    }
                    case 2 -> {
                        i++;
                    }
                    default ->
                        System.out.println("Opção invalido. Por favor digite um opção valido");
                }
            }
        }

    }

    /**
     * *
     * Metodo para checar as caracteristicas da conta
     */
    public void checarConta() {
        quebraLinha();
        int i = 0;
        while (i == 0) {
            System.out.println("Nome do Cliente: " + getNomeCliente() + "\nNúmero da conta: " + getNumeroConta());
            System.out.println("Número da agência: " + getAgencia() + "\nSaldo da conta: " + getSaldo());
            quebraLinha();
            System.out.println("digite qualquer coisa para voltar para tela incial");
            sc.next();
            i++;
        }

    }

    /**
     * *
     * Metodo para fazer login na conta
     */
    public void entrarConta() {
        quebraLinha();
        int i = 0;
        while (i == 0) {

            System.out.println("Digite o número da conta");
            int numero = sc.nextInt();

            if (numero == getNumeroConta()) {
               
                i++;
            } else {
                System.out.println("Número incorreto\nDigite:\n1 - Abrir uma conta\n2 - Tentar novamente\n3 - Sair");
                int teste = sc.nextInt();
                switch (teste) {
                    case 1 -> {
                        abrirConta();
                    }

                    case 2 -> {

                    }
                    case 3 -> {
                        System.exit(0);
                    }
                    default ->
                        throw new AssertionError();
                }
            }

        }
    }

    /**
     * *
     * Metodo para quebrar linha
     */
    public void quebraLinha() {
        System.out.println("");
        System.out.print("-----------------------------------");
        System.out.println("");
    }

    /*Gets e Sets*/
    public char getPronome() {
        return pronome;
    }

    public void setPronome(char pronome) {
        this.pronome = pronome;
    }

    public boolean isEstadoConta() {
        return estadoConta;
    }

    public void setEstadoConta(boolean estadoConta) {
        this.estadoConta = estadoConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
