package util;

import java.util.Scanner;

public class InterfaceUser {
    Scanner scanner = new Scanner(System.in);

    public double pedirValorImovel() {
        
        double valor;
        
        try {
            while (true) {
                System.out.print("Digite o valor do Imóvel: ");
                valor = scanner.nextDouble();
                // Inserir um valor entre 10.000 e 999.999.999.
                if (valor >= 10000 && valor <= 999999999) {
                    break;
                } else {
                    System.out.println("VALOR NÃO PERMITIDO. TENTE NOVAMENTE!");
                }
            }
            return valor;
            
        } catch (Exception e) {
            System.out.println("Entrada Inválida! Valor ajustado para o padrão: R$ 100.000");
            valor = 100000;
            return valor;
        }
    }

    public int pedirPrazoFinanciamentoAnos() {

        int prazo;

        try {
            while (true) {
                System.out.print("Digite o prazo do Financiamento em Anos: ");
                prazo = scanner.nextInt();
                // Inserir um valor entre 0 e 100 anos.
                if (prazo > 0 && prazo <= 100) {
                    break;
                } else {
                    System.out.println("VALOR NÃO PERMITIDO. TENTE NOVAMENTE!");
                }
            }
            return prazo;
            
        } catch (Exception e) {
            System.out.println("Entrada Inválida! Valor ajustado para o padrão: 50 anos");
            prazo = 50;
            return prazo;
        }
    }

    public double pedirTaxaJuros() {

        double juros;
        
        try {
            while (true) {
                System.out.print("Digite o valor da Taxa de Juros: ");
                juros = scanner.nextDouble();
                // Inserir um valor entre 0% e 150%
                if (juros >= 0 && juros <= 150) {
                    break;
                } else {
                    System.out.println("VALOR NÃO PERMITIDO. TENTE NOVAMENTE!");
                }
            }
            return juros;
            
        } catch (Exception e) {
            System.out.println("Entrada Inválida! Valor ajustado para o padrão: 75% de juros");
            juros = 75;
            return juros;
        }
    }
    
}
