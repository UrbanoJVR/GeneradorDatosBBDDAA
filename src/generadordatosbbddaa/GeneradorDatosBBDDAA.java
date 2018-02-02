/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordatosbbddaa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Urbano
 */
public class GeneradorDatosBBDDAA {

    //Primero creamos las variables necesarias
    //LISTAS ESTÁTICAS
    public static String provincias[] = {"Álava", "Albacete", "Alicante", "Almería",
        "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz",
        "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "La Coruña", "Cuenca",
        "Gerona", "Granada", "Guadalajara", "Guipúzcua", "Huelva", "Huesca", "Baleares",
        "Jaén", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra",
        "Orense", "Palencia", "Las Palmas", "Pontevedra", "La Rioja", "Salamanca",
        "Segovia", "Sevilla", "Soria", "Tarragona", "Santa Cruz de Tenerife", "Teruel",
        "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza", "Ceuta",
        "Melilla"};

    public static String nombres[] = {"Urbano", "Stephany", "Pedro", "Flavius",
        "Oscar", "Alberto", "Jose", "Francisco", "Juan", "Miguel", "Carlos", "Roberto",
        "Daniel", "Luis", "Federico", "Fidel", "Hugo", "Nicolas", "Vladimiro",
        "Mohamed", "León", "Filemón", "Pablo", "Manuel", "Iván", "Luisa", "Tomasa",
        "Juana", "Elisabeth", "María", "Teresa", "Eva", "Beatriz", "Alba", "Rosa",
        "Irene", "Lucia", "Elena", "Helena", "Sofia", "Danuta", "Yasmin", "Diana",
        "Miriam", "Laura", "Tatiana", "Tamara", "Carolina", "Rocio", "Margarita",
        "Macarena", "Tomás", "Ernesto"};

    public static String apellidos[] = {"Potter", "Villanueva", "Rodríguez",
        "Vellatrix", "Abad", "Aldaz", "Anguiano", "Angulo", "Arana", "Almeda",
        "Baldespino", "Bautista", "Guadiana", "Figueroa", "Erera", "Escobar",
        "Fragoso", "Guevara", "Gutierrez", "Jaramillo", "Gabriel", "Limon",
        "Obregon", "Meza", "Macario", "Luz", "Lucio", "Ribera", "Quintano",
        "Quintanilla", "Sagredo", "Salado", "Rutiaga", "Zabala", "Zuniga",
        "Vivanco", "Xicotencatl", "Tortolero", "Taboada", "Sains", "Simona",
        "Portillo", "Pelayo", "Paz", "Pavon", "Moncada", "Martín", "Garcia",
        "Rodriguez", "Ogalde", "Otero", "Montemayor", "Gongora", "Gutierrez", "Jacobo"};

    public static String especialidades[] = {"Alergología", "Anestesiología y reanimación",
        "Cardiología", "Gastroenterología", "Endocrinología", "Geriatría",
        "Hematología y hemoterapia", "Infectología", "Medicina aeroespacial",
        "Medicina del deporte", "Medicina del trabajo", "Medicina de urgencias",
        "Oftalmología", "Nutriología", "Neurología", "Neumología", "Nefrología",
        "Medicina preventiva y salud pública", "Medicina legal y forense",
        "Medicina interna", "Medicina intensiva", "Medicina física y rehabilitación",
        "Medicina familiar y comunitaria", "Urología", "Toxicología", "Reumatología",
        "Rehabilitación", "Psiquiatría", "Pediatría", "Oncología radioterápica", "Oncología médica"};

    //LISTAS DINÁMICAS
    public static ArrayList<Hospital> hospitales;
    public static ArrayList<Medico> medicos;
    public static ArrayList<Paciente> pacientes;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        long instanteInicio = System.currentTimeMillis();
        
        generarHospitales();
        generarMedicos();
        generarPacientes();
        generarConsultasPruebasOperaciones();
        
