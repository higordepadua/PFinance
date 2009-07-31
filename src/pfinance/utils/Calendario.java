/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.utils;

import com.theotherbell.ui.DatePicker;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *
 * @author higor
 */
public class Calendario extends JDialog {

    private DatePicker datePicker;

    public Calendario(JFrame parent, boolean modal) {
        super(parent, modal);
        this.datePicker = new DatePicker();
        initComponents();
    }

    private void initComponents() {
        this.datePicker.setHideOnSelect(true);
        this.getContentPane().add(this.datePicker);
        this.pack();
    }
}
