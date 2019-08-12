
package view;

import classes.DistribuidoraModelo;
import controller.DistribuidoraController;

public class Distribuidora {
    public static void adicionarDistribuidora(String nome, String telefone, String email){
        DistribuidoraModelo distribuidora = new DistribuidoraModelo();
        
        distribuidora.setNome(nome);
        distribuidora.setTelefone(telefone);
        distribuidora.setEmail(email);
        DistribuidoraController.adicionaBanco(distribuidora);
    } 
}
