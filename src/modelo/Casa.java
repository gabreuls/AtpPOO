package modelo;

public class Casa extends Financiamento{

    public Casa(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros){
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
    }

    public double CalcularPagamentoMensal() {
        double pagMen = super.CalcularPagamentoMensal() + 80;
        return pagMen;
    }
}
