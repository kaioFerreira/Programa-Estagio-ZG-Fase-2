package classes;

import org.junit.Test;
import view.Distribuidora;

public class DistribuidoraTeste {
    @Test
    public void adicionaDistribuidora() {
        Distribuidora.adicionarDistribuidora("LV LOCACAO FERRAGISTA", "6235124169", "lvlocacaoferragista@hotmail.com");
    }
}
