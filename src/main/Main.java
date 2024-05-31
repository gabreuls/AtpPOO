package main;

import util.InterfaceUser;
import modelo.Financiamento;

public class Main {
    public static void main(String[] args) throws Exception {

        InterfaceUser interfaceUser = new InterfaceUser();

        double valorImovel = interfaceUser.pedirValorImovel();
        int prazoFinanciamento = interfaceUser.pedirPrazoFinanciamentoAnos();
        double taxaJuros = interfaceUser.pedirTaxaJuros();

        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        financiamento.CalcularPagamentoMensal();

    }
}
