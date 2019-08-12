package model.dao;

import classes.DistribuidoraModelo;
import connection.ConnectionBank;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DistribuidoraDAO {

    public static void adicionaBanco(DistribuidoraModelo itemDistribuidora) {
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement(
                    "INSERT INTO distribuidora (nome,telefone,email) "
                    + "VALUES (?,?,?);"
            );

            stmt.setString(1, itemDistribuidora.getNome());
            stmt.setObject(2, itemDistribuidora.getTelefone());
            stmt.setObject(3, itemDistribuidora.getEmail());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }
}
