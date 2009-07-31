/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import javax.swing.JLabel;

/**
 *
 * @author higorlandia
 */
public class GerenciadorBarraStatus extends GerenciadorAbstrato {

    private JLabel labelUsuarioAtivo;
    private JLabel labelMensagens;
    private JLabel labelAvisos;
    private String usuarioAtivo;
    private String mensagens;
    private String avisos;

    /**
     * @return the labelUsuarioAtivo
     */
    public JLabel getLabelUsuarioAtivo() {
        return labelUsuarioAtivo;
    }

    /**
     * @param labelUsuarioAtivo the labelUsuarioAtivo to set
     */
    public void setLabelUsuarioAtivo(JLabel labelUsuarioAtivo) {
        this.labelUsuarioAtivo = labelUsuarioAtivo;
    }

    /**
     * @return the labelMensagens
     */
    public JLabel getLabelMensagens() {
        return labelMensagens;
    }

    /**
     * @param labelMensagens the labelMensagens to set
     */
    public void setLabelMensagens(JLabel labelMensagens) {
        this.labelMensagens = labelMensagens;
    }

    /**
     * @return the labelAvisos
     */
    public JLabel getLabelAvisos() {
        return labelAvisos;
    }

    /**
     * @param labelAvisos the labelAvisos to set
     */
    public void setLabelAvisos(JLabel labelAvisos) {
        this.labelAvisos = labelAvisos;
    }

    /**
     * @return the usuarioAtivo
     */
    public String getUsuarioAtivo() {
        return usuarioAtivo;
    }

    /**
     * @param usuarioAtivo the usuarioAtivo to set
     */
    public void setUsuarioAtivo(String usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
        this.getLabelUsuarioAtivo().setText(usuarioAtivo);
    }

    /**
     * @return the mensagens
     */
    public String getMensagens() {
        return mensagens;
    }

    /**
     * @param mensagens the mensagens to set
     */
    public void setMensagens(String mensagens) {
        this.mensagens = mensagens;
        this.getLabelMensagens().setText(mensagens);
    }

    /**
     * @return the avisos
     */
    public String getAvisos() {
        return avisos;
    }

    /**
     * @param avisos the avisos to set
     */
    public void setAvisos(String avisos) {
        this.avisos = avisos;
        this.getLabelAvisos().setText(avisos);
    }
}
