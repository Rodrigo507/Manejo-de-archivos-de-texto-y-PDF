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
         Estudiante rr = new Estudiante();
        /************************************/
        String linea;
        int op=0;
        int sw=0;
        String carreraselect="";
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
         ArrayList<Estudiante> datos=new ArrayList<Estudiante>();
        
        try {
            // Abrimos el archivo del fichero y creamos un BufferedReader para poder
            // realizar la lectura del mismo
             FileReader archivo= new FileReader("Directorio_Estudiantes.txt");
             BufferedReader lectura=new BufferedReader(archivo);
             carreraselect=mensajes.getCarreta();//capturamos la carrera que usurio desea realizar el informe
            linea=lectura.readLine();//Leemos la primera linea del documento
            while (linea!=null&&sw!=2) {
                    if (linea.contains(carreraselect)) {
                        sw=1;
                    }else if (linea.contains("Total")&&sw==1) {
                        sw=2;
                    }
                if (sw==1) {
                    if (linea.startsWith("0")||linea.startsWith("1")) {
                        cedula=((linea.substring(0,16)).trim()).replace(" ","-");
                        apellido=(linea.substring(17,36)).trim();
                        nombre=(linea.substring(36,64)).trim();
                        sexo=((linea.substring(75,82)).trim());
                        turno=(linea.substring(83,93).trim());
                        anno=Integer.parseInt((linea.substring(94,linea.length())).trim());
                        datos.add(new Estudiante(cedula, apellido, nombre, sexo, turno, anno));
                    }              
                }
                linea=lectura.readLine();
            }//Fin del while
        lectura.close();//Una ves terminamos de leer cerramos el archivo
        /***********************************/
        } catch ( Exception e) {//En caso de error a la hora de abrir el archivo .txt
            mensajes.desplegarError("Error en la lectura del archivo\n\n"+e, "ERRO EN LA LECTURA");
            System.exit(1);//EL PROGRAMA SE TERMINA
        }
       
        /************************************************/
                /*INFORME*/
                Collections.sort(datos);//Ordenamos el arraylist
                crear.pdfinforme(datos, carreraselect);//Creamos el informe pdf
                crear.txtinforme(datos);//creamos el archivo secuencial
                masculino=rr.totalSexo("M", datos);//Total masculinos
                femenino=rr.totalSexo("F", datos);//Total femeninos
                mensajes.desplegarINFORMA("SE GENERARON LOS INFORMES CORRECTAMENTE","INFORME");
        /*Desplegamos el porcentaje de masculinos, femeninos y el total de sexo */
        mensajes.desplegarINFORMA("MASCULINOS: "+ porncentaje(masculino,femenino)+"%"+"\nFEMENINAS: "+porncentaje(femenino, masculino)+"%"+"\n Total: "+(masculino+femenino), "Porcentaje Por Sexo");
        System.exit(0);
    }
    //Metododos clase principal
    /*Este metodo nos permite sacar el porcenta de un valor */
    /*Se le pasan dos valores siendo el primero al que se le sacara leporcentaje */
    /*En base al total */
    
    public static double porncentaje(int num1,int num2) {
        return((100*num1)/(num1+num2));
    }


}