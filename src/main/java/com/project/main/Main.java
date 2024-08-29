package com.project.main;

import com.project.banco.ContaBanco;

public class Main {

    public static void main(String[] args) {

        ContaBanco c = new ContaBanco();
        c.setAgencia(111);
        c.setEstadoConta(true);
        c.setSaldo(10000);
        c.setNumeroConta(0);
        c.setNomeCliente("Teste");

        /*Para entrar basta digitar 0 como número da conta ou abrir uma*/
        c.index();
    }
}
