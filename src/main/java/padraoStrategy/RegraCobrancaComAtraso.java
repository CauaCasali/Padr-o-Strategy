package padraoStrategy;

public class RegraCobrancaComAtraso implements RegraCobranca {

    private static final int DIAS_DE_TOLERANCIA = 3;
    private static final float TAXA_MULTA_POR_DIA = 0.02f;

    public float calcularValorFinal(float valor, int diasAtraso) {
        int quantidadeDias = Math.max(diasAtraso, 0);

        if (quantidadeDias <= DIAS_DE_TOLERANCIA) {
            return valor;
        }

        int diasComMulta = quantidadeDias - DIAS_DE_TOLERANCIA;
        float multa = valor * TAXA_MULTA_POR_DIA * diasComMulta;
        return valor + multa;
    }
}
