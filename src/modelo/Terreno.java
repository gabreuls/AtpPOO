package modelo;

public class Terreno extends Financiamento{

    public Terreno(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros) {
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
    }

    public double CalcularPagamentoMensal() {
        
        double pagMen = super.CalcularPagamentoMensal() * 1.02;
        
        return pagMen;
    }
}
