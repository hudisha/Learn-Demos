package Utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class FindElementUtilities {

    public static WebElement findElement(AndroidDriver driver, By by, int mSeconds){
        do{
            try{
                if(driver.findElement(by)!=null) break;
            }catch(Exception e){
                Logger.getLogger(e.getMessage());
            }
            mSeconds+=1000;
        }while(mSeconds<=10000);

        return driver.findElement(by);
    }
}
