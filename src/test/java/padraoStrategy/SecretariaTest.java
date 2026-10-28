package padraoStrategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretariaTest {

    @Test
    public void deveCobrarAntecipadoAplicandoDesconto() {
        Secretaria secretaria = new Secretaria();

        secretaria.cobrarAntecipado(100f);

        assertEquals(95f, secretaria.getValorCobrado(), 0.001f);
    }

    @Test
    public void deveCobrarNoVencimentoSemAlteracao() {
        Secretaria secretaria = new Secretaria();

        secretaria.cobrarNoVencimento(100f);

        assertEquals(100f, secretaria.getValorCobrado(), 0.001f);
    }

    @Test
    public void deveCobrarComAtrasoSemMultaParaTresDiasOuMenos() {
        Secretaria secretaria = new Secretaria();

        secretaria.cobrarComAtraso(100f, 3);

        assertEquals(100f, secretaria.getValorCobrado(), 0.001f);
    }

    @Test
    public void deveCobrarComAtrasoAplicandoMultaParaMaisDeTresDias() {
        Secretaria secretaria = new Secretaria();

        secretaria.cobrarComAtraso(100f, 5);

        assertEquals(104f, secretaria.getValorCobrado(), 0.001f);
    }
}
