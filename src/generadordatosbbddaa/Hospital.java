/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordatosbbddaa;

/**
 *
 * @author Urbano
 */
public class Hospital {
    
    int codigo;
    String nombre;
    String direccion;
    int cp;
    String ciudad;
    String provincia;
    long tlf;
    String email;
    int numCamas;

    public Hospital(int codigo) {
        this.codigo = codigo;
        this.nombre = "Hospital " + String.valueOf(codigo);
        this.direccion = "Direccion " + String.valueOf(codigo);
        this.cp = (int) (Math.random() * 199) + 28801;
        this.ciudad = "Ciudad " + String.valueOf(codigo);
        this.provincia = GeneradorDatosBBDDAA.provincias[ (int) (Math.random() * GeneradorDatosBBDDAA.provincias.length)];
        //this.tlf = Integer.parseInt("916" + String.valueOf((int) (Math.random() * 10000) + codigo));
        this.tlf = Integer.parseInt("916" + String.valueOf(this.codigo));
        this.email = "EmailHospital" + String.valueOf(codigo) + "@hospital" + String.valueOf(codigo) + ".com";
        this.numCamas = (int) (Math.random() * 400) + 100;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + direccion + ";" + cp + ";" + ciudad + ";" + provincia + ";" + tlf + ";" + email + ";" + numCamas;
    }
    
    
    
}
