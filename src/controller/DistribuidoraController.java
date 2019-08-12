
package controller;

import classes.DistribuidoraModelo;
import model.dao.DistribuidoraDAO;

public class DistribuidoraController {

    public static void adicionaBanco(DistribuidoraModelo itemDistribuidora) {
        DistribuidoraDAO.adicionaBanco(itemDistribuidora);
    }
    
}
