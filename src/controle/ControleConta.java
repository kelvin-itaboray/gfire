/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Conta;

/**
 *
 * @author Carlos
 */
public class ControleConta {

        public boolean adicionarConta(Conta conta) {
        String SQL = "INSERT INTO conta (idUsuario, nome, valor, dataVencimento, isFixo) "
                    + "VALUES(?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt(1, conta.getIdUsuario());
            pst.setString(2, conta.getNome());
            pst.setDouble(3, conta.getValor());
            pst.setString(4, conta.getDataVencimento());
            pst.setBoolean(5, conta.isIsFixo());
            pst.executeUpdate();
            pst = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao inserir: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public boolean alterarConta(Conta altConta) {
        String SQL = "UPDATE conta SET nome = ?, valor = ?, "
                   + "dataVencimento = ?, isFixo = ? WHERE idConta = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, altConta.getNome());
            pst.setDouble(2, altConta.getValor());
            pst.setString(3, altConta.getDataVencimento());
            pst.setBoolean(4, altConta.isIsFixo());
            pst.setInt(5, altConta.getIdConta());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public boolean removerConta(Conta conta) {
        String SQL = "DELETE FROM conta WHERE idConta = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt(1, conta.getIdConta());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar! Conta atualmente está pendente!", "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public ArrayList <Conta> getContas() {
        String SQL = "SELECT idConta, idUsuario, nome, valor, dataVencimento, pago, isFixo FROM conta";
        
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        ArrayList<Conta> conta = new ArrayList<>();
        
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            while (tabela.next()) {
                Conta ct = new Conta();
                ct.setIdConta(tabela.getInt(1));
                ct.setIdUsuario(tabela.getInt(2));
                ct.setNome(tabela.getString(3));
                ct.setValor(tabela.getDouble(4));
                ct.setDataVencimento(tabela.getString(5));
                ct.setPago(tabela.getBoolean(6));
                ct.setIsFixo(tabela.getBoolean(7));
                conta.add(ct);
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
        return conta;
    }
    
    public Conta getConta(int id) {
        String SQL = "SELECT idConta, idUsuario, nome, valor, dataVencimento, pago, isFixo "
                   + "FROM conta WHERE idConta = " + id;
        Connection conn;
        PreparedStatement pst = null;
        ResultSet tabela;
        Conta conta = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            tabela = pst.executeQuery();
            if (tabela.next()) {
                conta = new Conta();
                conta.setIdConta(tabela.getInt(1));
                conta.setIdUsuario(tabela.getInt(2));
                conta.setNome(tabela.getString(3));
                conta.setValor(tabela.getDouble(4));
                conta.setDataVencimento(tabela.getString(5));
                conta.setPago(tabela.getBoolean(6));
                conta.setIsFixo(tabela.getBoolean(7));
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
        return conta;
    }
    
    public boolean validarConta(Conta c){
        Validar v = new Validar();
        return v.validaNome(c.getNome()) && v.validaQuantia(c.getValor()+"") && v.validaDataDepoisHoje(c.getDataVencimento());
    }
}