/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bins;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author MARCOS
 */
public class DataBins {
    GregorianCalendar gc = new GregorianCalendar();
       public String dia = String.valueOf(gc.get(GregorianCalendar.DAY_OF_MONTH));
       public String mes = String.valueOf(gc.get(GregorianCalendar.MONTH) + 1);
       public String ano = String.valueOf(gc.get(GregorianCalendar.YEAR));
       public String hora = String.valueOf(gc.get(GregorianCalendar.HOUR_OF_DAY));
       public String minuto = String.valueOf(gc.get(GregorianCalendar.MINUTE));
       public String segundo = String.valueOf(gc.get(GregorianCalendar.SECOND));

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
   
    public String getDia() { 
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
     private String zeromes(String mes){//acresenta zero se o mes for menor de 9
        int m=Integer.parseInt(mes);
        if(m<10){
            return "0"+String.valueOf(m);
        }
        return mes;
    }
    public String getMes() {
        return zeromes(mes);
    }
    public String getMesVenc(){
        return MesVenc();
    }
    private String MesVenc(){//acresenta um dia a mais no mes
        int m=Integer.parseInt(mes)+1;
        if(m<10){
            return "0"+String.valueOf(m);
        }
        return String.valueOf(m); 
    }
    
    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

       
}
