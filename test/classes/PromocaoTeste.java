package classes;

import org.junit.Test;
import view.Promocao;

public class PromocaoTeste {
    @Test
    public void adicionarPromocao() {
        Promocao.adicionarPromocao("2 Por 45", 2, 2, 45.0);
    }
    @Test
    public void removerPromocao() {
        Promocao.removerPromocao("Leva 3 Paga 2");
    }
}
