/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
import pfinance.view.PopupMenuArvore;

/**
 *
 * @author higorlandia
 */
public class EventosArvoreObjetos {

    private JTree arvoreObjetos;
    private PopupMenuArvore menuArvore;

    public EventosArvoreObjetos(JTree arvore) {
        this.arvoreObjetos = arvore;
        menuArvore = new PopupMenuArvore();
    }

    public void defineArvoreObjetos(JTree arvore) {
        this.arvoreObjetos = arvore;
        this.menuArvore.defineArvore(arvoreObjetos);
    }

    public void registraEventosArvore() {
        MouseListener ml = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int selRow = arvoreObjetos.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = arvoreObjetos.getPathForLocation(e.getX(), e.getY());
                if (selRow != -1) {
                    if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
                        invocaMenuArvore(selRow, selPath);
                    } else if (e.getClickCount() == 2) {
                        editarItemArvore(selRow, selPath);
                    }
                }
            }
        };
        arvoreObjetos.addMouseListener(ml);
    }

    private void invocaMenuArvore(int selRow, TreePath selPath) {
        String onde = "MENU click [";
        onde.concat(String.valueOf(selRow));
        onde.concat("]");
        menuArvore.show();
    }

    private void editarItemArvore(int selRow, TreePath selPath) {
        String onde = "ITEM click [";
        onde.concat(String.valueOf(selRow));
        onde.concat("]");
    }
}
