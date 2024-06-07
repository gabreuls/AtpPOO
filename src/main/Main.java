package main;

import util.InterfaceUser;
import modelo.Financiamento;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Imóvel 1");
        InterfaceUser interfaceUser1 = new InterfaceUser();
        double valorImovel1 = interfaceUser1.pedirValorImovel();
        int prazoFinanciamento1 = interfaceUser1.pedirPrazoFinanciamentoAnos();
        double taxaJuros1 = interfaceUser1.pedirTaxaJuros();

        System.out.println("Imóvel 2");
        InterfaceUser interfaceUser2 = new InterfaceUser();
        double valorImovel2 = interfaceUser2.pedirValorImovel();
        int prazoFinanciamento2 = interfaceUser2.pedirPrazoFinanciamentoAnos();
        double taxaJuros2 = interfaceUser2.pedirTaxaJuros();

        System.out.println("Imóvel 3");
        InterfaceUser interfaceUser3 = new InterfaceUser();
        double valorImovel3 = interfaceUser3.pedirValorImovel();
        int prazoFinanciamento3 = interfaceUser3.pedirPrazoFinanciamentoAnos();
        double taxaJuros3 = interfaceUser3.pedirTaxaJuros();

        System.out.println("Imóvel 4");
        InterfaceUser interfaceUser4 = new InterfaceUser();
        double valorImovel4 = interfaceUser4.pedirValorImovel();
        int prazoFinanciamento4 = interfaceUser4.pedirPrazoFinanciamentoAnos();
        double taxaJuros4 = interfaceUser4.pedirTaxaJuros();

        ArrayList<Financiamento> listaTodosFinanciamentos = new ArrayList<Financiamento>();

        Financiamento financiamento1 = new Financiamento(valorImovel1, prazoFinanciamento1, taxaJuros1);
        Financiamento financiamento2 = new Financiamento(valorImovel2, prazoFinanciamento2, taxaJuros2);
        Financiamento financiamento3 = new Financiamento(valorImovel3, prazoFinanciamento3, taxaJuros3);
        Financiamento financiamento4 = new Financiamento(valorImovel4, prazoFinanciamento4, taxaJuros4);

        listaTodosFinanciamentos.add(financiamento1);
        listaTodosFinanciamentos.add(financiamento2);
        listaTodosFinanciamentos.add(financiamento3);
        listaTodosFinanciamentos.add(financiamento4);

        CalcularTodosImoveis(listaTodosFinanciamentos);
    }

    public static void CalcularTodosImoveis(ArrayList<Financiamento> listaf) {
        double valorTotalImoveis = 0;
        double pagTotal = 0;
    
        for(int i = 0; i < listaf.size(); i++) {
            Financiamento f = listaf.get(i);
    
            System.out.printf("\nImóvel %d: Valor R$ %.2f; Pagamento Total R$ %.2f\n", i + 1, f.getValorImovel(), f.CalcularPagamentoTotal());
    
            pagTotal += f.CalcularPagamentoTotal();
            valorTotalImoveis += f.getValorImovel(); 
        }
    
        System.out.printf("\n\nValor Total dos Imóveis: R$ %.2f%n", valorTotalImoveis);
        System.out.printf("Valor Total dos Financiamentos: R$ %.2f%n", pagTotal);
            
        }
}
