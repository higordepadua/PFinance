/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.model.dao;

import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorObjetos;
import pfinance.model.entity.MesRef;

/**
 *
 * @author higorlandia
 */
public class TabelaMesRefModelo {

    private JTable table;
    private GerenciadorObjetos gerObjetos;

    public TabelaMesRefModelo(JTable table) {
        this.table = table;
        this.gerObjetos = FabricaGerenciador.getInstancia().get(GerenciadorObjetos.class);
    }

    public void create() {
        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Mes");
        tableHeaders.add("Ano");

        List<MesRef> gList = this.gerObjetos.getMesesRef();
        Vector tableData = new Vector();
        for (MesRef obj : gList) {
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(obj.getNome());
            oneRow.add(obj.getAno());
            tableData.add(oneRow);
        }
        table.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
}
