/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;

/**
 *
 * @author higorlandia
 */
/*public class PopupMenuArvore extends AbstractPopupMenu{

public String[] getMenuItems() {

return new String[]{

"Amarelo", "Azul", "Branco", "Preto", "Vermelho"

};

}

}*/
public class PopupMenuArvore implements ActionListener {

    private JTree arvoreObjetos;
    private boolean valido;

    public PopupMenuArvore() {
        this.valido = false;
    }

    public void defineArvore(JTree arvoreObjetos) {
        this.arvoreObjetos = arvoreObjetos;
        this.valido = true;
    }

    public void show() {
        if (!this.valido) {
            return;
        }
        //JOptionPane.showMessageDialog(this.getTopLevelWidget(), onde);
        final JPopupMenu menu = new JPopupMenu();

        // Cria e adiciona um menu
        JMenuItem item1 = new JMenuItem("Editar");
        item1.addActionListener(this);
        menu.add(item1);

        JMenuItem item2 = new JMenuItem("Excluir");
        item2.addActionListener(this);
        menu.add(item2);


        // Configura o componente para apresentar o menu popup
        arvoreObjetos.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    menu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }

            public void mouseReleased(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    menu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        /*  String acao = ((JMenuItem) e.getSource()).getText();
        if (acao.equals("Recortar")) {
        output.cut();
        } else if (acao.equals("Copiar")) {
        output.copy();
        } else {
        output.paste();
        }*/
    }
}
