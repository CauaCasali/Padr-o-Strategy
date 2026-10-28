package padraoStrategy;

public class Secretaria {

    private float valorCobrado;

    public float getValorCobrado() {
        return valorCobrado;
    }

    public void cobrarAntecipado(float valor) {
        Mensalidade mensalidade = new Mensalidade(valor);
        this.valorCobrado = mensalidade.calcularValorFinal(new RegraCobrancaAntecipada());
    }

    public void cobrarNoVencimento(float valor) {
        Mensalidade mensalidade = new Mensalidade(valor);
        this.valorCobrado = mensalidade.calcularValorFinal(new RegraCobrancaNoVencimento());
    }

    public void cobrarComAtraso(float valor, int diasAtraso) {
        Mensalidade mensalidade = new Mensalidade(valor);
        mensalidade.setDiasAtraso(diasAtraso);
        this.valorCobrado = mensalidade.calcularValorFinal(new RegraCobrancaComAtraso());
    }
}
