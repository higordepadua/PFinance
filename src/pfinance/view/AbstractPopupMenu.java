/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author higorlandia
 */
//imports
public abstract class AbstractPopupMenu extends JPanel implements MouseListener {

    private JPopupMenu jPopupMenu;
    private Random random = new Random();

    public AbstractPopupMenu() {



        setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));



        jPopupMenu = new JPopupMenu();



        String[] menuItems = getMenuItems();

        for (int i = 0; i < menuItems.length; i++) {

            JMenuItem menuItem = new JMenuItem(menuItems[i]);

            jPopupMenu.add(menuItem);

        }



        super.addMouseListener(this);

        super.setPreferredSize(new Dimension(100, 300));

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent event) {

        if (event.getButton() == MouseEvent.BUTTON3) {

            jPopupMenu.show(this, event.getX(), event.getY());

        }

    }

    public abstract String[] getMenuItems();
}
