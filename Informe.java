/*IMPORTACION DE DE itextpdf */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * Informe
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
public class Informe {


    public void pdfinforme(ArrayList<Estudiante> carrera) {
        
    
    Document archivo = new Document();
    try {
        PdfWriter.getInstance(archivo, new FileOutputStream("INFORME PDF"));//Instanciamos el archivo
        archivo.open();//Abrimos el archivo
        PdfPTable primera = new PdfPTable(4);
        primera.addCell("NOMBRE");//Agregamos a cada celda lo que deseamos
        primera.addCell("APELLIDO");//Agregamos a cada celda lo que deseamos
        primera.addCell("CEDULA");//Agregamos a cada celda lo que deseamos
        primera.addCell("SEXO");//Agregamos a cada celda lo que deseamos
        archivo.add(primera);
        PdfPTable tabla = new PdfPTable(4);//Generamos la columnas
        for (Estudiante z : carrera) {
           
            tabla.addCell(z.getNombre());
            tabla.addCell(z.getApellido());
            tabla.addCell(z.getcedula());
            tabla.addCell(z.getSexo());
        }
        archivo.add(tabla);//Agregamos la tabla al archivo

        archivo.add(new Paragraph("A Hello World PDF document."));
        archivo.close(); // Serramos el documento
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
    
}