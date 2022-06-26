package io.github.tolisso.sasha.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class ScreenshotService {

    synchronized public byte[] makeScreenshot(int width, int height, double timeout, String url) {
        System.out.println("Performed request with parameters");
        System.out.println("    width: " + width);
        System.out.println("    height: " + height);
        System.out.println("    timeout: " + timeout);
        System.out.println("    url: " + url);

        final ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("no-sandbox");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("window-size=4000,8000");
        final WebDriver driver;
        try {
            final URL driverUrl = new URL("http://selenium:4444/wd/hub");
            driver = new RemoteWebDriver(driverUrl, options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().setSize(new Dimension(width, height));
        try {
            driver.get(url);
            TimeUnit.MILLISECONDS.sleep((long) (timeout * 1000));
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (InterruptedException exc) {
            throw new RuntimeException(exc);
        } finally {
            driver.quit();
        }
    }
}
