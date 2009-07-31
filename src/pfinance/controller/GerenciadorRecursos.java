/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.controller;

import java.util.HashMap;

/**
 *
 * @author higorlandia
 */
public class GerenciadorRecursos extends GerenciadorAbstrato {

    private HashMap recursosMap;

    public GerenciadorRecursos() {
        recursosMap = new HashMap();
    }

    private HashMap getMap() {
        return recursosMap;
    }

    public <T extends Object> T lookup(String id) {
        if (this.getMap().containsKey(id)) {
            return (T) this.getMap().get(id);
        }
        return null;
    }

    public <T extends Object> void register(String id, T obj) {
        if (!this.getMap().containsKey(id)) {
            this.getMap().put(id, obj);
        }
    }
}
