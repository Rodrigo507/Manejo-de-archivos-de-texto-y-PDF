package Oficial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CargarDatos
 */
public class CargarDatos {

    String linea;
    int op = 0;
    /***********************************/
    String cedula;
    String apellido;
    String nombre;
    char sexo;
    String turno;
    int anno;
    /***********************************/
    /*********************************/
    Estudiante es =new Estudiante();
    ArrayList<Estudiante> ingeneria = new ArrayList<Estudiante>();
    ArrayList<Estudiante> tecnico = new ArrayList<Estudiante>();
    ArrayList<Estudiante> licen = new ArrayList<Estudiante>();

    public ArrayList getArray() {
        return (tecnico);
    }

    public void leerArchvo() throws IOException {
        
        FileReader archivo= new FileReader("DIRECTORIO_DE_ESTUDIANTES_FACULTAD_DE_INFORMATICA.txt");
        BufferedReader lectura=new BufferedReader(archivo);
        linea=lectura.readLine();
        while (linea!=null) {
            if (linea.contains("Carrera")) {//Si en la linea encuentra la secuencia "Carrera"
                if (linea.contains("LIC. DE INGENIERIA EN INFORMATICA")) {//Verificamos la carrera que vamos a acceder
                    op=1;
                }else if (linea.contains("TECNICO EN INFORMATICA EDUCATIVA")) {//Verificamos la carrera que vamos a acceder
                    op=2;
                }else if (linea.contains("LIC. PARA LA GESTION EDUC Y EMPRESA")) {//Verificamos la carrera que vamos a acceder
                    op=3;
                }
            }
            if (op==1) {//Solo entrara cuando
                if (linea.startsWith("0")||linea.startsWith("1")){
                    cedula=(linea.substring(0,16)).trim();
                    apellido=(linea.substring(17,36)).trim();
                    nombre=(linea.substring(36,64)).trim();
                    sexo=((linea.substring(75,82)).trim()).charAt(0);
                    turno=(linea.substring(83,93).trim());
                    anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                    //System.out.println("Nombre: "+nombre);
                    ingeneria.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                }
            }
            if (op==2) {
                if (linea.startsWith("0")||linea.startsWith("1")){
                    cedula=(linea.substring(0,16)).trim();
                    apellido=(linea.substring(17,36)).trim();
                    nombre=(linea.substring(36,64)).trim();
                    sexo=((linea.substring(75,82)).trim()).charAt(0);
                    turno=(linea.substring(83,93).trim());
                    anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                    tecnico.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                }
            }
            if (op==3) {
                if (linea.startsWith("0")||linea.startsWith("1")){
                    cedula=(linea.substring(0,16)).trim();
                    apellido=(linea.substring(17,36)).trim();
                    nombre=(linea.substring(36,64)).trim();
                    sexo=((linea.substring(75,82)).trim()).charAt(0);
                    turno=(linea.substring(83,93).trim());
                    anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                    licen.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                }
            }
            linea=lectura.readLine();
        }
        
        lectura.close();
      
        }
    }
        
