/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pfinance.view.dataset;

import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import pfinance.controller.FabricaGerenciador;
import pfinance.controller.GerenciadorSessao;
import pfinance.model.entity.DocumentoUsuario;
import pfinance.model.entity.Usuario;

/**
 *
 * @author epbt
 */
public class ListagemDocumentos {
    private JList listagem;
    private Usuario usuario;

    public ListagemDocumentos(JList listagem) {
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
