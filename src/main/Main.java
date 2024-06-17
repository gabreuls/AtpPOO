package main;

import util.InterfaceUser;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Imóvel 1");
        InterfaceUser interfaceUser1 = new InterfaceUser();
        double valorImovel1 = interfaceUser1.pedirValorImovel();
        int prazoFinanciamento1 = interfaceUser1.pedirPrazoFinanciamentoAnos();
        double taxaJuros1 = interfaceUser1.pedirTaxaJuros();

        ArrayList<Financiamento> listaTodosFinanciamentos = new ArrayList<Financiamento>();

        Financiamento financiamento1 = new Casa(valorImovel1, prazoFinanciamento1, taxaJuros1, 300, 500);
        Financiamento financiamento2 = new Casa(valorImovel1, prazoFinanciamento1, taxaJuros1, 300, 500);
        Financiamento financiamento3 = new Apartamento(valorImovel1, prazoFinanciamento1, taxaJuros1, 1, 7);
        Financiamento financiamento4 = new Apartamento(valorImovel1, prazoFinanciamento1, taxaJuros1, 2, 5);
        Financiamento financiamento5 = new Terreno(valorImovel1, prazoFinanciamento1, taxaJuros1, "Residencial");

        listaTodosFinanciamentos.add(financiamento1);
        listaTodosFinanciamentos.add(financiamento2);
        listaTodosFinanciamentos.add(financiamento3);
        listaTodosFinanciamentos.add(financiamento4);
        listaTodosFinanciamentos.add(financiamento5);

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
