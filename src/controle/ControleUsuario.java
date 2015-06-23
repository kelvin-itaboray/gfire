package controle;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Carlosmcdo
 */
public class ControleUsuario {
    public static Usuario logado;
    
    public boolean adicionarUsuario(Usuario cadUsuario) {
        String SQL = "INSERT INTO usuario (nome,senha,telefone) VALUES(?, ?, ?)";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, cadUsuario.getNome());
            pst.setString(2, cadUsuario.getSenha());
            pst.setString(3, cadUsuario.getTelefone());
            pst.executeUpdate();
            pst = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao inserir: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }

    public boolean alterarUsuario(Usuario altUsuario) {
        String SQL = "UPDATE usuario SET nome = ?, senha = ?, telefone = ?"
                + "WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, altUsuario.getNome());
            pst.setString(2, altUsuario.getSenha());
            pst.setString(3, altUsuario.getTelefone());
            pst.setInt(5, altUsuario.getIdUsuario());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }

    public boolean removerUsuario(Usuario remUsuario) {
        String SQL = "DELETE FROM funcionario WHERE id_funcionario=?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt(1, remUsuario.getIdUsuario());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar! Usuário atualmente está vinculado a uma conta!", "ERRO", 0);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!", "Remover", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public boolean desativarUsuario(Usuario altUsuario) {
        String SQL = "UPDATE usuario SET statusU = 0 WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt(1, altUsuario.getIdUsuario());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public ArrayList<Usuario> getUsuarios() {
        String SQL = "SELECT idUsuario, nome, senha, telefone, statusU, isAdmin FROM usuario WHERE statusU = 1";
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        ArrayList<Usuario> user = new ArrayList<>();
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            while (tabela.next()) {
                Usuario usr = new Usuario();
                usr.setIdUsuario(tabela.getInt(1));
                usr.setNome(tabela.getString(2));
                usr.setSenha(tabela.getString(3));
                usr.setTelefone(tabela.getString(4));
                usr.setStatus(tabela.getBoolean(5));
                usr.setIsAdmin(tabela.getBoolean(6));
                user.add(usr);
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
        return user;
    }

    public Usuario getUsuario(int id) {
        String SQL = "SELECT idUsuario, nome, senha, telefone, statusU, isAdmin FROM usuario WHERE idUsuario = " + id;
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        Usuario user = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            if (tabela.next()) {
                user = new Usuario();
                user.setIdUsuario(tabela.getInt(1));
                user.setNome(tabela.getString(2));
                user.setSenha(tabela.getString(3));
                user.setTelefone(tabela.getString(4));
                user.setStatus(tabela.getBoolean(5));
                user.setIsAdmin(tabela.getBoolean(6));
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
        return user;
    }

    public Usuario getUsuarioByLogin(String nome, String senha) {
        String SQL = "SELECT idUsuario, nome, senha, telefone, statusU, isAdmin FROM usuario WHERE nome = '" + nome + "' AND senha = '" + senha + "' AND statusU = 1";
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        Usuario user = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            if (tabela.next()) {
                user = new Usuario();
                user.setIdUsuario(tabela.getInt(1));
                user.setNome(tabela.getString(2));
                user.setSenha(tabela.getString(3));
                user.setTelefone(tabela.getString(4));
                user.setStatus(tabela.getBoolean(5));
                user.setIsAdmin(tabela.getBoolean(6));
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
        return user;
    }
    
    public boolean validarUsuario(Usuario u){
        Validar v = new Validar();
        return v.validaNome(u.getNome()) && v.validaCampoFormatado(u.getSenha()) && v.validaNumero(u.getTelefone());
    }
    
    public void logar(Usuario logado){
        ControleUsuario.logado = logado;
    }
    
    public Usuario getLogado(){
        return ControleUsuario.logado;
    }
}
