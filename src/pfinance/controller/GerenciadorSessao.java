/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import pfinance.model.entity.Documento;
import pfinance.model.entity.MesRef;
import pfinance.model.entity.Usuario;
import pfinance.view.dataset.ArvoreObjetos;
import pfinance.view.dataset.BarraStatus;
import pfinance.view.dataset.Principal;
import pfinance.view.dataset.TabelaMesRef;
import pfinance.view.dataset.TabelaCaixa;

/**
 *
 * @author higorlandia
 */
public class GerenciadorSessao extends GerenciadorAbstrato {

    private Usuario usuarioAtivo;
    private Documento documentoAtivo;
    private MesRef mesRefAtivo;
    private boolean sessaoValida;
    private boolean documentoSelecionado;
    private boolean usuarioSelecionado;
    private boolean mesSelecionado;
    private BarraStatus barraStatus;
    private ArvoreObjetos arvoreObjetos;
    private TabelaCaixa tabelaCaixa;
    private TabelaMesRef tabelaMesRef;
    private Principal principal;

    public GerenciadorSessao() {
        this.sessaoValida = false;
        this.documentoSelecionado = false;
        this.usuarioSelecionado = false;
        this.mesSelecionado = false;
        this.barraStatus = null;

    }

    public void createSession(Usuario usuario) {
        this.setUsuarioAtivo(usuario);
        /*  DaoGenerico<DocumentoUsuario> docuserDao = new DaoGenerico<DocumentoUsuario>(DocumentoUsuario.class);
        Criteria c = docuserDao.getSession().createCriteria(DocumentoUsuario.class);
        c.add(Restrictions.eq("usuario_id", usuario.getId()));
        List<DocumentoUsuario> docUserList = c.list();
        for (DocumentoUsuario du : docUserList) {
        if(du.getDocumento())
        }
        c.add(Restrictions.eq("usuario_id", usuario.getId()));*/
    }

    public void inicializa() {
        this.barraStatus.inicializa();
        this.principal.inicializa();
    }

    public void atualizarBarraStatus() {
        if (this.possuiUsuarioSelecionado()) {
            this.barraStatus.setUsuarioAtivo(this.getUsuarioAtivo().getUsuario());
        }
    }

    public void atualizaTitulo() {
        if (this.possuiDocumentoSelecionado()) {
            String titulo = this.getDocumentoAtivo().getNome();
            this.getPrincipal().atualizaTitulo(titulo);
        }
    }

    public void atualizaArvoreObjetos() {
        if (this.possuiDocumentoSelecionado()) {
            this.getArvoreObjetos().create();
        }
    }

    public void atualizaTabelaMesRef() {
        if (this.possuiDocumentoSelecionado()) {
            this.getTabelaMesRef().create();
        }
    }

    public void atualizaTabelaCaixa() {
        if (this.possuiSessaoValida()) {
            this.getTabelaCaixa().create();
        }
    }

    public void atualizaSessao() {
        this.atualizaTitulo();
        this.atualizaArvoreObjetos();
        this.atualizaTabelaMesRef();
        this.atualizaTabelaCaixa();
        this.atualizarBarraStatus();
    }

    /**
     * @return the usuarioAtivo
     */
    public synchronized Usuario getUsuarioAtivo() {
        return usuarioAtivo;
    }

    /**
     * @param usuarioAtivo the usuarioAtivo to set
     */
    public synchronized void setUsuarioAtivo(Usuario usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
        this.setUsuarioSelecionado(true);
    }

    /**
     * @return the documentoAtivo
     */
    public synchronized Documento getDocumentoAtivo() {
        return this.documentoAtivo;
    }

    /**
     * @param documentoAtivo the documentoAtivo to set
     */
    public synchronized void setDocumentoAtivo(Documento documentoAtivo) {
        this.documentoAtivo = documentoAtivo;
        this.setDocumentoSelecionado(true);
        this.setSessaoValida(this.possuiMesSelecionado());
    }

    /**
     * @return the mesRefAtivo
     */
    public synchronized MesRef getMesRefAtivo() {
        return mesRefAtivo;
    }

    /**
     * @param mesRefAtivo the mesRefAtivo to set
     */
    public synchronized void setMesRefAtivo(MesRef mesRefAtivo) {
        this.mesRefAtivo = mesRefAtivo;
        this.principal.atualizaPaneCaixa(mesRefAtivo.getNome());
        this.setMesSelecionado(true);
        this.setSessaoValida(this.possuiDocumentoSelecionado());
    }

    /**
     * @return the sessaoValida
     */
    public synchronized boolean possuiSessaoValida() {
        return sessaoValida;
    }

    /**
     * @param sessaoValida the sessaoValida to set
     */
    public synchronized void setSessaoValida(boolean sessaoValida) {
        this.sessaoValida = sessaoValida;
    }

    /**
     * @return the possuiDocumentos
     */
    public synchronized boolean possuiDocumentoSelecionado() {
        return documentoSelecionado;
    }

    /**
     * @param possuiDocumentos the possuiDocumentos to set
     */
    public synchronized void setDocumentoSelecionado(boolean documentoSelecionado) {
        this.documentoSelecionado = documentoSelecionado;
    }

    /**
     * @return the usuarioSelecionado
     */
    public boolean possuiUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    /**
     * @param usuarioSelecionado the usuarioSelecionado to set
     */
    public void setUsuarioSelecionado(boolean usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    /**
     * @return the mesSelecionado
     */
    public boolean possuiMesSelecionado() {
        return mesSelecionado;
    }

    /**
     * @param mesSelecionado the mesSelecionado to set
     */
    public void setMesSelecionado(boolean mesSelecionado) {
        this.mesSelecionado = mesSelecionado;
    }

    /**
     * @return the barraStatus
     */
    public BarraStatus getBarraStatus() {
        return barraStatus;
    }

    /**
     * @param barraStatus the barraStatus to set
     */
    public void setBarraStatus(BarraStatus barraStatus) {
        this.barraStatus = barraStatus;
    }

    /**
     * @return the arvoreObjetos
     */
    public ArvoreObjetos getArvoreObjetos() {
        return arvoreObjetos;
    }

    /**
     * @param arvoreObjetos the arvoreObjetos to set
     */
    public void setArvoreObjetos(ArvoreObjetos arvoreObjetos) {
        this.arvoreObjetos = arvoreObjetos;
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

    /**
     * @return the tabelaMesRef
     */
    public TabelaMesRef getTabelaMesRef() {
        return tabelaMesRef;
    }

    /**
     * @param tabelaMesRef the tabelaMesRef to set
     */
    public void setTabelaMesRef(TabelaMesRef tabelaMesRef) {
        this.tabelaMesRef = tabelaMesRef;
    }

    /**
     * @return the principal
     */
    public Principal getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
