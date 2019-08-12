package view;

import classes.Produto;
import controller.EstoqueController;

public class Estoque {

    public static void cadastrarProdutoEstoque(String nome, Double valorCusto, Double valorVenda, int quantidade, int idDistribuidora) {
        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setValorCusto(valorCusto);
        produto.setValorVenda(valorVenda);
        produto.setQuantidade(quantidade);
        produto.setIdDistribuidora(idDistribuidora);

        EstoqueController.cadastrarEstoque(produto);
    }

    public static void removerProdutoEstoque(String nomeProduto) {
        EstoqueController.removerEstoque(nomeProduto);
    }

    public static void alterarNomeProduto(String nomeProduto, String novoNomeProduto) {
        EstoqueController.alterarNomeEstoque(nomeProduto, novoNomeProduto);
    }

    public static void alterarValorCustoProduto(String nomeProduto, Double novoValorCusto) {
        EstoqueController.alterarValorCustoEstoque(nomeProduto, novoValorCusto);
    }

    public static void alterarValorVendaProduto(String nomeProduto, Double novoValorVenda) {
        EstoqueController.alterarValorVendaEstoque(nomeProduto, novoValorVenda);
    }

    public static void adicionarQuantidadeProduto(String nomeProduto, int quantidadeAdicional) {
        int QunatidadeNoEstoque = EstoqueController.quantidadeNoEstoque(nomeProduto);
        EstoqueController.alterarQuantidadeEstoque(nomeProduto, quantidadeAdicional + QunatidadeNoEstoque);
    }

    public static void removerQuantidadeProduto(String nomeProduto, int quantidadeRemover) {
        int QunatidadeNoEstoque = EstoqueController.quantidadeNoEstoque(nomeProduto);
        EstoqueController.alterarQuantidadeEstoque(nomeProduto, QunatidadeNoEstoque - quantidadeRemover);
    }
}
