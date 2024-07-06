package main;

import util.InterfaceUser;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Imóvel 1");
        InterfaceUser interfaceUser1 = new InterfaceUser();
        double valorImovel1 = interfaceUser1.pedirValorImovel();
        int prazoFinanciamento1 = interfaceUser1.pedirPrazoFinanciamentoAnos();
        double taxaJuros1 = interfaceUser1.pedirTaxaJuros();

        ArrayList<Financiamento> listaTodosFinanciamentos = new ArrayList<Financiamento>();

        Financiamento financiamento1 = new Casa(valorImovel1, prazoFinanciamento1, taxaJuros1, 300, 500);
        Financiamento financiamento2 = new Casa(50000, 5, 20, 500, 900);
        Financiamento financiamento3 = new Apartamento(valorImovel1, prazoFinanciamento1, taxaJuros1, 1, 7);
        Financiamento financiamento4 = new Apartamento(75000, 5, 30, 2, 5);
        Financiamento financiamento5 = new Terreno(valorImovel1, prazoFinanciamento1, taxaJuros1, "Residencial");

        listaTodosFinanciamentos.add(financiamento1);
        listaTodosFinanciamentos.add(financiamento2);
        listaTodosFinanciamentos.add(financiamento3);
        listaTodosFinanciamentos.add(financiamento4);
        listaTodosFinanciamentos.add(financiamento5);

//#region Escrita/Leitura Arquivos

        //Escrita
        FileWriter output = null;

        try {
            output = new FileWriter("arquivofinanciamentos.txt");

            output.write(financiamento1.toString());
            output.write(financiamento2.toString());
            output.write(financiamento3.toString());
            output.write(financiamento4.toString());
            output.write(financiamento5.toString());

            output.flush();
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leitura
        FileReader input = null;

        try {
            input = new FileReader("arquivofinanciamentos.txt");
            int caract = 0;

            while ((caract = input.read()) != -1) {
                System.out.print((char)caract);
            }

            input.close();

        } catch (EOFException e) {
            System.out.println("Final do arquivo!");

        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado!");

        } catch (IOException e) {
            e.printStackTrace();
        }

//#endregion

//#region Escrita/Leitura Objects

        // Escrita
        ObjectOutputStream out = null;
        
        try {
            out = new ObjectOutputStream(new FileOutputStream("arquivofinanciamentos.finan"));

            out.writeObject(listaTodosFinanciamentos);

            out.flush();
            out.close();

        } catch (FileNotFoundException exc) {
            System.out.println("O arquivo não foi encontrado!");

        } catch (IOException exc) {
            exc.printStackTrace();
        }

        // Leitura
        ObjectInputStream in = null;
        
        try {
            in = new ObjectInputStream(new FileInputStream("arquivofinanciamentos.finan"));   
            
            ArrayList<Financiamento> listafinan = (ArrayList<Financiamento>) in.readObject();

            for(Financiamento financiamento : listafinan) {
                System.out.println(financiamento.getValorImovel());
                System.out.println(financiamento.getTaxaJurosAnual());
                System.out.println(financiamento.getPrazoFinanciamento());
                System.out.println("\n");
            }

            in.close();
            
        } catch (EOFException exc) {
            System.out.println("Fim do arquivo.");

        } catch (FileNotFoundException exc) {
            System.out.println("O arquivo não foi encontrado!");

        } catch (IOException exc) {
            exc.printStackTrace();
            
        }
//#endregion
    
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
