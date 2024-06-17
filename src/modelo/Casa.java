package modelo;

public class Casa extends Financiamento{

    double areaConstruida;
    double areaTerreno;

    public Casa(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros, double areaConstruida, double areaTerreno){
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double CalcularPagamentoMensal() {
        double pagMen = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual / 100) / 12)) + 80;
        return pagMen;
    }
}
