/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view.dataset;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author epbt
 */
public class Principal {

    private JFrame mainWindow;
    private String tituloAplicacao;
    private JTabbedPane tabPaneMovimentacao;
    private String tituloPaneCaixa;

    public Principal(JFrame mainWindow, JTabbedPane tabPaneMovimentacao) {
        this.mainWindow = mainWindow;
        this.tabPaneMovimentacao = tabPaneMovimentacao;
        this.tituloAplicacao = "PFinance - Personal Finance";
        this.tituloPaneCaixa = "Movimentacao";
    }

    /**
     * @return the mainWindow
     */
    public JFrame getMainWindow() {
        return mainWindow;
    }

    public void inicializa(){
        this.atualizaTitulo("Sem Nome");
        this.atualizaPaneCaixa("Selecione o Mes de Referencia");
    }

    /**
     * @param mainWindow the mainWindow to set
     */
    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void atualizaTitulo(String titulo) {
        String titulo_aux = this.tituloAplicacao.concat(" - ").concat(titulo);
        this.mainWindow.setTitle(titulo_aux);
    }

    public void atualizaPaneCaixa(String titulo){
        String titulo_aux = this.tituloPaneCaixa.concat(" - ").concat(titulo);
        titulo_aux.toUpperCase();
        this.tabPaneMovimentacao.setTitleAt(0, titulo_aux);
    }
}
