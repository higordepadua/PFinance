/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.model.dao;

import pfinance.controller.*;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import pfinance.model.entity.DocumentoUsuario;
import pfinance.model.entity.Usuario;

/**
 *
 * @author higorlandia
 */
public class ListagemDocumentoModelo {

    private JList listagem;
    private Usuario usuario;

    public ListagemDocumentoModelo(JList listagem) {
        this.listagem = listagem;
        this.usuario = ((GerenciadorSessao)FabricaGerenciador.getInstancia().get(GerenciadorSessao.class)).getUsuarioAtivo();
    }

    public void create() {
        DefaultListModel model = new DefaultListModel();
        Set setDocUser = usuario.getDocumentoUsuarios();
        int i = 0;
        Iterator it = setDocUser.iterator();
        while (it.hasNext()) {
            DocumentoUsuario element = (DocumentoUsuario) it.next();
            model.add(i, element.getDocumento().getNome());
            i++;
        }
        listagem.setModel(model);
    }
}
