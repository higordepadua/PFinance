/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import org.hibernate.criterion.Restrictions;
import pfinance.model.dao.DaoGenerico;
import pfinance.model.entity.Documento;
import pfinance.view.FormDocumento;
import pfinance.view.FormSelecaoDocumento;

/**
 *
 * @author higorlandia
 */
public class GerenciadorDocumento extends GerenciadorAbstrato {

    GerenciadorSessao gerSessao;

    public GerenciadorDocumento() {
        gerSessao = FabricaGerenciador.getInstancia().get(GerenciadorSessao.class);
    }

    public boolean formDocumento(Documento doc) {
        FormDocumento formDoc = new FormDocumento(this.getTopLevelWidget(), true);
        formDoc.setLocationRelativeTo(null);
        formDoc.init();

        if (doc != null) {
            formDoc.editar(doc);
        }

        formDoc.setVisible(true);

        if (formDoc.isModificado()) {
            this.setDocumentoAtivo(formDoc.getDocumentoCorrente());
            this.setDocumentoAtivo(formDoc.getDocumentoCorrente());
            DaoGenerico<Documento> docDao = new DaoGenerico<Documento>(Documento.class);
            docDao.saveOrUpdate(formDoc.getDocumentoCorrente());
            docDao.getSession().close();
            return true;
        } else {
            return false;
        }
    }

    public boolean novoDocumento() {
        return this.formDocumento(null);
    }

    public boolean editarDocumento(Documento doc) {
        return this.formDocumento(doc);
    }

    public void excluirDocumento(Documento doc) {
        DaoGenerico<Documento> docDao = new DaoGenerico<Documento>(Documento.class);
        docDao.delete(doc);
    }

    public boolean selecionaDocumento() {
        FormSelecaoDocumento selecaoDoc = new FormSelecaoDocumento(this.getTopLevelWidget(), true);
        selecaoDoc.setLocationRelativeTo(null);
        selecaoDoc.init();
        selecaoDoc.setVisible(true);
        if (selecaoDoc.isDocumentoSelecionado()) {
            this.setDocumentoAtivo(selecaoDoc.getDocumentoAtivo());
            return true;
        } else {
            return false;
        }
    }

    public Documento getDocByName(String nome) {
        DaoGenerico<Documento> docDao = new DaoGenerico<Documento>(Documento.class);
        return docDao.get(Restrictions.eq("nome", nome));
    }

    public void setDocumentoAtivo(Documento doc) {
        this.gerSessao.setDocumentoAtivo(doc);
    }
}
