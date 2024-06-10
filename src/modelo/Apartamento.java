package modelo;

public class Apartamento extends Financiamento{

    public Apartamento(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros) {
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
    }

    public double CalcularPagamentoMensal() {
        
        double taxaJurosMensal = taxaJurosAnual / 12;
        int prazoFinanMeses = prazoFinanciamento * 12;

        double pagMensal = (valorImovel * Math.pow((1 + taxaJurosMensal), prazoFinanMeses)) / Math.pow((1 + taxaJurosMensal), (prazoFinanMeses - 1));

        return pagMensal;

    }
}
