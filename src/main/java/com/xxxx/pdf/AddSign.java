package main.java.com.xxxx.pdf;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.File;
/**
 * @auther Lux 2018/11/17
 */
/
public class AddSign {
    public AddSign() {

    }

    public static void main(String[]args){
        /**
         * 1 load a pdf file
         * 2 get file's DataHandler
         * 3 addDigitalSignature for PDF
         */
        File file = new File("/Users/lux/Downloads/unit_trust_account.pdf");

        DataHandler dh = getDataHandler(file);

        PDDocumentt document;

        addDigitalSignature(document);

        System.out.println("Done");


    }



    private static DataHandler getDataHandler(File file) {

        DataSource dataSource = new FileDataSource(file);
        DataHandler dataHandler = new DataHandler(dataSource);
        return  dataHandler;


    }

    private static void addDigitalSignature(PDDocument document) {


        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDFont font = PDType1Font.HELVETICA;
        PDResources resources = new PDResources();

        resources.put(COSName.getPDFName("Helv"),font);

        PDAcroForm acroForm  = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);

        acroForm.setDefaultAppearance(resources);

        String defaultAppranceString = "/Helv 0 Tf 0 g";

        PDSignatureField signatureField = null;

        signatureField = new PDSignatureField(acroForm);
        PDAnnotationWidget widget = signatureField.getWidget().get(0);
        widget.setRectangle(rect);
        widget.setPage(page);
        page.getAnnotations().add(widget);
        acroForm.getFields().add(signatureField);
        document.save("/Users/lux/Downloads/unit_trust_account_addsign.pdf");

    }
}
