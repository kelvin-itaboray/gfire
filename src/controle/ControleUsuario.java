package controle;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author itaboray
 */
/*
public class ControleFuncionario {

    public boolean adicionarFuncionario(Funcionario cadfunc) {
        String SQL = "INSERT INTO funcionario (nome,login,senha) VALUES( ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, cadfunc.getNomeFuncionario());
            pst.setString(2, cadfunc.getLogin());
            pst.setString(3, cadfunc.getSenha());
            pst.executeUpdate();
            pst = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao inserir: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }

    public boolean alterarFuncionario(Funcionario cadfunc) {
        String SQL = "update funcionario set nome=?,login=?,senha=? where id_funcionario=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, cadfunc.getNomeFuncionario());
            pst.setString(2, cadfunc.getLogin());
            pst.setString(3, cadfunc.getSenha());
            pst.setInt(4, cadfunc.getIdFuncionario());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }

    public boolean removerFuncionario(Funcionario cadfunc) {
        String SQL = "delete from funcionario where id_funcionario=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt(1, cadfunc.getIdFuncionario());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar! Funcionário atualmente está vinculado a uma ligação!", "ERRO", 0);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!", "Remover", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        String SQL = "select id_funcionario, nome, senha,login from funcionario";
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        ArrayList<Funcionario> fun = new ArrayList<>();
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            while (tabela.next()) {
                Funcionario func = new Funcionario();
                func.setIdFuncionario(tabela.getInt(1));
                func.setNomeFuncionario(tabela.getString(2));
                func.setSenha(tabela.getString(3));
                func.setLogin(tabela.getString(4));
                fun.add(func);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage(), "ERRO", 0);
                }
            }
        }
        return fun;
    }

    public Funcionario getFuncionario(int id) {
        String SQL = "select * from funcionario where id_funcionario=" + id;
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        Funcionario fun = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            if (tabela.next()) {
                fun = new Funcionario();
                fun.setIdFuncionario(tabela.getInt(1));
                fun.setNomeFuncionario(tabela.getString(2));
                fun.setLogin(tabela.getString(3));
                fun.setSenha(tabela.getString(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage(), "ERRO", 0);
                }
            }
        }
        return fun;
    }

    public Funcionario getFuncionarioCriterio(String criterio, String valor) {
        String SQL = "select id_funcionario,nome,login,senha from funcionario where " + criterio + "=" + valor;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet tabela = null;
        Funcionario fun = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            if (tabela.next()) {
                fun = new Funcionario();
                fun.setIdFuncionario(tabela.getInt(1));
                fun.setNomeFuncionario(tabela.getString(2));
                fun.setLogin(tabela.getString(3));
                fun.setSenha(tabela.getString(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao consultar: " + e.getMessage(), "ERRO", 0);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage(), "ERRO", 0);
                }
            }
        }
        return fun;
    }
}
*/