import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * HeaderFooter
 */
public class HeaderFooter extends PdfPageEventHelper {
    private String cadena;
    private static Font headerFont = new Font(Font.FontFamily.COURIER , 8, Font.NORMAL);

    private static Font footerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    public HeaderFooter(String cad) {
        super();
        this.cadena = cad;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        // TODO Auto-generated method stub
        // super.onEndPage(writer, document);
        // header content
        String headerContent =  cadena;

        
        /*
         * Header
         */
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(headerContent,headerFont),
                document.leftMargin() - 1, document.top() + 30, 0);

        /*
         * Foooter
         */
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format(" %d ",writer.getPageNumber()),footerFont), document.right() - 2 , document.bottom() - 20, 0);
    }
    
}