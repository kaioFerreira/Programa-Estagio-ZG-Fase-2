package model.dao;

import classes.Produto;
import connection.ConnectionBank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueDAO {

    public static void insereProdutoBanco(Produto produto) {
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO estoque (nome_produto,valor_custo,valor_venda,quantidade,id_distribuidora) "
                    + "VALUES (?,?,?,?,?);");

            stmt.setString(1, produto.getNome());
            stmt.setObject(2, produto.getValorCusto());
            stmt.setObject(3, produto.getValorVenda());
            stmt.setObject(4, produto.getQuantidade());
            stmt.setObject(5, produto.getIdDistribuidora());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static void removerProdutoBanco(String nomeProduto) {
        int codigo_produto = recuperaCodigoProduto(nomeProduto);

        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement(
                    "DELETE FROM estoque WHERE codigo_produto = ?;"
            );

            stmt.setInt(1, codigo_produto);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static int recuperaCodigoProduto(String nomeProduto) {
        int codigo_produto = 0;
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                    "SELECT codigo_produto FROM estoque WHERE nome_produto = ?;"
            );

            stmt.setString(1, nomeProduto);

            rs = stmt.executeQuery();
            rs.next();

            codigo_produto = rs.getInt("codigo_produto");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }
        return codigo_produto;
    }

    public static void alterarNomeBanco(String nomeProduto, String novoNomeProduto) {
        int codigo_produto = recuperaCodigoProduto(nomeProduto);
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(
                    "UPDATE estoque SET nome_produto = ? WHERE codigo_produto = ?;"
            );

            stmt.setString(1, novoNomeProduto);
            stmt.setInt(2, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }

    }

    public static void alterarValorCustoBanco(String nomeProduto, Double novoValorCusto) {
        int codigo_produto = recuperaCodigoProduto(nomeProduto);
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "UPDATE estoque SET valor_custo = ? WHERE codigo_produto = ?;"
            );

            stmt.setDouble(1, novoValorCusto);
            stmt.setInt(2, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static void alterarValorVendaBanco(String nomeProduto, Double novoValorVenda) {
        int codigo_produto = recuperaCodigoProduto(nomeProduto);
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "UPDATE estoque SET valor_venda = ? WHERE codigo_produto = ?;"
            );

            stmt.setDouble(1, novoValorVenda);
            stmt.setInt(2, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static int quantidadeNoBanco(String nomeProduto) {
        int quantidade = 0;
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(
                    "SELECT quantidade FROM estoque WHERE nome_produto = ?;"
            );

            stmt.setString(1, nomeProduto);

            rs = stmt.executeQuery();
            rs.next();

            quantidade = Integer.parseInt(rs.getString("quantidade"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }
        return quantidade;
    }

    public static void alterarQuantidadeBanco(String nomeProduto, int quantidadeFinal) {
        int codigo_produto = recuperaCodigoProduto(nomeProduto);
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(
                    "UPDATE estoque SET quantidade = ? WHERE codigo_produto = ?;"
            );

            stmt.setInt(1, quantidadeFinal);
            stmt.setInt(2, codigo_produto);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt);
        }
    }

    public static Produto recuperaProduto(String nomeProduto) {
        Produto produto = new Produto();
        Connection con = ConnectionBank.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement(
                    "SELECT * FROM estoque WHERE nome_produto = ?;"
            );

            stmt.setString(1, nomeProduto);

            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();

            produto.setNome(resultSet.getString("nome_produto"));
            produto.setValorCusto(resultSet.getDouble("valor_custo"));
            produto.setValorVenda(resultSet.getDouble("valor_venda"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
            produto.setIdDistribuidora(resultSet.getInt("id_distribuidora"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionBank.closeConnection(con, stmt, rs);
        }
        return produto;
    }
}
