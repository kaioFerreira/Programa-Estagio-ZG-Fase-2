package controller;

import classes.Produto;
import model.dao.EstoqueDAO;

public class EstoqueController {

    public static void cadastrarEstoque(Produto produto) {
        EstoqueDAO.insereProdutoBanco(produto);
    }

    public static void removerEstoque(String nomeProduto) {
        EstoqueDAO.removerProdutoBanco(nomeProduto);
    }

    public static void alterarNomeEstoque(String nomeProduto, String novoNomeProduto) {
        EstoqueDAO.alterarNomeBanco(nomeProduto, novoNomeProduto);
    }

    public static void alterarValorCustoEstoque(String nomeProduto, Double novoValorCusto) {
        EstoqueDAO.alterarValorCustoBanco(nomeProduto, novoValorCusto);
    }

    public static void alterarValorVendaEstoque(String nomeProduto, Double novoValorVenda) {
        EstoqueDAO.alterarValorVendaBanco(nomeProduto, novoValorVenda);
    }

    public static int quantidadeNoEstoque(String nomeProduto) {
        return EstoqueDAO.quantidadeNoBanco(nomeProduto);
    }

    public static void alterarQuantidadeEstoque(String nomeProduto, int quantidadeFinal) {
        if (quantidadeFinal < 0) {
            quantidadeFinal = 0;
        }
        EstoqueDAO.alterarQuantidadeBanco(nomeProduto, quantidadeFinal);
    }
}
