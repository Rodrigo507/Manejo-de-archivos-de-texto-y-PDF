import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * Esta clase se encarga de la generacion de los documentos
 * tanto el PDF
 * como el arhcivo secuencial .txt
 */
public class Informe {
    public void pdfinforme(ArrayList<Estudiante> carrera, String carreraselected) {
    
    try {
        
        FileOutputStream archivo = new FileOutputStream("Informe.pdf");//Ruta donde se guardara el documento
        Document documento = new Document(PageSize.A4, 20, 50, 50, 50);//Tamanno de hoja y le asignamos los margenes
        PdfWriter writer =PdfWriter.getInstance(documento, archivo);//Creamos el pdfwrite que nos permite la creacion del pdf
        //Insertar imagen
        /*Header and Footer*/
        writer.setInitialLeading(16);
        HeaderFooter top = new HeaderFooter("Programacion IV-INF222");//Mensaje del header = carrera que seleciono el usuario
        writer.setPageEvent(top);//Agregamos el header antes de abrir el documento
        documento.open();//Abrimos el documento
        try
        {
            Image foto = Image.getInstance("imagenes/ligee.png");//Instanciamos la imagen
            foto.scaleToFit(500, 600);//Le pasamos laas dimenciones de la imagen
            foto.setAlignment(Chunk.ALIGN_MIDDLE);//Asignamos un espacio en el documneto en este caso en el centro 
            documento.add(foto);//Agregamos la imagen al documento
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        documento.add(new Paragraph("\n\nCarrera: "+carreraselected+"\n\n"));//Agregamos una nueva linea con una cadena
        //PdfPTable primera = new PdfPTable(4);//Generamos la columnas para la primera fila de la tabla
        PdfPTable tabla = new PdfPTable(4);//Generamos la columnas
        tabla.setWidths(new int[]{200,200,200,50});
        tabla.addCell("NOMBRE");//Agregamos a cada celda lo que deseamos
        tabla.addCell("APELLIDO");//Agregamos a cada celda lo que deseamos
        tabla.addCell("CEDULA");//Agregamos a cada celda lo que deseamos
        tabla.addCell("SEXO");//Agregamos a cada celda lo que deseamos
       // documento.add(tabla);
       // PdfPTable tabla = new PdfPTable(4);//Generamos la columnas

        //primera.setWidths(new int[]{200,200,200,100});
        tabla.setWidths(new int[]{200,200,200,80});
        //Agregamos a cada celda una dato del objeto
        for (Estudiante z : carrera) {
            tabla.addCell(z.getNombre());
            tabla.addCell(z.getApellido());
            tabla.addCell(z.getcedula());
            tabla.addCell(z.getSexo());

        }
        
        documento.add(tabla);//Agregamos la tabla al documento
        documento.close(); // Serramos el documento
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    public void txtinforme(ArrayList<Estudiante> carrera) {
        try {
            FileWriter txt = new FileWriter("Informe.txt");//creamos el archivo

        for (Estudiante estudiante : carrera) {
            //Recorremos los datos del objeto que estan alamacenados en el array
            //Con la ayuda  del "String format" le damos una sepacion entre los datos
            String z=String.format("%-20s %-17s %-17s %-10s%n", estudiante.getNombre(),estudiante.getApellido(),estudiante.getcedula(),estudiante.getSexo());
            txt.write(z);//Agregamos la cadena al archivo
        }
        txt.close();//Cerramos el archivo txt
        } catch (Exception e) {
           System.err.println(e);
        }


    }

}