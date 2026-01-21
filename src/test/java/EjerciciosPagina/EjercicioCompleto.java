package EjerciciosPagina;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EjercicioCompleto {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void UsuLog() {
        WebElement usu = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        usu.click();
        usu.sendKeys("standard_user");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        pass.click();
        pass.sendKeys("secret_sauc");
        pass.submit();

        String validLog = driver.getCurrentUrl();
        System.out.println("la pagina es: " + validLog);
        if (validLog.contains("inventory.html")) {
            System.out.println("se ingreso a la pagina correctamente");
        } else {
            System.out.println("No se ingreso correctamente ");

            WebElement error = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"));
            String actualError = error.getText();
            String expectedError = "Epic sadface: Username and password do not match any user in this service";
            if (expectedError.equals(actualError)) {
                System.out.println("mensaje de error correcto");



            }

List<WebElement> xusu=driver.findElements(By.cssSelector("#login_button_container > div > form > div:nth-child(1) > svg"));
        if (xusu.size()==1){
            System.out.println("se visualiza la x");
        }
        }
    }

    @AfterTest
    public void cerrar() {
        driver.close();
    }
}





