package EjerciciosPagina;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EjercicioCompleto {
    private WebDriver driver;
// se agrega rama para repaso
    @BeforeTest
    public void serUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void loginU() {
        WebElement usu = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        usu.click();
        usu.sendKeys("standard_user");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        pass.click();
        pass.sendKeys("secret_sauce");
        pass.submit();

        String validlog = driver.getCurrentUrl();
        System.out.println("la pagina es: " + validlog);
        if (driver.getCurrentUrl().contains("inventory.html")) {
            System.out.println(" se logeo correctamente");

        } else {
            System.out.println("se logeo incorrectamente");

            WebElement mensajeErrorElem = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
            String actualError = mensajeErrorElem.getText();
            String experadoError = "Epic sadface: Username and password do not match any user in this service";
            if (actualError.equals(experadoError)) {
                System.out.println("el mensaje de error es correcto");
            }

            else {
                System.out.println("mensaje de error incorrecto");
            }


            List<WebElement> xUsu = driver.findElements(By.cssSelector("#login_button_container > div > form > div:nth-child(1) > svg"));
            if (xUsu.size() == 1) {
                System.out.println("se visualiza xusuario");
            } else {
                System.out.println("No se muestra una X");
            }
            List<WebElement> xPass = driver.findElements(By.cssSelector("#login_button_container > div > form > div:nth-child(2) > svg"));
            if (xPass.size()==1){
                System.out.println("se visualiza xpass");
            }else {
                System.out.println("No se muestra x en pass");
            }
            List<WebElement> xMensajeError=driver.findElements(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button > svg > path"));
        if(xMensajeError.size()==1){
            System.out.println("xmensaje de error si se visualiza");
        }else{
            System.out.println("xmensaje de error no se visualiza");
        }

        }
List<String> expectedProductos=new ArrayList<>();
        expectedProductos.add("Test.allTheThings() T-Shirt (Red)");
        expectedProductos.add("Sauce Labs Backpack");
        expectedProductos.add("Sauce Labs Bike Light");
        expectedProductos.add("Sauce Labs Bolt T-Shirt");
        expectedProductos.add("Sauce Labs Fleece Jacket");
        expectedProductos.add("Sauce Labs Onesie");

        System.out.println("la lista de productos experados es: "+expectedProductos);

        Collections.sort(expectedProductos);
        System.out.println("lista ordenada de productos experados"+expectedProductos);

        List<WebElement> actualProductElemen=driver.findElements(By.xpath("//div[@class=\"inventory_item_name \"]"));
        List<String> actualProduct=new ArrayList<String>();
        for (WebElement product: actualProductElemen){
            actualProduct.add(product.getText());
        }if (expectedProductos.size()==actualProduct.size()){
            System.out.println("el numero de productos es: "+actualProduct.size());
        }else {
            System.out.println("no coincide el numero de productos");
        }
boolean flag=true;
        for (int i=0;i<expectedProductos.size();i++){
            if (!expectedProductos.get(i).equals(actualProduct.get(i))){
                flag=false;
                break;
            }

        }if(flag){
            System.out.println("si coinciden los productos");
        }else {

        }
        System.out.println("productos esperados"+expectedProductos);
        System.out.println("productos actuales"+actualProduct);

    }
}
