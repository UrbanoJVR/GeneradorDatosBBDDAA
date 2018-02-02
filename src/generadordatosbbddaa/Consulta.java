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
public class Consulta {
    
    int numeroConsulta;
    int numeroPaciente;
    int numeroColegiado;
    GregorianCalendar fecha;
    String hora;
    String area;
    int sala;

    public Consulta(int numeroConsulta, GregorianCalendar fecha, String hora) {
        this.numeroConsulta = numeroConsulta;
        this.numeroPaciente = (int) (Math.random() * 8000000) + 1;
        this.numeroColegiado = (int) (Math.random() * 500000) + 1;
        this.fecha = fecha;
        this.hora = hora;
        this.area = "AREA" + String.valueOf((int) (Math.random() * 100) + 1);
        this.sala = (int) (Math.random() * 500) + 1;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(int numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public int getNumeroPaciente() {
        return numeroPaciente;
    }

    public void setNumeroPaciente(int numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return numeroConsulta + ";" + numeroPaciente + ";" + numeroColegiado + ";" + GeneradorDatosBBDDAA.fechaToString(fecha) + ";" + hora + ";" + area + ";" + sala;
    }
    
}
