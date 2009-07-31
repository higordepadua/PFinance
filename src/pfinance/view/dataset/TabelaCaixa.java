/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view.dataset;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorCaixa;
import pfinance.model.entity.Caixa;

/**
 *
 * @author epbt
 */
public class TabelaCaixa {

    private JTable tabela;
    private JTextField campoTotalPrevistoMes;
    private JTextField campoTotalRealizadoMes;
    private JTextField campoSaldoAnterior;
    private JTextField campoSaldoAtual;
    private JTextField campoCredito;
    private JTextField campoDebito;
    private GerenciadorCaixa gerCaixa;

    public TabelaCaixa() {
    }

    public void inicializa() {
        this.getCampoTotalPrevistoMes().setText("");
        this.getCampoTotalRealizadoMes().setText("");
        this.getCampoSaldoAnterior().setText("");
        this.getCampoSaldoAtual().setText("");
        this.getCampoCredito().setText("");
        this.getCampoDebito().setText("");
        this.habilitaCampos(false);
    }

    public void habilitaCampos(boolean habilita) {
        this.getCampoTotalPrevistoMes().setEnabled(habilita);
        this.getCampoTotalRealizadoMes().setEnabled(habilita);
        this.getCampoSaldoAnterior().setEnabled(habilita);
        this.getCampoSaldoAtual().setEnabled(habilita);
        this.getCampoCredito().setEnabled(habilita);
        this.getCampoDebito().setEnabled(habilita);
    }

    public void create() {
        this.gerCaixa = FabricaGerenciador.getInstancia().get(GerenciadorCaixa.class);
        this.tabela.setModel(new DefaultTableModel(this.getData(), this.getHeaders()));
    }

    private Vector<String> getHeaders() {
        Vector<String> tableHeaders = new Vector<String>();
        tableHeaders.add("Descricao");
        tableHeaders.add("Entrada");
        tableHeaders.add("Pagamento");
        tableHeaders.add("Previsto");
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

    /**
     * @return the campoTotalPrevistoMes
     */
    public JTextField getCampoTotalPrevistoMes() {
        return campoTotalPrevistoMes;
    }

    /**
     * @param campoTotalPrevistoMes the campoTotalPrevistoMes to set
     */
    public void setCampoTotalPrevistoMes(JTextField campoTotalPrevistoMes) {
        this.campoTotalPrevistoMes = campoTotalPrevistoMes;
    }

    /**
     * @return the campoTotalRealizadoMes
     */
    public JTextField getCampoTotalRealizadoMes() {
        return campoTotalRealizadoMes;
    }

    /**
     * @param campoTotalRealizadoMes the campoTotalRealizadoMes to set
     */
    public void setCampoTotalRealizadoMes(JTextField campoTotalRealizadoMes) {
        this.campoTotalRealizadoMes = campoTotalRealizadoMes;
    }

    /**
     * @return the campoSaldoAnterior
     */
    public JTextField getCampoSaldoAnterior() {
        return campoSaldoAnterior;
    }

    /**
     * @param campoSaldoAnterior the campoSaldoAnterior to set
     */
    public void setCampoSaldoAnterior(JTextField campoSaldoAnterior) {
        this.campoSaldoAnterior = campoSaldoAnterior;
    }

    /**
     * @return the campoSaldoAtual
     */
    public JTextField getCampoSaldoAtual() {
        return campoSaldoAtual;
    }

    /**
     * @param campoSaldoAtual the campoSaldoAtual to set
     */
    public void setCampoSaldoAtual(JTextField campoSaldoAtual) {
        this.campoSaldoAtual = campoSaldoAtual;
    }

    /**
     * @return the campoCredito
     */
    public JTextField getCampoCredito() {
        return campoCredito;
    }

    /**
     * @param campoCredito the campoCredito to set
     */
    public void setCampoCredito(JTextField campoCredito) {
        this.campoCredito = campoCredito;
    }

    /**
     * @return the campoDebito
     */
    public JTextField getCampoDebito() {
        return campoDebito;
    }

    /**
     * @param campoDebito the campoDebito to set
     */
    public void setCampoDebito(JTextField campoDebito) {
        this.campoDebito = campoDebito;
    }
}
