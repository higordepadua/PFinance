package pfinance.model.entity;
// Generated 12/07/2009 14:06:10 by Hibernate Tools 3.2.1.GA

import mark.utils.el.annotation.Resolvable;
import test.IntFormatter;

import java.util.HashSet;
import java.util.Set;

/**
 * MesRef generated by hbm2java
 */
public class MesRef  implements java.io.Serializable {


     private Integer id;
     @Resolvable(colName = "Nome")
     private String nome;
     private String mnem;
     private int numero;
     @Resolvable(colName = "Ano", formatter = IntFormatter.class)
     private int ano;
     private Set caixasForMesRefId = new HashSet(0);
     private Set caixasForMesRefAnteriorId = new HashSet(0);

    public MesRef() {
    }

	
    public MesRef(String nome, String mnem, int numero, int ano) {
        this.nome = nome;
        this.mnem = mnem;
        this.numero = numero;
        this.ano = ano;
    }
    public MesRef(String nome, String mnem, int numero, int ano, Set caixasForMesRefId, Set caixasForMesRefAnteriorId) {
       this.nome = nome;
       this.mnem = mnem;
       this.numero = numero;
       this.ano = ano;
       this.caixasForMesRefId = caixasForMesRefId;
       this.caixasForMesRefAnteriorId = caixasForMesRefAnteriorId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMnem() {
        return this.mnem;
    }
    
    public void setMnem(String mnem) {
        this.mnem = mnem;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getAno() {
        return this.ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    public Set getCaixasForMesRefId() {
        return this.caixasForMesRefId;
    }
    
    public void setCaixasForMesRefId(Set caixasForMesRefId) {
        this.caixasForMesRefId = caixasForMesRefId;
    }
    public Set getCaixasForMesRefAnteriorId() {
        return this.caixasForMesRefAnteriorId;
    }
    
    public void setCaixasForMesRefAnteriorId(Set caixasForMesRefAnteriorId) {
        this.caixasForMesRefAnteriorId = caixasForMesRefAnteriorId;
    }

    @Override
    public String toString(){
        return this.getNome();
    }
}


