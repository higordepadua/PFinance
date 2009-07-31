/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view.dataset;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorObjetos;
import pfinance.controller.GerenciadorSessao;
import pfinance.model.entity.MesRef;

/**
 *
 * @author epbt
 */
public class TabelaMesRef implements MouseListener{

    private JTable tabela;
    private ObjectTableMesRef objectModel;
    private GerenciadorObjetos gerObjetos;
    private GerenciadorSessao gerSessao;

    public TabelaMesRef(JTable tabela) {
        this.tabela = tabela;

    }

    public void create() {
        this.gerObjetos = FabricaGerenciador.getInstancia().get(GerenciadorObjetos.class);
        this.gerSessao = FabricaGerenciador.getInstancia().get(GerenciadorSessao.class);
        List<MesRef> gList = this.gerObjetos.getMesesRef();

        this.objectModel = new ObjectTableMesRef(gList);
        this.tabela.setModel(objectModel.getModel());
        this.tabela.addMouseListener(this);
    }

    /**
     * @return the tabela
     */
    public JTable getTabela() {
        return tabela;
    }

    /**
     * @param tabela the tabela to set
     */
    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            int row = this.tabela.rowAtPoint(e.getPoint());
            MesRef mesSel = this.objectModel.getModel().getValue(row);
            this.gerSessao.setMesRefAtivo(mesSel);
            this.gerSessao.atualizaTabelaCaixa();
        }
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
}
