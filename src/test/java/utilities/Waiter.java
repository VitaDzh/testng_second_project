package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    public static void pause(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitForVisibilityWebElement(WebDriver driver, WebElement element, int seconds){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilTitlesIs(WebDriver driver, int seconds, String title){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.titleIs(title));
    }

    public static void waitUntilTextToBePresentInElement(WebDriver driver, int seconds, WebElement element, String text){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilPageIsLoaded(WebDriver driver, int seconds, String url){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.urlToBe(url));
    }


}

