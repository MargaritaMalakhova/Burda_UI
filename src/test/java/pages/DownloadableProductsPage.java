package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class DownloadableProductsPage {
    SelenideElement userProfileInformationField = $("div.box-information p"),
            downloadFileLink = $("td.title > a");

    public File downloadFile() throws Exception {
        return downloadFileLink.download();
     }

     public PDF createPDF() throws Exception {
        return new PDF(downloadFile());
     }


     public DownloadableProductsPage checkPDF(String textForCheckInPDF)  throws Exception {
        Assertions.assertTrue((createPDF()).text.contains(textForCheckInPDF));
        return this;
     }



}