package TestPages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public void validateHomePage() {
        // Validate that we are at the correct page
        waitForPageLoad();
        waitForVisibleElement(By.xpath("//a/img[@title='btn_logotipo']"));
        Assert.assertEquals("Getnet: Maquininhas de Cartão e Soluções para o seu Negócio", driver.getTitle());
    }

    public void clickSearchButton() {
        // Click on search button
        btnClick(By.xpath("//*[@class='c-lgpd_content--btn']"));
        waitForNotVisibleElement(By.xpath("//*[@class='c-lgpd_content--btn']"));
        btnClick(By.xpath("//*[@id='search-trigger']/div"));
    }


    public void inputSearch(String string) {
        // Input Search Field
        fieldInput(By.xpath("//input[@type='text']"), string);
    }

    public void clickSubmit() {
        // Click on submit button
        btnClick(By.xpath("//button[@type='submit']"));
    }
}