        long instanteFinal = System.currentTimeMillis();
        long duracion = instanteFinal - instanteInicio;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(duracion);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm.ss", new Locale("ES"));
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String tiempo = df.format(c.getTime());
        System.out.println("Programa finalizado. Tiempo total: " + tiempo);
    }

    //OTROS MÉTODOS NECESARIOS
    public static GregorianCalendar fechaAleatoria() {
        //El año 2016 es bisiesto: febrero tiene 28 dias
        //La clase GregorianCalendar toma el mes 0 como enero. Generamos
        //Valores aleatorios entre 0 y 11, donde 1 es febrero
        int mes = (int) (Math.random() * 12);
        int dia;
        if (mes == 1) {
            //estamos en febrero. Maximo 28 dias
            dia = (int) (Math.random() * 28) + 1;
            //En este caso sumamos 1 porque el primer día es 1, no 0
        } else if (mes == 0 || mes == 2 || mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11) {
            //Es mes de 31 días
            dia = (int) (Math.random() * 31) + 1;
        } else {
            //El mes es de 30 días
            dia = (int) (Math.random() * 30) + 1;
        }
        GregorianCalendar fecha = new GregorianCalendar(2016, mes, dia);
        //System.out.println(fecha.get(GregorianCalendar.DAY_OF_MONTH) + " / " + fecha.get(GregorianCalendar.MONTH) + " / " + fecha.get(GregorianCalendar.YEAR));
        return fecha;
    }

    public static String fechaToString(GregorianCalendar fecha) {
        //Ahora convertimos a string
        String dia = String.valueOf(fecha.get(GregorianCalendar.DAY_OF_MONTH));
        String mes = String.valueOf(fecha.get(GregorianCalendar.MONTH) + 1);
        String ano = String.valueOf(fecha.get(GregorianCalendar.YEAR));
        String fechaFinal = dia + "/" + mes + "/" + ano;
        return fechaFinal;
    }

    public static void generarHospitales() throws IOException {
        hospitales = new ArrayList<>();
        System.out.println("Generando hospitales...");
        
        long init = System.currentTimeMillis();

        File archivo = new File("C:\\Users\\Urbano\\Desktop\\ArchivosPECL2BBDDAA\\hospitales.dat");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (int i = 1; i < 1001; i++) { // 1 000
            Hospital hosp = new Hospital(i);
            bw.write(hosp.toString() + "\n");
            //System.out.println(hosp.toString());
            //hospitales.add(hosp);
        }

        bw.close();

        long end = System.currentTimeMillis();
        long time = end - init;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", new Locale("ES"));
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String tiempo = df.format(c.getTime());
        System.out.println("Hospitales generados en: " + tiempo);

    }

    public static String horaRandom() {
        String h = null;
        //Generamos la hora entre las 9 y las 21
        int hora = (int) (Math.random() * 12) + 9;
        //Generamos los minutos
        int min = (int) (Math.random() * 59);
        h = String.valueOf(hora) + ":" + String.valueOf(min);
        return h;
    }

    public static void generarMedicos() throws IOException {
        medicos = new ArrayList<>();
        System.out.println("Generando medicos...");
        long inicio = System.currentTimeMillis();

        File archivo = new File("C:\\Users\\Urbano\\Desktop\\ArchivosPECL2BBDDAA\\medicos.dat");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (int i = 1; i < 500001; i++) { //500 000
            Medico med = new Medico(i);
            bw.write(med.toString() + "\n");
            //System.out.println(med.toString());
            //medicos.add(med);
        }

        bw.close();

        long fin = System.currentTimeMillis();
        long time = fin - inicio;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", new Locale("ES"));
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String tiempo = df.format(c.getTime());
        System.out.println("Médicos generados en: " + tiempo);
        //System.out.println("Longitud: " + medicos.size());
    }

    public static void generarPacientes() throws IOException {
        pacientes = new ArrayList<>();
        System.out.println("Generando pacientes...");
        long inicio = System.currentTimeMillis();

        File archivo = new File("C:\\Users\\Urbano\\Desktop\\ArchivosPECL2BBDDAA\\pacientes.dat");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (int i = 1; i < 8000001; i++) { //8 000 000
            Paciente p = new Paciente(i);
            bw.write(p.toString() + "\n");
            //System.out.println(p.toString());
            //pacientes.add(p);
        }

        bw.close();

        long fin = System.currentTimeMillis();
        long time = fin - inicio;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm.ss", new Locale("ES"));
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String tiempo = df.format(c.getTime());
        System.out.println("Pacientes generados en: " + tiempo);
    }

    public static void generarConsultasPruebasOperaciones() throws IOException {
        System.out.println("Generando consultas, pruebas y operaciones...");
        long init = System.currentTimeMillis();

        //Abrimos archivo consultas
        File archivoConsultas = new File("C:\\Users\\Urbano\\Desktop\\ArchivosPECL2BBDDAA\\consultas.dat");
        BufferedWriter bwConsultas = new BufferedWriter(new FileWriter(archivoConsultas));

        //Abrimos archivo de operaciones
        File archivoOperaciones = new File("C:\\Users\\Urbano\\Desktop\\ArchivosPECL2BBDDAA\\operaciones.dat");
        BufferedWriter bwOperaciones = new BufferedWriter(new FileWriter(archivoOperaciones));

        //Abrimos archivo de pruebas
        File archivoPruebas = new File("C:\\Users\\Urbano\\Desktop\\ArchivosPECL2BBDDAA\\pruebas.dat");
        BufferedWriter bwPruebas = new BufferedWriter(new FileWriter(archivoPruebas));

        //Inicializamos los identificadores de prueba y operacion
        int numOperacion = 1;
        int numPrueba = 1;

        for (int i = 1; i < 24000001; i++) { // 24 000 000
            Consulta c = new Consulta(i, fechaAleatoria(), horaRandom());
            //System.out.println(c.toString());
            bwConsultas.write(c.toString() + "\n");

            //Hemos generado la consulta correspondiente
            //Ahora averiguaremos si la consulta conlleva una operacion
            //O una prueba
            int prob = (int) (Math.random() * 10) + 1;
            if (prob <= 4) {
                //La probabilidad es 1, 2, 3 o 4
                //Por tanto la consulta genera una operacion
                Operacion op = new Operacion(numOperacion, fechaAleatoria(), c.getNumeroConsulta(), c.getNumeroColegiado(), c.getArea(), horaRandom());
                numOperacion++; //Incrementamos el numero operacion para
                //La siguiente vez que entre en el bucle

                //Escribimos la operacion en el archivo
                bwOperaciones.write(op.toString() + "\n");
            } else {
                //La probabilidad es mayor que 4 (5, 6, 7, 8, 9 o 10)
                //La consulta genera una prueba
                Prueba p = new Prueba(numPrueba, fechaAleatoria(), c.getNumeroConsulta(), c.getArea(), c.getNumeroColegiado(), horaRandom());
                numPrueba++; //Incrementamos el numero de prueba
                
                //Escribimos la prueba en el archivo
                bwPruebas.write(p.toString() + "\n");
            }
        }

        //Cerramos todos los archivos
        bwConsultas.close();
        bwOperaciones.close();
        bwPruebas.close();

        long end = System.currentTimeMillis();
        long time = end - init;

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm.ss", new Locale("ES"));
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String tiempo = df.format(c.getTime());
        System.out.println("Consultas, pruebas y operaciones generadas en: " + tiempo);
    }

}
