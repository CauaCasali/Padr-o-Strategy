package padraoStrategy;

public class Mensalidade {

    private float valor;
    private int diasAtraso;

    public Mensalidade(float valor) {
        this.valor = valor;
        this.diasAtraso = 0;
    }

    public float getValor() {
        return valor;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public float calcularValorFinal(RegraCobranca regraCobranca) {
        return regraCobranca.calcularValorFinal(valor, diasAtraso);
    }
}
