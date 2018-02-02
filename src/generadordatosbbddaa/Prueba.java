/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordatosbbddaa;

import java.util.GregorianCalendar;

/**
 *
 * @author urbano
 */
public class Prueba {
 
    int numeroPrueba;
    GregorianCalendar fecha;
    String hora;
    int numeroConsulta;
    String area;
    int sala;
    String observaciones;
    int numeroColegiado;

    public Prueba(int numeroPrueba, GregorianCalendar fecha, int numeroConsulta, String area, int numeroColegiado, String hora) {
        this.numeroPrueba = numeroPrueba;
        this.fecha = fecha;
        this.numeroConsulta = numeroConsulta;
        this.area = area;
        this.sala = (int) (Math.random() * 250) + 1;
        this.observaciones = "Observaciones de prueba a tutiplen";
        this.numeroColegiado = numeroColegiado;
        this.hora = hora;
    }

    public int getNumeroPrueba() {
        return numeroPrueba;
    }

    public void setNumeroPrueba(int numeroPrueba) {
        this.numeroPrueba = numeroPrueba;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    @Override
    public String toString() {
        return numeroPrueba + ";" + GeneradorDatosBBDDAA.fechaToString(fecha) + ";" + hora + ";" + numeroConsulta + ";" + area + ";" + sala + ";" + observaciones + ";" + numeroColegiado;
    }
    
}
