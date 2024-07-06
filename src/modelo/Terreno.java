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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Valor do Imovel: " + this.valorImovel + "\n");
        sb.append("Valor do Financiamento: " + this.CalcularPagamentoTotal() + "\n");
        sb.append("Taxa de Juros: " + this.taxaJurosAnual + "\n");
        sb.append("Prazo em anos: " + this.prazoFinanciamento + "\n");
        sb.append("Tipo da zona do terreno: " + this.tipoZona + "\n\n");
        
        return sb.toString();
    }
}
