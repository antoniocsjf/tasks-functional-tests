package br.sp.jessie.tasks.functional.prod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HealthCheckIT {

    @Test
    public void healthCheck() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        @SuppressWarnings("deprecation")
        WebDriver driver = new ChromeDriver(cap);
        try {
            driver.navigate().to("http://192.168.15.55:9999/tasks/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String version = driver.findElement(By.id("version")).getText();
            System.out.println(version);
            Assert.assertTrue(version.startsWith("build"));
        } finally {
            driver.quit();
        }  
    }
}
