package es.ufv.TurismoComunidades;

import java.util.Calendar;
import java.util.Date;

public class Periodo {

    private Date fecha_inicio;
    private Date fecha_fin;
    private String periodo;

    public Periodo(Date fecha_inicio, Date fecha_fin, String periodo) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.periodo = periodo;
    }

    public Periodo(String periodo) {
        this.periodo = periodo;
        String [] partes = periodo.split("M");
        int anio = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        this.fecha_inicio = Periodo.getFirstDayOfMonth(anio,mes);
        this.fecha_fin = Periodo.getLastDayOfMonth(anio,mes);


    }

    public boolean fechaEnPeriodo (Date date){
        return (date.after(fecha_inicio) && date.before(fecha_fin) || date.equals(fecha_inicio) || date.equals(fecha_fin));
    }

    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    public static Date getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return calendar.getTime();
    }



    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


}
