package AppPages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.openqa.selenium.By.xpath;

public class KaiDanChengGongPage{

    //方案1：调用方式
    AndroidDriver driver=BasePage.getInstance();

    /**
     //方案2：调用方式
     AndroidDriver driver=BasePage.lanchDriver();
     */
    //<editor-fold desc="首先定义查找方法">
    private By byXiaoShouKaiDan=xpath("//*[@text='保存成功']");

    public KaiDanChengGongPage() throws MalformedURLException{
    }

    public boolean IsKaiDanChengGong() throws InterruptedException{
        Thread.sleep(1000);
        return driver.findElement(xpath("//android.widget.TextView[@text='保存成功']")).isEnabled();
    }
}
