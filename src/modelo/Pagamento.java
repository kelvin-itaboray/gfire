/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Kelvin
 */
public class Pagamento {
    private int idPagamento;
    private int idUsuario;
    private int idConta;
    private boolean statusP;

    /**
     * @return the idPagamento
     */
    public int getIdPagamento() {
        return idPagamento;
    }

    /**
     * @param idPagamento the idPagamento to set
     */
    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     * @return the status
     */
    public boolean isStatusP() {
        return statusP;
    }

    /**
     * @param statusP the status to set
     */
    public void setStatusP(boolean statusP) {
        this.statusP = statusP;
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
}
