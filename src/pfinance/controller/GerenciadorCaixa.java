/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pfinance.model.dao.DaoGenerico;
import pfinance.model.entity.Caixa;
import pfinance.model.entity.MesRef;
import pfinance.view.FormLancamentoCaixa;
import pfinance.view.dataset.TabelaCaixa;

/**
 *
 * @author higorlandia
 */
public class GerenciadorCaixa extends GerenciadorAbstrato {

    private Double totalPrevistoMes;
    private Double totalRealizadoMes;
    private Double totalDebito;
    private Double totalCredito;
    private Double saldoAnterior;
    private Double saldoAtual;
    private List<Caixa> itensCaixa;
    private GerenciadorSessao gerSessao;
    private TabelaCaixa tabelaCaixa;

    public GerenciadorCaixa() {
        this.inicializa();
    }

    public void inicializa() {
        this.gerSessao = FabricaGerenciador.getInstancia().get(GerenciadorSessao.class);
        this.tabelaCaixa = this.gerSessao.getTabelaCaixa();
        this.itensCaixa = new ArrayList<Caixa>();
        this.tabelaCaixa.inicializa();
    }

    public void novoCaixa() {
        this.tabelaCaixa.inicializa();
        this.tabelaCaixa.habilitaCampos(true);
    }

    public void abrirCaixa() {
        this.tabelaCaixa.habilitaCampos(true);
    }

    /**
     * @return the totalPrevistoMes
     */
    public Double getTotalPrevistoMes() {
        return totalPrevistoMes;
    }

    /**
     * @param totalPrevistoMes the totalPrevistoMes to set
     */
    public void setTotalPrevistoMes(Double totalPrevistoMes) {
        this.totalPrevistoMes = totalPrevistoMes;
    }

    /**
     * @return the totalRealizadoMes
     */
    public Double getTotalRealizadoMes() {
        return totalRealizadoMes;
    }

    /**
     * @param totalRealizadoMes the totalRealizadoMes to set
     */
    public void setTotalRealizadoMes(Double totalRealizadoMes) {
        this.totalRealizadoMes = totalRealizadoMes;
    }

    /**
     * @return the totalDebito
     */
    public Double getTotalDebito() {
        return totalDebito;
    }

    /**
     * @param totalDebito the totalDebito to set
     */
    public void setTotalDebito(Double totalDebito) {
        this.totalDebito = totalDebito;
    }

    /**
     * @return the totalCredito
     */
    public Double getTotalCredito() {
        return totalCredito;
    }

    /**
     * @param totalCredito the totalCredito to set
     */
    public void setTotalCredito(Double totalCredito) {
        this.totalCredito = totalCredito;
    }

    /**
     * @return the saldoAnterior
     */
    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    /**
     * @param saldoAnterior the saldoAnterior to set
     */
    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    /**
     * @return the saldoAtual
     */
    public Double getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * @param saldoAtual the saldoAtual to set
     */
    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    /**
     * @return the itensCaixa
     */
    public List<Caixa> getItensCaixa() {
        itensCaixa.clear();
        if (this.gerSessao.possuiSessaoValida()) {
            Set<Caixa> cxDoc = this.gerSessao.getDocumentoAtivo().getCaixas();
            for (Caixa obj : cxDoc) {
                MesRef mesObj = obj.getMesRefByMesRefId();
                int id1 = obj.getMesRefByMesRefId().getId();
                int id2 = this.gerSessao.getMesRefAtivo().getId();
                if (mesObj == null || id1 == id2) {
                    itensCaixa.add(obj);
                }
            }
        }
        return itensCaixa;
    }

    /**
     * @return the itensCaixa
     */
    public MesRef getUltimoMesRef() {
        if (this.gerSessao.possuiDocumentoSelecionado()) {
            DaoGenerico<Caixa> dao = new DaoGenerico<Caixa>(Caixa.class);
            Criteria c = dao.getCriteria();
            c.add(Restrictions.eq("documento.id", this.gerSessao.getDocumentoAtivo().getId()));
            c.addOrder(Order.desc("mesRefByMesRefId.id"));
            if (!c.list().isEmpty()) {
                Caixa res = (Caixa) c.list().get(c.list().size() - 1);
                return res.getMesRefByMesRefId();
            }
        }
        return null;
    }

    /**
     * @param itensCaixa the itensCaixa to set
     */
    public void setItensCaixa(List<Caixa> itensCaixa) {
        this.itensCaixa = itensCaixa;
    }

    /**
     * @return the tabelaCaixa
     */
    public TabelaCaixa getTabelaCaixa() {
        return tabelaCaixa;
    }

    /**
     * @param tabelaCaixa the tabelaCaixa to set
     */
    public void setTabelaCaixa(TabelaCaixa tabelaCaixa) {
        this.tabelaCaixa = tabelaCaixa;
    }

    public boolean novoLancamento() {
        return this.formLancamento(null);
    }

    private boolean formLancamento(Caixa obj) {
        FormLancamentoCaixa form = new FormLancamentoCaixa(this.getTopLevelWidget(), true);
        form.setLocationRelativeTo(null);
        form.init();
        if (obj != null) {
            form.editar(obj);
        }
        form.setVisible(true);

        if (form.isModificado()) {
            DaoGenerico<Caixa> objDao = new DaoGenerico<Caixa>(Caixa.class);
            objDao.saveOrUpdate(form.getObjetoCorrente());
            objDao.getSession().close();
            return true;
        } else {
            return false;
        }
    }
}
