package demo;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author luwb
 * @date 2020/12/15
 */
public class Watermark extends PdfPageEventHelper {

    private Font font = new Font(Font.FontFamily.HELVETICA, 30, Font.BOLD, new GrayColor(0.95f));
    //水印内容
    private String waterCont;

    Watermark(String waterCont) {
        this.waterCont = waterCont;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ColumnText.showTextAligned(writer.getDirectContentUnder(),
                        Element.ALIGN_CENTER,
                        new Phrase(this.waterCont == null ? "HELLO WORLD" : this.waterCont, font),
                        (50.5f + i * 350),
                        (40.0f + j * 150),
                        writer.getPageNumber() % 2 == 1 ? 45 : -45);
            }
        }
    }
}