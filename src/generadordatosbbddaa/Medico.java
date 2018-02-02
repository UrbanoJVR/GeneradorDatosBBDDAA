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
public final class Medico {
    
    int numeroColegiado;
    int NSS;
    String DNI;
    String nombre;
    String apellidos;
    String direccion;
    int cp;
    String ciudad;
    String provincia;
    long telefono;
    String area;
    String especialidad;
    int codigoHospital;

    public Medico(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
        String num = "23" + String.valueOf(100 + this.numeroColegiado);
        //this.NSS = (int) (Math.random() * 199 ) + this.numeroColegiado;
        this.NSS = Integer.parseInt(num);
        this.DNI = this.generarDNI(this.numeroColegiado);
        this.nombre = GeneradorDatosBBDDAA.nombres[(int) (Math.random() * GeneradorDatosBBDDAA.nombres.length)];
        this.apellidos = GeneradorDatosBBDDAA.apellidos[(int) (Math.random() * GeneradorDatosBBDDAA.apellidos.length)]
                + " " + GeneradorDatosBBDDAA.apellidos[(int) (Math.random() * GeneradorDatosBBDDAA.apellidos.length)];
        this.direccion = "Direccion " + String.valueOf(this.numeroColegiado);
        this.cp = (int) (Math.random() * 199) + 28801;
        this.ciudad = "Ciudad " + String.valueOf(this.numeroColegiado);
        this.provincia = GeneradorDatosBBDDAA.provincias[ (int) (Math.random() * GeneradorDatosBBDDAA.provincias.length)];
        this.telefono = Integer.parseInt("915" + String.valueOf((int) ((Math.random() * 10000) + 1)));
        this.area = "AREA" + String.valueOf((int) (Math.random() * 100) + 1);
        this.especialidad = GeneradorDatosBBDDAA.especialidades[(int) (Math.random() * GeneradorDatosBBDDAA.especialidades.length)];
        this.codigoHospital = (int) (Math.random() * 1000) + 1;
    }

    public String generarDNI(int num){
        int cifras = 50000000 + num;
        String masLetra = String.valueOf(cifras) + "M";
        return masLetra;
    }
    
    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCodigoHospital() {
        return codigoHospital;
    }

    public void setCodigoHospital(int codigoHospital) {
        this.codigoHospital = codigoHospital;
    }

    @Override
    public String toString() {
        return numeroColegiado + ";" + NSS + ";" + DNI + ";" + nombre + ";" + apellidos + ";" + direccion + ";" + cp + ";" + ciudad + ";" + provincia + ";" + telefono + ";" + area + ";" + especialidad + ";" + codigoHospital;
    }
    
}
