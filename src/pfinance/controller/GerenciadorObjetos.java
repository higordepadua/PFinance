/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import pfinance.model.dao.DaoGenerico;
import pfinance.model.entity.Categoria;
import pfinance.model.entity.MesRef;
import pfinance.model.entity.TipoConta;
import pfinance.view.FormCategoria;

/**
 *
 * @author higorlandia
 */
public class GerenciadorObjetos extends GerenciadorAbstrato {

    private GerenciadorSessao gerSessao;
    private GerenciadorRecursos gerRecursos;

    public GerenciadorObjetos() {
        gerSessao = FabricaGerenciador.getInstancia().get(GerenciadorSessao.class);
        gerRecursos = FabricaGerenciador.getInstancia().get(GerenciadorRecursos.class);
    }

    public List<TipoConta> getTiposConta() {
        DaoGenerico<TipoConta> gDao = new DaoGenerico<TipoConta>(TipoConta.class);
        List<TipoConta> lst = gDao.listAll();
        List<TipoConta> nlst = new ArrayList<TipoConta>();
        for (TipoConta tc : lst){
            if(tc.getDocumento() == null)
                nlst.add(tc);
        }
        Set<TipoConta> settc = gerSessao.getDocumentoAtivo().getTipoContas();
        nlst.addAll(settc);
        return nlst;
    }

    public List<Categoria> getCategorias() {
        DaoGenerico<Categoria> gDao = new DaoGenerico<Categoria>(Categoria.class);
        List<Categoria> gList = gDao.listAll();
        return gList;
    }

    public List<MesRef> getMesesRef() {
        DaoGenerico<MesRef> gDao = new DaoGenerico<MesRef>(MesRef.class);
        List<MesRef> gList = gDao.listAll();
        return gList;
    }


// formularios
    public boolean formCategoria(Categoria obj) {
        FormCategoria form = new FormCategoria(this.getTopLevelWidget(), true);
        form.setLocationRelativeTo(null);
        form.init();
        if (obj != null) {
            form.editar(obj);
        }
        form.setVisible(true);

        if (form.isModificado()) {
            DaoGenerico<Categoria> objDao = new DaoGenerico<Categoria>(Categoria.class);
            objDao.saveOrUpdate(form.getObjetoCorrente());
            objDao.getSession().close();
            return true;
        } else {
            return false;
        }
    }

    public boolean novaCategoria() {
        return this.formCategoria(null);
    }

    public boolean editarCategoria(Categoria obj) {
        return this.formCategoria(obj);
    }

    public void excluirCategoria(Categoria obj) {
        DaoGenerico<Categoria> objDao = new DaoGenerico<Categoria>(Categoria.class);
        objDao.delete(obj);
    }
}
