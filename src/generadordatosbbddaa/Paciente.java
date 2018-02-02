/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordatosbbddaa;

import java.util.Arrays;

/**
 *
 * @author Urbano
 */
public final class Paciente {
    
    int numeroPaciente;
    int nss;
    String DNI;
    String nombre;
    String apellidos;
    String direccion;
    int cp;
    String ciudad;
    String provincia;
    long tlf;
    int numeroHistoriaClinica;

    public Paciente(int numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
        String num = "23" + String.valueOf(100 + this.numeroPaciente);
        this.nss = Integer.parseInt(num);
        this.DNI = this.generarDNI(this.numeroPaciente);
        this.nombre = GeneradorDatosBBDDAA.nombres[(int) (Math.random() * GeneradorDatosBBDDAA.nombres.length)];
        this.apellidos = GeneradorDatosBBDDAA.apellidos[(int) (Math.random() * GeneradorDatosBBDDAA.apellidos.length)]
                + " " + GeneradorDatosBBDDAA.apellidos[(int) (Math.random() * GeneradorDatosBBDDAA.apellidos.length)];
        this.direccion = "Direccion " + String.valueOf(this.nss);
        this.cp = (int) (Math.random() * 199) + 25401;
        this.ciudad = "Ciudad " + String.valueOf(this.nss);
        this.provincia = GeneradorDatosBBDDAA.provincias[ (int) (Math.random() * GeneradorDatosBBDDAA.provincias.length)];
        this.tlf = Integer.parseInt("917" + String.valueOf((int) ((Math.random() * 10000) + 1)));
        this.numeroHistoriaClinica = this.numeroPaciente;
    }

    public String generarDNI(int num){
        int cifras = 60000000 + num;
        String masLetra = String.valueOf(cifras) + "P";
        return masLetra;
    }
    
    public int getNumeroPaciente() {
        return numeroPaciente;
    }

    public void setNumeroPaciente(int numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public long getTlf() {
        return tlf;
    }

    public void setTlf(long tlf) {
        this.tlf = tlf;
    }

    public int getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    @Override
    public String toString() {
        return numeroPaciente + ";" + nss + ";" + DNI + ";" + nombre + ";" + apellidos + ";" + direccion + ";" + cp + ";" + ciudad + ";" + provincia + ";" + tlf + ";" + numeroHistoriaClinica;
    }
    
}
