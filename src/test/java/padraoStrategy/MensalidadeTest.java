package padraoStrategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MensalidadeTest {

    @Test
    public void deveAplicarDescontoDeCincoPorCentoParaPagamentoAntecipado() {
        Mensalidade mensalidade = new Mensalidade(100f);

        float valorFinal = mensalidade.calcularValorFinal(new RegraCobrancaAntecipada());

        assertEquals(95f, valorFinal, 0.001f);
    }

    @Test
    public void deveManterValorIntegralParaPagamentoNoVencimento() {
        Mensalidade mensalidade = new Mensalidade(100f);

        float valorFinal = mensalidade.calcularValorFinal(new RegraCobrancaNoVencimento());

        assertEquals(100f, valorFinal, 0.001f);
    }

    @Test
    public void deveManterValorIntegralParaAtrasoDeTresDiasOuMenos() {
        Mensalidade mensalidade = new Mensalidade(100f);
        mensalidade.setDiasAtraso(3);

        float valorFinal = mensalidade.calcularValorFinal(new RegraCobrancaComAtraso());

        assertEquals(100f, valorFinal, 0.001f);
    }

    @Test
    public void deveAplicarMultaParaAtrasoDeMaisDeTresDias() {
        Mensalidade mensalidade = new Mensalidade(100f);
        mensalidade.setDiasAtraso(5);

        float valorFinal = mensalidade.calcularValorFinal(new RegraCobrancaComAtraso());

        // 2 dias excedentes (5 - 3), 2% de multa por dia: 100 + (100 * 0.02 * 2) = 104
        assertEquals(104f, valorFinal, 0.001f);
    }

    @Test
    public void deveTratarDiasDeAtrasoNegativosComoZero() {
        Mensalidade mensalidade = new Mensalidade(100f);
        mensalidade.setDiasAtraso(-2);

        float valorFinal = mensalidade.calcularValorFinal(new RegraCobrancaComAtraso());

        assertEquals(100f, valorFinal, 0.001f);
    }
}
