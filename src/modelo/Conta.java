/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Kelvin
 */
public class Conta {

    private int idConta;
    private int idUsuario;
    private String nome;
    private double valor;
    private String dataVencimento;
    private boolean pago;
    private boolean isFixo;

    /**
     * @return the idConta
     */
    public int getIdConta() {
        return idConta;
    }

    /**
     * @param idConta the idConta to set
     */
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    /**
     * @return the tipo
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the tipo to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the dataVencimento
     */
    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getDataVencimentoFormatado() {
        return dataVencimento.substring(8, 10) + "/" + dataVencimento.substring(5, 7) + "/" + dataVencimento.substring(0, 4);
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public void setDataVencimentoFormatado(String dataVencimento) {
        this.dataVencimento = dataVencimento.substring(6, 10) + "-" + dataVencimento.substring(3, 5) + "-" + dataVencimento.substring(0, 2);
    }

    /**
     * @return the pago
     */
    public boolean isPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the isFixo
     */
    public boolean isIsFixo() {
        return isFixo;
    }

    /**
     * @param isFixo the isFixo to set
     */
    public void setIsFixo(boolean isFixo) {
        this.isFixo = isFixo;
    }
}
