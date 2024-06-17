package modelo;

public class Apartamento extends Financiamento{

    int numeroVagasGaragem;
    int numeroAndar;

    public Apartamento(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros, int numeroVagasGaragem, int numeroAndar) {
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double CalcularPagamentoMensal() {
        
        double taxaJurosMensal = taxaJurosAnual / 12;
        int prazoFinanMeses = prazoFinanciamento * 12;

        double pagMensal = (valorImovel * Math.pow((1 + taxaJurosMensal), prazoFinanMeses)) / Math.pow((1 + taxaJurosMensal), (prazoFinanMeses - 1));

        return pagMensal;

    }
}
