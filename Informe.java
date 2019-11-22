/*IMPORTACION DE DE itextpdf */

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
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


    public void pdfinforme(ArrayList<Estudiante> carrera, String carreraselected) {
    

    
    Document archivo = new Document();
    try {
        PdfWriter.getInstance(archivo, new FileOutputStream("INFORME PDF"));//Instanciamos el archivo
        archivo.open();//Abrimos el archivo
        //Insertar imagen

        try
        {
            Image foto = Image.getInstance("bannerWebCruvFiec2.png");
            foto.scaleToFit(500, 600);
            foto.setAlignment(Chunk.ALIGN_MIDDLE);
            archivo.add(foto);
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        archivo.add(new Paragraph("\n\nCarrera: "+carreraselected+"\n\n"));
        PdfPTable primera = new PdfPTable(4);//Generamos la columnas para la primera fila de la tabla
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

        
        archivo.close(); // Serramos el documento
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
    
}