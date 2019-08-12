package model.dao;

import classes.PromocaoModelo;
import connection.ConnectionBank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO {

    public static void adicionarPromocaoBanco(PromocaoModelo promocao) {
        Connection con = ConnectionBank.getConnection();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("INSERT INTO promocao (nome_promocao,produto_relacionado,quantidade_leva,valor_unidade,valor_total) "
                    + "VALUES (?,?,?,?,?);");

            st.setString(1, promocao.getNomePromocao());
            st.setInt(2, promocao.getProdutoRelacionado());
            st.setInt(3, promocao.getQuantidadeLeva());
            st.setDouble(4, promocao.getValorUnidade());
            st.setDouble(5, promocao.getValorTotal());
            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, st);
        }
    }

    public static void removerPromocaoBanco(String nomePromocao) {

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement(
                    "DELETE FROM promocao WHERE nome_promocao = ?;"
            );

            stmt.setString(1, nomePromocao);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static List<PromocaoModelo> listaPromocoes() {
        List<PromocaoModelo> listaPromocoes = new ArrayList<>();

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                    "SELECT nome_promocao,produto_relacionado,quantidade_leva,valor_unidade,valor_total FROM promocao ORDER BY valor_unidade;"
            );

            rs = stmt.executeQuery();

            while (rs.next()) {

                PromocaoModelo promocao = new PromocaoModelo();

                promocao.setNomePromocao(rs.getString("nome_promocao"));
                promocao.setProdutoRelacionado(rs.getInt("produto_relacionado"));
                promocao.setQuantidadeLeva(rs.getInt("quantidade_leva"));
                promocao.setValorUnidade(rs.getDouble("valor_unidade"));
                promocao.setValorTotal(rs.getDouble("valor_total"));
                listaPromocoes.add(promocao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }

        return listaPromocoes;
    }
}
