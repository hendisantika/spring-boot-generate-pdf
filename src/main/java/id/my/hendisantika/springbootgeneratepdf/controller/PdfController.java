package id.my.hendisantika.springbootgeneratepdf.controller;

import id.my.hendisantika.springbootgeneratepdf.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-generate-pdf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/16/24
 * Time: 09:36
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class PdfController {

    private final PdfService pdfService;

}
