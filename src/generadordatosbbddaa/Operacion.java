/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordatosbbddaa;

import java.util.GregorianCalendar;

/**
 *
 * @author Urbano
 */
public class Operacion {
    
    int numeroOperacion;
    GregorianCalendar fecha;
    String hora;
    int numeroConsulta;
    int numeroColegiado;
    String area;
    int quirofano;
    String observaciones;

    public Operacion(int numeroOperacion, GregorianCalendar fecha, int numeroConsulta, int numeroColegiado, String area, String hora) {
        this.numeroOperacion = numeroOperacion;
        this.fecha = fecha;
        this.numeroConsulta = numeroConsulta;
        this.numeroColegiado = numeroColegiado;
        this.area = area;
        this.quirofano = (int) (Math.random() * 25) + 1;
        this.observaciones = "Observaciones de operacion a tutiplen";
        this.hora = hora;
    }

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(int numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(int numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getQuirofano() {
        return quirofano;
    }

    public void setQuirofano(int quirofano) {
        this.quirofano = quirofano;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return numeroOperacion + ";" + GeneradorDatosBBDDAA.fechaToString(fecha) + ";" + hora + ";" + numeroConsulta + ";" + numeroColegiado + ";" + area + ";" + quirofano + ";" + observaciones;
    }
    
    
    
}
