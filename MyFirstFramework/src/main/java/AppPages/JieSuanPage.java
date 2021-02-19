package AppPages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.openqa.selenium.By.xpath;

public class JieSuanPage{
    //方案1：调用方式
    AndroidDriver driver=BasePage.getInstance();

    /**
     //方案2：调用方式
     AndroidDriver driver=BasePage.lanchDriver();
     */
    //<editor-fold desc="首先定义查找方法">
    private By byJieSuan=xpath("//*[@text='保存']");

    public JieSuanPage() throws MalformedURLException{
    }

    public void clickSave() throws InterruptedException{
        driver.findElement(xpath("//*[@text='保存']")).click();
        Thread.sleep(3000);
    }
}
