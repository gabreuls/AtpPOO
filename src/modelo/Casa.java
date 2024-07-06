package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento{

    double areaConstruida;
    double areaTerreno;

    public Casa(double valorDoImovel, int prazoDoFinanciamentoAnos, double taxaAnualJuros, double areaConstruida, double areaTerreno){
        super(valorDoImovel, prazoDoFinanciamentoAnos, taxaAnualJuros);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double CalcularPagamentoMensal() {

        double valorJuros = (1 + ((this.taxaJurosAnual / 100) / 12)) + 80;
        int valorDesconto = 82;

        double pagMen = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual / 100) / 12)) + 80;
        
        try {
            ValidarDesconto(valorJuros, valorDesconto);
            return pagMen - valorDesconto;
            
        } catch (DescontoMaiorDoQueJurosException e) {
            //Apllicando um Desconto padrão de 50
            return pagMen - 50;
        }
    }

    private void ValidarDesconto (double valorDesconto, double valorJuros) throws DescontoMaiorDoQueJurosException {

        if (valorDesconto >= valorJuros) {
            throw new DescontoMaiorDoQueJurosException("O valor de Desconto é maior que os Juros");
        };
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Valor do Imovel: " + String.format("%.2f", this.valorImovel) + "\n");
        sb.append("Valor do Financiamento: " + String.format("%.2f", this.CalcularPagamentoTotal()) + "\n");
        sb.append("Taxa de Juros: " + this.taxaJurosAnual + "\n");
        sb.append("Prazo em anos: " + this.prazoFinanciamento + "\n");
        sb.append("Area Construida: " + this.areaConstruida + "\n");
        sb.append("Area total do Terreno: " + this.areaTerreno + "\n\n");
        
        return sb.toString();
    }
}
