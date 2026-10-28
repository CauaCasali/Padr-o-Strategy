package padraoStrategy;

public class RegraCobrancaAntecipada implements RegraCobranca {

    private static final float PERCENTUAL_DESCONTO = 0.05f;

    public float calcularValorFinal(float valor, int diasAtraso) {
        return valor - (valor * PERCENTUAL_DESCONTO);
    }
}
