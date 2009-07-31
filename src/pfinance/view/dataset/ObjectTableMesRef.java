/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.view.dataset;

import java.util.List;
import mark.utils.el.annotation.AnnotationResolver;
import mark.utils.swing.table.ObjectTableModel;
import pfinance.model.entity.MesRef;

/**
 *
 * @author higor
 */
public class ObjectTableMesRef {

    private ObjectTableModel<MesRef> tableModel;
    private List<MesRef> dataList;

    public ObjectTableMesRef(List<MesRef> dataList) {
        this.dataList = dataList;
        AnnotationResolver resolver = new AnnotationResolver(MesRef.class);
        this.tableModel = new ObjectTableModel<MesRef>(resolver, "nome,ano");
        tableModel.setData(this.dataList);
    }

    public ObjectTableModel<MesRef> getModel(){
        return this.tableModel;
    }
}
