package pfinance.model.entity;
// Generated 12/07/2009 14:06:10 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * DocumentoUsuario generated by hbm2java
 */
public class DocumentoUsuario  implements java.io.Serializable {


     private Integer id;
     private Usuario usuario;
     private Documento documento;
     private String tipoAcesso;
     private Date dataInicio;
     private Date dataFim;

    public DocumentoUsuario() {
    }

	
    public DocumentoUsuario(Usuario usuario, Documento documento, String tipoAcesso) {
        this.usuario = usuario;
        this.documento = documento;
        this.tipoAcesso = tipoAcesso;
    }
    public DocumentoUsuario(Usuario usuario, Documento documento, String tipoAcesso, Date dataInicio, Date dataFim) {
       this.usuario = usuario;
       this.documento = documento;
       this.tipoAcesso = tipoAcesso;
       this.dataInicio = dataInicio;
       this.dataFim = dataFim;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Documento getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
    public String getTipoAcesso() {
        return this.tipoAcesso;
    }
    
    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }
    public Date getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return this.dataFim;
    }
    
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }




}


