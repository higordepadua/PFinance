/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import java.util.HashMap;

/*public abstract class DAOFactory<DAO extends BaseDAO> {
public DAO getCustomerDAO();
public static <DAO extends BaseDAO> DAOFactory<DAO> getInstance(Class<DAO> typeToken){
// instantiate the the proper factory by using the typeToken.
if(system.getProperty("allowtest").equals("yes")) {
return new TestDAOFactory();
}
else return new ProdDAOFactory();
 */
/**
 *
 * @author higorlandia
 */
public class FabricaGerenciador {

    private static final FabricaGerenciador s_instancia = new FabricaGerenciador();
    private HashMap mapGerenciadores;

    private FabricaGerenciador() {
        mapGerenciadores = new HashMap();
    }

    public static FabricaGerenciador getInstancia() {
        return s_instancia;
    }

    private HashMap getMap() {
        return mapGerenciadores;
    }

    public <T extends GerenciadorAbstrato> T get(Class<T> classId) {
        try {
            if (this.getMap().containsKey(classId)) {
                return (T) this.getMap().get(classId);
            } else {
                T obj = (T) classId.newInstance();
                this.getMap().put(classId, obj);
                return (T) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
