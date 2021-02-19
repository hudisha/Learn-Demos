package AppPages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.openqa.selenium.By.xpath;

public class GoodSalesHomePage{

    //方案1：调用方式
    AndroidDriver driver=BasePage.getInstance();

    /**
     //方案2：调用方式
     AndroidDriver driver=BasePage.lanchDriver();
     */
    //<editor-fold desc="首先定义查找方法">
    private By byXiaoShouKaiDan=xpath("//*[@text='销售开单']");

    public GoodSalesHomePage() throws MalformedURLException{
    }

    public void clickXuanZeShangPin() throws InterruptedException{
        driver.findElement(xpath("//*[@text='选择商品']")).click();
        Thread.sleep(2000);
    }

    public void clickJieSuan() throws InterruptedException{
        driver.findElement(xpath("//*[@text='结算']")).click();
        Thread.sleep(3000);
    }
}
