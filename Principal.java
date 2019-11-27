import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * La clase principal se encargara de las llamadas a los metodos de las diferentes clases
 */
public class Principal {
    public static void main( String[] args) {
        //Se crean los objetos de la clase IO y informe
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
        int masculino=0;
        int femenino=0;
        /***********************************/
        //Se crean 3 Arraylist Para almacenar los datos de cada carrera
         ArrayList<Estudiante> ingeneria=new ArrayList<Estudiante>();
         ArrayList<Estudiante> tecnico=new ArrayList<Estudiante>();
         ArrayList<Estudiante> licenciatura=new ArrayList<Estudiante>();
        try {
            // Abrimos el archivo del fichero y creamos un BufferedReader para poder
            // realizar la lectura del mismo
             FileReader archivo= new FileReader("Directorio_Estudiantes.txt");
             BufferedReader lectura=new BufferedReader(archivo);
            linea=lectura.readLine();//Leemos la primera linea del documento
        while (linea!=null) {
            /*La variable "op" nos dira que carrera estamos leyendo */
                if (linea.contains("LIC. DE INGENIERIA EN INFORMATICA")) {//Verificamos la carrera que vamos a acceder
                    op=1;
                }else if (linea.contains("TECNICO EN INFORMATICA EDUCATIVA")) {//Verificamos la carrera que vamos a acceder
                    op=2;
                }else if (linea.contains("LIC. PARA LA GESTION EDUC Y EMPRESA")) {//Verificamos la carrera que vamos a acceder
                    op=3;
                }
                /**
                 * En esta seccion creamos substring de la linea leida para cada dato
                 * le pasamos el incio de cada dato 0,16 es la cedula(substring)
                 * Una vez tenemos ese datos con el metodo "trim()" quitamos los espacios en blanco
                 * de inicio y fin de la cadena.
                 * En la cedula utilizamos "remplace" donde remplasamos los espacios en blanco por "-"
                 * para los annos convertimos de string a int con "ParseInt"
                 * Por ultimo creamos el objeto de la clase Estudiante y lo agregamos al arraylist 
                 */
            if (op==1) {
                if (linea.startsWith("0")||linea.startsWith("1")){//Leemos solo si la cadena comiensa con 0 o 1
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
            linea=lectura.readLine();//Leemos la siguiente linea del documento
        }
        lectura.close();//Una ves terminamos de leer cerramos el archivo
        /***********************************/
        } catch ( Exception e) {//En caso de error a la hora de abrir el archivo .txt
            mensajes.desplegarError("Error en la lectura del archivo\n\n"+e, "ERRO EN LA LECTURA");
            System.exit(1);//EL PROGRAMA SE TERMINA
        }
        /***********************************/
         String carreraselect=mensajes.getCarreta();//capturamos la carrera que usurio desea realizar el informe
        /*Realizamos la ordenacion de los arrayList por sexo*/
        /*La ordenacion se realiza con la interface COMPARABLE */
       /***********************************/
       /**
        *Realizamos la Comprobación de la elecion de carrera
        *Primero se ordena el arraylist
        * LLamamos el metodo para crear el informe
        * LLamamos el metodo para crear el archivo secuencial
        * Contamos los masculinos y femeninos de la carrera elegida
        * Se depliega el mensaje de que el informe fue creado correctamente 
        */
        
        if (carreraselect.equals("LIC. DE INGENIERIA EN INFORMATICA")) {
            Collections.sort(ingeneria);
            crear.pdfinforme(ingeneria,carreraselect);
            crear.txtinforme(ingeneria);
            for (Estudiante estudiante : ingeneria) {
                if (estudiante.getSexo().equals("M")) {
                    masculino++;
                }else{
                    femenino++;
                }
            }
            mensajes.desplegarINFORMA("SE GENERARON LOS INFORMES CORRECTAMENTE","INFORME");
        }else if (carreraselect.equals("TECNICO EN INFORMATICA EDUCATIVA")) {
            Collections.sort(tecnico);
            crear.pdfinforme(tecnico,carreraselect);
            crear.txtinforme(tecnico);
            for (Estudiante estudiante : tecnico) {
                if (estudiante.getSexo().equals("M")) {
                    masculino++;
                }else{
                    femenino++;
                }
            }
            mensajes.desplegarINFORMA("SE GENERARON LOS INFORMES CORRECTAMENTE","INFORME");
        }else if(carreraselect.equals("LIC. PARA LA GESTION EDUC Y EMPRESA")) {
            Collections.sort(licenciatura);
            crear.pdfinforme(licenciatura,carreraselect);
            crear.txtinforme(licenciatura);
            for (Estudiante estudiante : licenciatura) {
                if (estudiante.getSexo().equals("M")) {
                    masculino++;
                }else{
                    femenino++;
                }
            }
            mensajes.desplegarINFORMA("SE GENERARON LOS INFORMES CORRECTAMENTE","INFORME");
        }
        /*Desplegamos el porcentaje de masculinos, femeninos y el total de sexo */
        mensajes.desplegarINFORMA("MASCULINOS: "+ porncentaje(masculino,femenino)+"%"+"\nFEMENINAS: "+porncentaje(femenino, masculino)+"%"+"\n Total: "+(masculino+femenino), "Porcentaje Por Sexo");
        System.exit(0);
    }
    //Metododos clase principal
    /*Este metodo nos permite sacar el porcenta de un valor */
    /*Se le pasan dos valores siendo el primero al que se le sacara leporcentaje */
    /*En vace al total */
    
    public static double porncentaje(int num1,int num2) {
        return((100*num1)/(num1+num2));
    }


}