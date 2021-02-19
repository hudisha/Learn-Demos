package AppPages;

import Utilities.FindElementUtilities;
import Utilities.TouchActionUtilities;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import javafx.util.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SelectGoodsListPage{
    //方案1：调用方式
    AndroidDriver driver=BasePage.getInstance();

    /**
     //方案2：调用方式
     AndroidDriver driver=BasePage.lanchDriver();
     */
    //<editor-fold desc="首先定义查找方法">
    private By byXiaoShouKaiDan=xpath("//*[@text='销售开单']");
    private By byXuanHaoLe=xpath("//*[@text='选好了']");

    public SelectGoodsListPage() throws MalformedURLException{
    }

    public void clickTheTootipImage() throws InterruptedException{
        driver.findElement(xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")).click();
        Thread.sleep(1000);
        driver.findElement(xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")).click();
        Thread.sleep(1000);
    }

    public void selectfirstGoods() throws InterruptedException{
        Thread.sleep(3000);
        WebElement goodsList=driver.findElement(xpath("//*[@class='androidx.viewpager.widget.ViewPager']//*[@class='android.widget.ScrollView']"));

        goodsList.findElements(By.className("android.widget.EditText")).get(0).sendKeys("1");


        Thread.sleep(1000);
    }

    public void selectNGoods(int n) throws InterruptedException {
        Thread.sleep(3000);
        WebElement goodsList=driver.findElement(xpath("//*[@class='androidx.viewpager.widget.ViewPager']//*[@class='android.widget.ScrollView']"));
        List<WebElement> goodsCards=goodsList.findElements(By.className("android.widget.EditText"));

        /**
        if(n>goodsCards.size()) {
            System.out.println("商品数量太少！");
        }
         */
        for(int i=0;i<n;i++){
            List<WebElement> goodsLists=goodsList.findElements(By.className("android.widget.EditText"));

            goodsLists.get(i).sendKeys("1");

            Thread.sleep(1000);
            if(i>3){
                int X=goodsLists.get(i).getLocation().x;
                int end_Y=goodsLists.get(i).getLocation().y;
                int start_Y=goodsLists.get(i+1).getLocation().y;
                TouchActionUtilities.SwipeFromPointToPoint(driver, new Point(X-50,start_Y),new Point(X-50,end_Y));
            }
       }
    }

    public void clickXuanHaoLe() throws InterruptedException{
        //driver.findElement(xpath("//*[@text='选好了']")).click();
        FindElementUtilities.findElement(driver,byXuanHaoLe,3000);
        Thread.sleep(2000);
    }
}
