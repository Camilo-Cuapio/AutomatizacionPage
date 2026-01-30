package EjerciciosPagina;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EjercicioCompleto {
    private WebDriver driver;

    @Before
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
        pass.sendKeys("secret_sauce");
        pass.submit();

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("inventory.html")) {
            System.out.println("se logeo correctamente");
        } else {
            System.out.println("No se logeo ");


            WebElement error = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
            String actualError = error.getText();
            String expectedError = "Epic sadface: Username and password do not match any user in this service";
            if (actualError.contains("Epic sadface: Username and password do not match any user in this service")) {
                System.out.println("el error es correcto");
            } else {
                System.out.println("No es correcto el error");
            }

            List<WebElement> xUsu = driver.findElements(By.cssSelector("#login_button_container > div > form>div:nth-child(1)>svg"));
            if (xUsu.size() == 1) {
                System.out.println("se visualiza la X de usuario");
            }
            List<WebElement> xPass = driver.findElements(By.cssSelector("#login_button_container > div > form>div:nth-child(2)>svg"));
            if (xPass.size() == 1) {
                System.out.println("se visualiza la x password");
            }
            List<WebElement> xError = driver.findElements(By.cssSelector(".error-message-container>h3>button>svg"));
            if (xError.size() == 1) {
                System.out.println("se visualiza x de mensaje de error");
            }

        }
        List<String> expectedProductos = new ArrayList<>();
        expectedProductos.add("Test.allTheThings() T-Shirt (Red)");
        expectedProductos.add("Sauce Labs Backpack");
        expectedProductos.add("Sauce Labs Bike Light");
        expectedProductos.add("Sauce Labs Fleece Jacket");
        expectedProductos.add("Sauce Labs Bolt T-Shirt");
        expectedProductos.add("Sauce Labs Onesie");

        System.out.println("lista de productos esperados" + expectedProductos);

        Collections.sort(expectedProductos);
        System.out.println("lista de productos esperados ordenados");

        List<WebElement> actualProductosElement = driver.findElements(By.cssSelector(".inventory_item_name"));
        List<String> actualProductos = new ArrayList<>();
        for (WebElement productos : actualProductosElement) {
            actualProductos.add(productos.getText());
        }
        if (expectedProductos.size() == actualProductos.size()) {
            System.out.println("el numero de productos es: " + actualProductos.size());
        } else {
            System.out.println("no son el mismo numero de productos");
        }
        Boolean flag = true;
        for (int i = 0; i < expectedProductos.size(); i++) {
            if (!expectedProductos.get(i).equals(actualProductos.get(i))) {
                flag = false;
                break;
            }
        }if (flag==true) {
            System.out.println("coinciden los id");
        } else {
            System.out.println("No coinciden los id");
        }
        System.out.println("los esperados: "+expectedProductos);
        System.out.println("los actuales: "+actualProductos);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}















