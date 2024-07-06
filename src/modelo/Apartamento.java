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
        
        double taxaJurosMensal = ((this.taxaJurosAnual / 100) / 12);
        int prazoFinanMeses = prazoFinanciamento * 12;

        double pagMensal = (valorImovel * Math.pow((1 + taxaJurosMensal), prazoFinanMeses)) / Math.pow((1 + taxaJurosMensal), (prazoFinanMeses - 1));

        return pagMensal;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Valor do Imovel: " + String.format("%.2f", this.valorImovel) + "\n");
        sb.append("Valor do Financiamento: " + String.format("%.2f",this.CalcularPagamentoTotal()) + "\n");
        sb.append("Taxa de Juros: " + this.taxaJurosAnual + "\n");
        sb.append("Prazo em anos: " + this.prazoFinanciamento + "\n");
        sb.append("N Andar: " + this.numeroAndar + "\n");
        sb.append("Qtd vagas garagem: " + this.numeroVagasGaragem + "\n\n");
        
        return sb.toString();
    }
}
