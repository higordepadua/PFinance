/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfinance.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;

/**
 *
 * @author higor
 */
public class Utils {

    static final java.text.DecimalFormat moneyFormatter= new java.text.DecimalFormat("#,###,###.00");
    static final DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    static final Date curDate = new Date(System.currentTimeMillis());
    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou nula,
     * retorna null - para facilitar em casos onde formulários podem ter campos
     * de datas vazios.
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static Date formataData(String data){
        if (data == null || data.equals("")) {
            return null;
        }

        Date datef = null;
        try {
            datef = (java.util.Date) dateFormatter.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datef;
    }
    public static String formataData(Date data){
        if(data == null)
            return "";
        return dateFormatter.format(data);
    }

    public static void campoDinheiro(JFormattedTextField field) {        
        javax.swing.text.NumberFormatter numFormatter = new javax.swing.text.NumberFormatter(moneyFormatter);
        numFormatter.setFormat(moneyFormatter);
        numFormatter.setAllowsInvalid(false);
        field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(numFormatter));
        field.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
    }

    public static double formataDinheiro(String valor){
        double retorno = 0.0;
        try {
            retorno = (moneyFormatter.parse(valor)).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public static String formataDinheiro(double valor){
        return moneyFormatter.format(valor);
    }

    public static Date dataAtual(){
        return curDate;
    }
}
