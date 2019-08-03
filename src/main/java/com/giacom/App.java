package com.giacom;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class App {
    public static void main(String[] args) {
        try {
            PDDocument pDDocument = PDDocument.load(new File("/tmp/pdf-java.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("txt_1");
            field.setValue("This is a first field printed by Java");
            field = pDAcroForm.getField("txt_2");
            field.setValue("This is a second field printed by Java");
            pDDocument.save("/tmp/pdf-java-output.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
