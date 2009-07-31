/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import javax.swing.JFrame;

/**
 *
 * @author higorlandia
 */
public abstract class GerenciadorAbstrato {
    private JFrame topLevelWidget;

    /**
     * @return the topLevelWidget
     */
    public JFrame getTopLevelWidget() {
        return topLevelWidget;
    }

    /**
     * @param topLevelWidget the topLevelWidget to set
     */
    public void setTopLevelWidget(JFrame topLevelWidget) {
        this.topLevelWidget = topLevelWidget;
    }
    
}

