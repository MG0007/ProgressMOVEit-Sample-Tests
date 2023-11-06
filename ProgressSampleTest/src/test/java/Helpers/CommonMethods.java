package Helpers;

import Resources.ConstantsLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;


public class CommonMethods {

    ConstantsLandingPage constsLP = new ConstantsLandingPage();

    public WebDriverWait waitMilliseconds(WebDriver driver, int howLong){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(howLong));
        return wait;
    }
    public WebDriverWait waitSeconds(WebDriver driver, int howLong){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(howLong));
        return wait;
    }
    public WebElement getElementByNameTag(WebDriver driver, String name, @Nullable WebDriverWait wait){
        if(wait != null){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }
    public WebElement getElementById(WebDriver driver, String id, @Nullable WebDriverWait wait){
        if(wait != null){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        }
        return driver.findElement(By.id(id));
    }
    public WebElement getElementCssSelector(WebDriver driver, String cssSelector, @Nullable WebDriverWait wait){
        if(wait != null){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        }
        return driver.findElement(By.cssSelector(cssSelector));
    }
    public WebElement getElementXpathSelector(WebDriver driver, String xpath, @Nullable WebDriverWait wait){
        if (wait != null){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        }
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement getElementNameSelector(WebDriver driver, String nametag,@Nullable WebDriverWait wait){
        if(wait != null){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(nametag)));
        }
        return driver.findElement(By.name(nametag));
    }
    public void login (WebDriver driver, String usernameLocator, String passwordLocator,
                       String signOnButtonLocator, WebDriverWait wait){
        WebElement usernameField = getElementById(driver, usernameLocator, wait);
        WebElement passwordField = getElementById(driver, passwordLocator, wait);
        WebElement signOnButton = getElementById(driver, signOnButtonLocator, wait);

        usernameField.sendKeys(constsLP.USER_NAME);
        passwordField.sendKeys(constsLP.PASSWORD);
        signOnButton.click();
    }
}
