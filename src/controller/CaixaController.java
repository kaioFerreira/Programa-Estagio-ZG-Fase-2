package controller;

import classes.Produto;
import classes.PromocaoModelo;
import java.util.ArrayList;
import java.util.List;
import model.dao.CaixaDAO;
import model.dao.EstoqueDAO;
import model.dao.PromocaoDAO;
import view.Estoque;

public class CaixaController {

    private static Double desconto;

    public static void addCaixa(String nomeProduto) {
        boolean verificaExisteEstoque = CaixaDAO.verificaExisteEstoque(nomeProduto);
        int verificaExisteCaixa = CaixaDAO.verificaExisteCaixa(nomeProduto);

        if (verificaExisteEstoque) {
            if (verificaExisteCaixa == -1) {
                CaixaDAO.addCaixaBanco(nomeProduto);
            } else {
                CaixaDAO.addMaisUmCaixaBanco(nomeProduto);
            }
            Estoque.removerQuantidadeProduto(nomeProduto, 1);
        } else {
            System.out.println("Produto Não Existe no Estoque ou Esta em Falta.");
        }
    }

    public static void removeCaixa(String nomeProduto) {
        int verificaExisteCaixa = CaixaDAO.verificaExisteCaixa(nomeProduto);

        if (verificaExisteCaixa != 0) {

            Produto produtoCaixa = new Produto();
            Produto produtoEstoque = new Produto();

            produtoCaixa = CaixaDAO.recuperaProdutoCaixaBanco(nomeProduto);
            produtoEstoque = EstoqueDAO.recuperaProduto(nomeProduto);

            EstoqueDAO.alterarQuantidadeBanco(nomeProduto, produtoEstoque.getQuantidade() + 1);

            if (produtoCaixa.getQuantidade() == 1) {
                CaixaDAO.removeCaixaBanco(nomeProduto);
            } else {
                CaixaDAO.removeUnidadeCaixa(nomeProduto);
            }

        } else {
            System.out.println("Produto Não Esta no caixa.");
        }
    }

    public static Double getTotalPriceCaixa() {
        Double resultado = 0.0;
        Double valorTotal = 0.0;

        List<Produto> listaItensCaixa = new ArrayList<>();
        List<PromocaoModelo> listaPromocoes = new ArrayList<>();

        listaItensCaixa = CaixaDAO.ItensCaixa();

        listaPromocoes = PromocaoDAO.listaPromocoes();

        for (Produto itemCaixa : listaItensCaixa) {
            valorTotal += itemCaixa.getQuantidade() * itemCaixa.getValorVenda();
            int qtd = itemCaixa.getQuantidade();
            for (PromocaoModelo itemPromocao : listaPromocoes) {
                if (itemPromocao.getProdutoRelacionado() == EstoqueDAO.recuperaCodigoProduto(itemCaixa.getNome())) {
                    int aux = qtd / itemPromocao.getQuantidadeLeva();

                    resultado += aux * itemPromocao.getValorTotal();
                    qtd -= aux * itemPromocao.getQuantidadeLeva();
                }
            }
            resultado += qtd * itemCaixa.getValorVenda();
        }
        desconto = valorTotal - resultado;
        return resultado;
    }

    public static Double getTotalDiscount() {
        return desconto;
    }
}
