package pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DownloadableProductsPage {

    PDF pdf;
    SelenideElement downloadableProductSection = $x("//a[text()='My Downloadable Products']"),
                    downloadFileLink = $("td.title > a");
    @Step("Open Downloadable Products Page")
    public DownloadableProductsPage openDownloadableProductsPage() {
        downloadableProductSection.click();
        return this;
    }
    @Step("Download Pattern")
    public DownloadableProductsPage downloadPattern() throws Exception {
        pdf = new PDF(downloadFileLink.download());
        return this;
    }
    @Step("Check text in Downloaded Pattern")
    public void checkPDF(String textForCheckInPDF) {
        Assertions.assertTrue(pdf.text.contains(textForCheckInPDF));
    }



}