package view;

import classes.PromocaoModelo;
import controller.PromocaoController;

public class Promocao {

    public static void adicionarPromocao(String nome, int produtoRelacinado, int quantidadeLeva, Double valorTotal) {
        PromocaoModelo promocao = new PromocaoModelo();

        promocao.setNomePromocao(nome);
        promocao.setProdutoRelacionado(produtoRelacinado);
        promocao.setQuantidadeLeva(quantidadeLeva);
        promocao.setValorUnidade(valorTotal / quantidadeLeva);
        promocao.setValorTotal(valorTotal);

        PromocaoController.adicionarPromocao(promocao);
    }

    public static void removerPromocao(String nomePromocao) {
        PromocaoController.removerPromocao(nomePromocao);
    }

}
