import java.util.Scanner;

class Financiamento {

    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

    Financiamento (double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros) {
        this.valorImovel = valorDoImovel;
        this.prazoFinanciamento = prazoDoFinanciamentoAnos;
        this.taxaJurosAnual = taxaAnualJuros;
    }

    double CalcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    double CalcularPagamentoTotal() {
        return (this.CalcularPagamentoMensal() * this.prazoFinanciamento * 12);
    }
    
}

class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    double pedirValorImovel() {
        System.out.print("Digite o valor do Imóvel: ");
        return scanner.nextDouble();
    }

    int pedirPrazoFinanciamentoAnos() {
        System.out.print("Digite o prazo do Financiamento em Anos: ");
        return scanner.nextInt();
    }

    double pedirTaxaJuros() {
        System.out.print("Digite o valor da Taxa de Juros: ");
        return scanner.nextDouble();
    } 
    
}

public class Main {
    public static void main(String[] args) throws Exception {

        InterfaceUsuario interfaceUser = new InterfaceUsuario();

        double valorImovel = interfaceUser.pedirValorImovel();
        int prazoFinanciamento = interfaceUser.pedirPrazoFinanciamentoAnos();
        double taxaJuros = interfaceUser.pedirTaxaJuros();

        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

    }
}
