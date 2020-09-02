package TestPages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {

    public void validateSearchPage() {
        // Validate that we are at the correct page
        waitForVisibleElement(By.xpath("//h2[@class='c-search-page__title']"));
        if (driver.findElement(By.xpath("//*[@class='gn-close-button-rota-fuga']")).isDisplayed()) {
            btnClick(By.xpath("//*[@class='gn-close-button-rota-fuga']"));
        }
    }

    public void errorMessageResult() {
        //Validate error message
        waitForVisibleElement(By.xpath("//*[contains(text(),'Não há resultados para a busca')]"));
        waitForVisibleElement(By.xpath("//*[contains(text(),'Tente novamente com outra palavra')]"));
    }

    public void searchSugestions() {
        waitForVisibleElement(By.xpath("//*[@class='c-search-page__title']"));

    }

    public void expectedResult() {
        // Search for Expected Result
        int contador = 2;
        while (true) {
            try {
                driver.findElement(By.xpath("//*[@class='c-search-page__result-title' and (contains(text(),'Posso contratar a condição de recebimento de 2% para qualquer maquininha?'))]"));
                break;
            } catch (Exception e) {
                waitForPageLoad();
                btnClick(By.xpath("//*[@class='page-numbers' and (contains(text()," + contador + "))]"));
                contador++;
            }
        }
    }
}