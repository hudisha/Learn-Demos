package Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;

import java.time.Duration;

public class TouchActionUtilities {
    public static void SwipeFromPointToPoint(AndroidDriver driver, Point startP, Point endP) throws InterruptedException {
        //向下滑动
        TouchAction touchAction = new TouchAction(driver);
        //press：按压某一个坐标 moveTo:滑动到某一个点 release:手指的释放
        //滑动的起始点坐标
        PointOption pointOption1 = PointOption.point(startP.x,startP.y);
        //滑动的终止点坐标,向下滑动x轴不变
        PointOption pointOption2 = PointOption.point(endP.x,endP.y);
        //调整滑动的时间
        //ofMillis-毫秒，1000毫秒=1秒
        Duration duration = Duration.ofMillis(1000);
        WaitOptions waitOptions = WaitOptions.waitOptions(duration);
        //waitAction方法需要传入waitOption类型的参数
        touchAction.press(pointOption1).waitAction(waitOptions).moveTo(pointOption2).release().perform();
    }
}
