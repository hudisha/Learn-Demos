package AppPages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.MutableCapabilities;
import test.tmp.Base;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage{

    //方案1：单例模式
    private BasePage(){

    }

    private static AndroidDriver driver=null;
    public static AndroidDriver getInstance() throws MalformedURLException{
        if(driver==null){
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),getDriverCapabilities());
        }
        return driver;
    }

    /**
     //方案2，直接父类定义静态方法
     public BasePage(){

     }

     public static AndroidDriver theOneDriver;

     public static AndroidDriver lanchDriver() throws MalformedURLException, InterruptedException{
     if (theOneDriver==null){
     theOneDriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),getDriverCapabilities());
     Thread.sleep(5000);
     }
     return theOneDriver;
     }
     */

    /**
     * 配置启动项
     * @return 启动项列表
     */
    private static DesiredCapabilities getDriverCapabilities(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","HUAWEI Mate 40 Pro");//启动哪种设备，模拟器或者真机
        cap.setCapability("automationName","Appium");//使用哪种自动化
        cap.setCapability("platformName","Android");//测试哪种平台，Android或者IOS
        cap.setCapability("platformVersion","10.0.0");//系统的版本，
        cap.setCapability("appPackage","com.chanjet.goodbusiness");//测试的app包
        cap.setCapability("appActivity",".MainActivity");//测试的app的Activity名字

        return cap;
    }

}
