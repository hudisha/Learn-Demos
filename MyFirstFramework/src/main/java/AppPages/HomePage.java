package AppPages;

import Utilities.FindElementUtilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.openqa.selenium.By.xpath;

public class HomePage{

    //方案1：调用方式
    AndroidDriver driver=BasePage.getInstance();

    /**
     //方案2：调用方式
     AndroidDriver driver=BasePage.lanchDriver();
     */
    //<editor-fold desc="首先定义查找方法">
    private By byXiaoShouKaiDan=xpath("//*[@text='销售开单']");

    public HomePage() throws MalformedURLException{

    }

    //</editor-fold>

    public void clickXiaoShouKaiDan() throws InterruptedException{
        Thread.sleep(2000);
        //driver.findElement(byXiaoShouKaiDan).click();
        FindElementUtilities.findElement(driver,byXiaoShouKaiDan,10000).click();
        Thread.sleep(1000);
    }
}
