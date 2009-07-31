/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pfinance.model.dataset;

import pfinance.model.entity.MesRef;
import mark.utils.el.annotation.Resolvable;
import test.IntFormatter;


/**
 *
 * @author higor
 */
public class DSMesRef extends MesRef{

    @Resolvable(colName = "Nome")
    private String nome;
    @Resolvable(colName = "Ano", formatter = IntFormatter.class)
    private int ano;
}
