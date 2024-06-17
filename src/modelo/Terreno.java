package modelo;

public class Terreno extends Financiamento{

    String tipoZona;

    public Terreno(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros, String tipoZona) {
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
        this.tipoZona = tipoZona;
    }

    public double CalcularPagamentoMensal() {
        
        double pagMen = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual / 100) / 12)) * 1.02;
        
        return pagMen;
    }
}
