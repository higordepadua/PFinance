/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.model.dao;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorCaixa;
import pfinance.model.entity.Caixa;

/**
 *
 * @author higorlandia
 */
public class TabelaCaixaModelo {

    private JTable table;
    private GerenciadorCaixa gerCaixa;

    public TabelaCaixaModelo(JTable table) {
        this.table = table;
        this.gerCaixa = FabricaGerenciador.getInstancia().get(GerenciadorCaixa.class);
    }

    public void create() {
        table.setModel(new DefaultTableModel(this.getData(), this.getHeaders()));
    }

    private Vector<String> getHeaders() {
        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Descricao");
        tableHeaders.add("Entrada");
        tableHeaders.add("Pagamento");
        tableHeaders.add("Previsto.");
        tableHeaders.add("Realizado");
        tableHeaders.add("Operacao");
        /*tableHeaders.add("Alterar");
        tableHeaders.add("Excluir");
        tableHeaders.add("Copiar");
        tableHeaders.add("Pagar");*/
        return tableHeaders;
    }

    private Vector getData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Caixa> gList = this.gerCaixa.getItensCaixa();
        Vector tableData = new Vector();
        for (Caixa obj : gList) {
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(obj.getTipoConta().getDescricao());
            oneRow.add((obj.getDataInicio()!=null) ? sdf.format(obj.getDataInicio()) : null);
            oneRow.add((obj.getDataPagamento()!=null) ? sdf.format(obj.getDataPagamento()) : null);
            oneRow.add(nf.format(obj.getValorEsperado()));
            oneRow.add((obj.getValorPago()!=null) ? nf.format(obj.getValorPago()) : null);
            oneRow.add((obj.getTipoOperacao().equals("D")) ? "DEBITO" : "CREDITO");
            tableData.add(oneRow);
        }
        return tableData;
    }
}
