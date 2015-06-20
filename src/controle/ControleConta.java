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

        public boolean adicionarConta(Conta cadConta) {
        String SQL = "INSERT INTO conta (tipo, valor, dataVencimento) "
                    + "VALUES(?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, cadConta.getTipo());
            pst.setDouble(2, cadConta.getValor());
            pst.setString(3, cadConta.getDataVencimento());
            pst.executeUpdate();
            pst = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao inserir: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public boolean alterarConta(Conta altConta) {
        String SQL = "UPDATE conta SET idUsuario = ?, idContaFixa = ?, tipo = ?, valor = ? "
                   + "dataVencimento = ? WHERE idConta = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt (1, altConta.getIdUsuario());
            pst.setInt (2, altConta.getIdContaFixa());
            pst.setString(3, altConta.getTipo());
            pst.setDouble(4, altConta.getValor());
            pst.setString(5, altConta.getDataVencimento());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão ao alterar: " + e.getMessage(), "ERRO", 0);
            return false;
        }
        return true;
    }
    
    public boolean removerConta(Conta remConta) {
        String SQL = "DELETE FROM conta WHERE idConta = ?";
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = Conexao.getConexao();
            pst = conn.prepareStatement(SQL);
            pst.setInt(1, remConta.getIdConta());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar! Conta atualmente está pendente!", "ERRO", 0);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Conta removido com sucesso!", "Remover", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public ArrayList <Conta> getConta() {
    
        String SQL = "SELECT idConta, idUsuario, idContaFixa, tipo, valor, dataVencimento FROM conta";
        
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
                ct.setIdContaFixa(tabela.getInt(3));
                ct.setTipo(tabela.getString(4));
                ct.setValor(tabela.getDouble(5));
                ct.setDataVencimento(tabela.getString(6));
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
        String SQL = "SELECT idConta, idUsuario, idContaFixa, tipo, valor, dataVencimento"
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
                conta.setIdContaFixa(tabela.getInt(3));
                conta.setTipo(tabela.getString(4));
                conta.setValor(tabela.getDouble(5));
                conta.setDataVencimento(tabela.getString(6));
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
}