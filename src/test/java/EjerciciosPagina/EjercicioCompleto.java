package EjerciciosPagina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjercicioCompleto {
private WebDriver driver;

@Before
    public void serUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");

    }
    @Test
    public void loginU(){
    WebElement usu= driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
    usu.click();
    usu.sendKeys("standard_user");
    WebElement pass= driver.findElement(By.xpath("//*[@id=\"password\"]"));
    pass.click();
    pass.sendKeys("secret_sauce");
    pass.submit();

String valiUsu= driver.getCurrentUrl();
        System.out.println("la url es: "+valiUsu);
        if (valiUsu.contains("inventory.html")){
            System.out.println("logeo fue exitoso");
        }else{
            System.out.println("el logeo no fue exitoso");

WebElement errorMensajeElemento=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
      actualError
Mensaje=errorMensajeElemento.getText();
      String expectedErrorMensaje="Epic sadface: Username and password do not match any user in this service";
        if (actualErrorMensaje.equals(expectedErrorMensaje)){
            System.out.println("el mensaje de error es correcto");
        }else{
            System.out.println("el mensaje de error no es correcto");
        }
    }
}
}
