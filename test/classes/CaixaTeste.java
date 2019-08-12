package classes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import view.Caixa;

public class CaixaTeste {
    @Test
    public void adicionaCaixa() {
        Caixa.add("C");
    }
    @Test
    public void removeCaixa() {
        Caixa.remove("B");   
    }
    @Test
    public void testeGetTotalPrice() {
        Double result = 130.0;
        assertEquals(result, Caixa.getTotalPrice());
    }
}
