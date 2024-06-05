package modelo;

public class Financiamento {

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento (double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros) {
        this.valorImovel = valorDoImovel;
        this.prazoFinanciamento = prazoDoFinanciamentoAnos;
        this.taxaJurosAnual = taxaAnualJuros;
    }

    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public double CalcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    public double CalcularPagamentoTotal() {
        return (this.CalcularPagamentoMensal() * this.prazoFinanciamento * 12);
    }
    
    public void MostrarDadosFinanciamento() {
        System.out.println("Dados do Financiamento:");
        System.out.printf("Valor Total do Imóvel: %d \n", getValorImovel());
        System.out.printf("Financiamento feito em %i anos.\n", getPrazoFinanciamento());
        System.out.printf("Taxa de Juros por ano do Financiamento: %d", getTaxaJurosAnual());
    }

}