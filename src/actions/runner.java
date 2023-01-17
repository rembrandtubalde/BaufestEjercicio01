package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
public class runner {
    public static void getRun() throws Exception {

        String producto="";
        WebDriver driver;
        String baseURL = "https://www.demoblaze.com/index.html";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
        //Abrir el navegador chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navegar en la pagina
        driver.get(baseURL);
        try{
            WebElement btnsignUp = driver.findElement(By.xpath("//*[@id=\"signin2\"]"));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", btnsignUp);
    //---------------------------------------------------------------------------------------------------
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
            boolean exist = driver.findElements(By.xpath("//*[@id=\"signin2\"]")).size() != 0;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //--------------------------------------------------------------------------------------------------
            if(exist) {
                for (int i = 0; i <= 20; i++) {
                    driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).clear();
                    driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).clear();
                    WebElement intousr = driver.findElement(By.xpath("//*[@id=\"sign-username\"]"));
                    intousr.sendKeys("piero"+i);
                    WebElement intoclv = driver.findElement(By.xpath("//*[@id=\"sign-password\"]"));
                    intoclv.sendKeys("j123456");
     //----------------------------------------------------------------------------------------------------
                    WebDriverWait WaitVar = new WebDriverWait(driver, 10);
                    WaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")));
                    WebElement btnCont = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
                    btnCont.click();
                    Thread.sleep(3000);

                    Alert alert = driver.switchTo().alert();
                    String alerta = alert.getText();
                    alert.accept();
                    if (alerta.equalsIgnoreCase("This user already exist.")) {
                        continue;
                    }
                    WebDriverWait WaitVar1 = new WebDriverWait(driver, 10);
                    WaitVar1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login2\"]")));
                    WebElement btnLogIn = driver.findElement(By.xpath("//*[@id=\"login2\"]"));
                    btnLogIn.click();

                    driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
                    boolean existusr = driver.findElements(By.xpath("//*[@id=\"loginusername\"]")).size() != 0;
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    if (existusr) {
                        WebElement logousr = driver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
                        logousr.sendKeys("pierr"+i);
                        WebElement logoclv = driver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
                        logoclv.sendKeys("j123456");

                        WebDriverWait WaitVar2 = new WebDriverWait(driver, 10);
                        WaitVar2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login2\"]")));
                        WebElement btnIn = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
                        btnIn.click();
                        break;
                    }
                }
                Thread.sleep(3000);
                WebDriverWait WaitVar2 = new WebDriverWait(driver, 10);
                WaitVar2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logout2\"]")));
                WebElement btnIn = driver.findElement(By.xpath("//*[@id=\"logout2\"]"));
                btnIn.click();

                driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
                boolean encont = driver.findElements(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).size() != 0;
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                if(encont) {
                    WebDriverWait WaitVar3 = new WebDriverWait(driver, 10);
                    WaitVar3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")));
                    WebElement btnlap = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"));
                    btnlap.click();
                    Thread.sleep(3000);
                    WebDriverWait WaitVar4 = new WebDriverWait(driver, 10);
                    WaitVar4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/a/img")));
                    WebElement btncomp = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/a/img"));
                    btncomp.click();
                    WebDriverWait WaitVar5 = new WebDriverWait(driver, 10);
                    WaitVar5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
                    WebElement btnadd = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
                    btnadd.click();
                    WebDriverWait WaitVar6 = new WebDriverWait(driver, 10);
                    WaitVar6.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartur\"]")));
                    WebElement btncart = driver.findElement(By.xpath("//*[@id=\"cartur\"]"));
                    btncart.click();

                    WebDriverWait WaitVar1 = new WebDriverWait(driver, 10);
                    WaitVar1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tbodyid\"]/tr/td[4]/a")));
                    WebElement prod = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
                    producto = prod.getText();
                    JOptionPane.showMessageDialog(null,"producto en el carrito: "+producto);

                }
            }
}catch(Exception e) {
            e.printStackTrace(); }
    }
}