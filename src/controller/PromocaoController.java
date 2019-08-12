package controller;

import classes.PromocaoModelo;
import model.dao.PromocaoDAO;

public class PromocaoController {

    public static void adicionarPromocao(PromocaoModelo promocao) {
        PromocaoDAO.adicionarPromocaoBanco(promocao);
    }

    public static void removerPromocao(String nomePromocao) {
        PromocaoDAO.removerPromocaoBanco(nomePromocao);
    }

}
