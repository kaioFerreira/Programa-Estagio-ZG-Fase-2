package classes;

import org.junit.Test;
import view.Estoque;

public class EstoqueTeste {
    @Test
    public void testeCadastro() {
        Estoque.cadastrarProdutoEstoque("C", 9.0, 20.0, 5, 1);
    }
    @Test
    public void testeRemocao() {
        Estoque.removerProdutoEstoque("J");
    }
    @Test
    public void alterarNomeProduto() {
        Estoque.alterarNomeProduto("kaio", "C");
    }
    @Test
    public void alterarValorCustoProduto() {
        Estoque.alterarValorCustoProduto("kaio", 5.0);
    }
    @Test
    public void alterarValorVendaProduto() {
        Estoque.alterarValorVendaProduto("kaio", 5.0);
    }
    @Test
    public void adicionarQuantidadeBanco() {
        Estoque.adicionarQuantidadeProduto("A", 6);
    }
    @Test
    public void removerQuantidadeBanco() {
        Estoque.removerQuantidadeProduto("kaio", 6);
    }
}
