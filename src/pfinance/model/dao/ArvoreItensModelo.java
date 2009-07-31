/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.model.dao;

import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorObjetos;
import pfinance.model.entity.Categoria;
import pfinance.model.entity.TipoConta;

/**
 *
 * @author higorlandia
 */
public class ArvoreItensModelo {

    private JTree tree;
    private GerenciadorObjetos gerObjetos;

    public ArvoreItensModelo(JTree tree) {
        this.tree = tree;
        this.gerObjetos = FabricaGerenciador.getInstancia().get(GerenciadorObjetos.class);
    }

    public void create(){
        this.criaArvoreItens();
    }

    private void criaArvoreItens() {
        DefaultMutableTreeNode treeNodeRoot = new DefaultMutableTreeNode("Itens");
        DefaultMutableTreeNode treeNodeCategorias = new DefaultMutableTreeNode("Categorias");
        this.criaNoCategorias(treeNodeCategorias);
        DefaultMutableTreeNode treeNodeTiposContas = new DefaultMutableTreeNode("Tipos de Contas");
        DefaultMutableTreeNode treeNodeDebitos = new DefaultMutableTreeNode("Debitos");
        DefaultMutableTreeNode treeNodeCreditos = new DefaultMutableTreeNode("Creditos");
        treeNodeTiposContas.add(treeNodeDebitos);
        this.criaNoTiposContas(treeNodeDebitos, "D");
        treeNodeTiposContas.add(treeNodeCreditos);
        this.criaNoTiposContas(treeNodeCreditos, "C");
        treeNodeRoot.add(treeNodeCategorias);
        treeNodeRoot.add(treeNodeTiposContas);
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNodeRoot));
    }

    private void criaNoCategorias(DefaultMutableTreeNode pai) {
        DefaultMutableTreeNode treeNode;
        List<Categoria> gList = this.gerObjetos.getCategorias();
        for (Categoria obj : gList) {
            treeNode = new DefaultMutableTreeNode(obj.getDescricao());
            pai.add(treeNode);
        }
    }

    private void criaNoTiposContas(DefaultMutableTreeNode pai, String opTipo) {
        DefaultMutableTreeNode treeNode;
        List<TipoConta> gList = this.gerObjetos.getTiposConta();
        for (TipoConta obj : gList) {
            if (obj.getTipoOperacao().equals(opTipo)) {
                treeNode = new DefaultMutableTreeNode(obj.getDescricao());
                pai.add(treeNode);
            }
        }
    }

}
