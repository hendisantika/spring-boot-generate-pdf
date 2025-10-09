package id.my.hendisantika.springbootgeneratepdf.service;

import jakarta.servlet.http.HttpServletResponse;
import org.openpdf.text.Document;
import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/16/24
 * Time: 09:35
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PdfService {
    public ByteArrayInputStream convertHtmlToPdf(String htmlContent) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream, false);
        renderer.finishPDF();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return inputStream;
    }

    public void export(HttpServletResponse httpServletResponse) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.COURIER_BOLD);
        fontTitle.setSize(16);
        fontTitle.setColor(108, 142, 163);

        Paragraph paragraph = new Paragraph("Generate a PDF Using Spring Boot", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        fontParagraph.setColor(153, 153, 255);

        Paragraph headingPara = new Paragraph("This is Heading for a Paragraph.", fontParagraph);
        headingPara.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(headingPara);

        document.close();

    }
}
