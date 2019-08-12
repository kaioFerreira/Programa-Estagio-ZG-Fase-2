package model.dao;

import classes.Produto;
import connection.ConnectionBank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static model.dao.EstoqueDAO.recuperaCodigoProduto;

public class CaixaDAO {

    public static boolean verificaExisteEstoque(String nomeProduto) {
        int codigo_produto = -1;
        int quantidade_produto = 0;

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                    "SELECT codigo_produto,quantidade FROM estoque WHERE nome_produto = ?;"
            );

            stmt.setString(1, nomeProduto);

            rs = stmt.executeQuery();

            rs.next();

            codigo_produto = rs.getInt("codigo_produto");
            quantidade_produto = rs.getInt("quantidade");

        } catch (Exception ex) {

        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }

        if (codigo_produto == -1 || (quantidade_produto == 0)) {
            return false;
        }
        return true;
    }
    
    public static int verificaExisteCaixa(String nomeProduto) {
        int codigo_produto = -1;
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(
                    "SELECT codigo_produto FROM caixa WHERE nome_produto = ?;"
            );

            stmt.setString(1, nomeProduto);

            rs = stmt.executeQuery();

            rs.next();
            if (rs != null) {
                codigo_produto = rs.getInt("codigo_produto");
            }

        } catch (Exception e) {

        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }

        return codigo_produto;
    }

    public static void addCaixaBanco(String nomeProduto) {
        Produto produtoEstoque = new Produto();
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        produtoEstoque = EstoqueDAO.recuperaProduto(nomeProduto);
        int codigo = EstoqueDAO.recuperaCodigoProduto(nomeProduto);

        try {

            stmt = con.prepareStatement(
                    "INSERT INTO caixa (codigo_produto,nome_produto,valor_unitario,quantidade) "
                    + "VALUES (?,?,?,?);"
            );

            stmt.setInt(1, codigo);
            stmt.setString(2, produtoEstoque.getNome());
            stmt.setObject(3, produtoEstoque.getValorVenda());
            stmt.setObject(4, 1);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static void addMaisUmCaixaBanco(String nomeProduto) {
        Produto produto = new Produto();
        produto = recuperaProdutoCaixaBanco(nomeProduto);

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "UPDATE caixa SET quantidade = ? WHERE codigo_produto = ?;"
            );

            stmt.setString(1, Integer.toString(produto.getQuantidade() + 1));

            int codigo_produto = EstoqueDAO.recuperaCodigoProduto(nomeProduto);

            stmt.setInt(2, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {

        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static Produto recuperaProdutoCaixaBanco(String nomeProduto) {
        Produto produto = new Produto();
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                    "SELECT * FROM caixa WHERE nome_produto = ?;"
            );

            stmt.setString(1, nomeProduto);

            rs = stmt.executeQuery();
            rs.next();

            produto.setNome(rs.getString("nome_produto"));
            produto.setValorVenda(rs.getDouble("valor_unitario"));
            produto.setQuantidade(rs.getInt("quantidade"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }
        return produto;
    }

    public static void removeCaixaBanco(String nomeProduto) {
        int codigo_produto = verificaExisteCaixa(nomeProduto);
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "DELETE FROM caixa WHERE codigo_produto = ?;"
            );

            stmt.setInt(1, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static void removeUnidadeCaixa(String nomeProduto) {
        int codigo_produto = recuperaCodigoProduto(nomeProduto);
        Produto produto = new Produto();
        produto = CaixaDAO.recuperaProdutoCaixaBanco(nomeProduto);

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(
                    "UPDATE caixa SET quantidade = ? WHERE codigo_produto = ?;"
            );

            stmt.setInt(1, produto.getQuantidade() - 1);
            stmt.setInt(2, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static List<Produto> ItensCaixa() {
        List<Produto> ItensCaixa = new ArrayList<>();

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                    "SELECT nome_produto,valor_unitario,quantidade FROM caixa"
            );

            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setNome(rs.getString("nome_produto"));
                produto.setValorVenda(rs.getDouble("valor_unitario"));
                produto.setQuantidade(rs.getInt("quantidade"));
                ItensCaixa.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }

        return ItensCaixa;
    }

}
