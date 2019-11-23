import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Principal
 */
public class Principal {
    public static void main(String[] args) {
        InteractiveIO mensajes = new InteractiveIO();
        Informe crear = new Informe();
        /************************************/
        String linea;
        int op=0;
        /***********************************/
        String cedula;
        String apellido;
        String nombre;
        String sexo;
        String turno;
        int anno;
        /***********************************/
        ArrayList<Estudiante> ingeneria=new ArrayList<Estudiante>();
        ArrayList<Estudiante> tecnico=new ArrayList<Estudiante>();
        ArrayList<Estudiante> licenciatura=new ArrayList<Estudiante>();
        try {
            // Abrimos el archivo del fichero y creamos un BufferedReader para poder
            // realizar la lectura del mismo
            FileReader archivo= new FileReader("Directorio_Estudiantes.txt");
            BufferedReader lectura=new BufferedReader(archivo);
            linea=lectura.readLine();
        while (linea!=null) {
            //if (linea.contains("Carrera")) {//Si en la linea encuentra la secuencia "Carrera"
                if (linea.contains("LIC. DE INGENIERIA EN INFORMATICA")) {//Verificamos la carrera que vamos a acceder
                    op=1;
                }else if (linea.contains("TECNICO EN INFORMATICA EDUCATIVA")) {//Verificamos la carrera que vamos a acceder
                    op=2;
                }else if (linea.contains("LIC. PARA LA GESTION EDUC Y EMPRESA")) {//Verificamos la carrera que vamos a acceder
                    op=3;
                }
           // }
            if (op==1) {
                if (linea.startsWith("0")||linea.startsWith("1")){
                    cedula=((linea.substring(0,16)).trim()).replace(" ","-");
                    apellido=(linea.substring(17,36)).trim();
                    nombre=(linea.substring(36,64)).trim();
                    sexo=((linea.substring(75,82)).trim());
                    turno=(linea.substring(83,93).trim());
                    anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                    ingeneria.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                }
            }
            if (op==2) {
                if (linea.startsWith("0")||linea.startsWith("1")){
                    cedula=((linea.substring(0,16)).trim()).replace(" ","-");
                    apellido=(linea.substring(17,36)).trim();
                    nombre=(linea.substring(36,64)).trim();
                    sexo=((linea.substring(75,82)).trim());
                    turno=(linea.substring(83,93).trim());
                    anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                    tecnico.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                }
            }
            if (op==3) {
                if (linea.startsWith("0")||linea.startsWith("1")){
                    cedula=((linea.substring(0,16)).trim()).replace(" ","-");
                    apellido=(linea.substring(17,36)).trim();
                    nombre=(linea.substring(36,64)).trim();
                    sexo=((linea.substring(75,82)).trim());
                    turno=(linea.substring(83,93).trim());
                    anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                    licenciatura.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                }
            }
            linea=lectura.readLine();
        }
        lectura.close();
        } catch (Exception e) {//En caso de error a la hora de abrir el archivo .txt
            mensajes.desplegarError("Error en la lectura del archivo\n\n"+e, "ERRO EN LA LECTURA");
            System.exit(1);//EL PROGRAMA SE TERMINA
            //TODO: handle exception
        }

        String carreraselect=mensajes.getCarreta();
        /*Realizamos la ordenacion de los arrayList por sexo*/
        /*La ordenacion se realiza con la interface COMPARABLE */
        Collections.sort(ingeneria);
        Collections.sort(tecnico);
        Collections.sort(licenciatura);
        if (carreraselect.equals("LIC. DE INGENIERIA EN INFORMATICA")) {
            for (Estudiante estudiante : ingeneria) {
                crear.pdfinforme(ingeneria,carreraselect,"lii.png");
                mensajes.desplegarINFORMA("SE A GENERADO EL INFORME CORRECTAMENTE","INFORME");
            }
        }else if (carreraselect.equals("TECNICO EN INFORMATICA EDUCATIVA")) {
            for (Estudiante estudiante : tecnico) {
                crear.pdfinforme(tecnico,carreraselect,"tecnico.png");
               mensajes.desplegarINFORMA("SE A GENERADO EL INFORME CORRECTAMENTE","INFORME");
            }
        }else if(carreraselect.equals("LIC. PARA LA GESTION EDUC Y EMPRESA")) {
            for (Estudiante estudiante : licenciatura) {
                crear.pdfinforme(licenciatura,carreraselect,"ligee.png");
                mensajes.desplegarINFORMA("SE A GENERADO EL INFORME CORRECTAMENTE","INFORME");
            }
        }
    }
}