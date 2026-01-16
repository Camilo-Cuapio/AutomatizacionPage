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

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void logeo(){
     WebElement usu= driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
     usu.click();
     usu.sendKeys("standard_user");
     WebElement pass= driver.findElement(By.xpath("//*[@name=\"password\"]"));
     pass.click();
     pass.sendKeys("secret_sauce");
pass.submit();

String validarLog= driver.getCurrentUrl();
        System.out.println("la url es: "+validarLog);
        if (validarLog.contains("inventory.html")){
            System.out.println("logeo correcto");
        }else {
            System.out.println("logeo incorrecto");
        }

    }
}
