package AppPages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.bug92.TestBase;

import java.net.MalformedURLException;

import static org.openqa.selenium.By.xpath;

//方案1：单例模式
public class LoginPage{
    /**
     * //方案2：继承方式，直接调用父类静态成员
     * public class LoginPage extends BasePage{
     */
//方案1：调用方式
    AndroidDriver driver = BasePage.getInstance();

    /**
     * //方案2：调用方式
     * AndroidDriver driver=BasePage.lanchDriver();
     */
    //<editor-fold desc="首先定义查找方法">
    private By byZhiDaoLa = xpath("//*[@text='知道了']");
    private By byLoginName = By.xpath("//*[@text='请输入手机号或邮箱']");
    private By byLoginPW = By.xpath("//*[@text='请输入密码']");
    private By byLoginBtn = By.xpath("//*[@text='登录']");

    public LoginPage() throws MalformedURLException{
    }

    //</editor-fold>

    public void clickZhiDaoLe() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(byZhiDaoLa).click();
        Thread.sleep(1000);
    }

    public void setLoginName(String loginAccount) throws InterruptedException{
        driver.findElement(byLoginName).sendKeys(loginAccount);
        Thread.sleep(1000);
    }

    public void setLoginPW(String loginPassword) throws InterruptedException{
        driver.findElement(byLoginPW).sendKeys(loginPassword);
        Thread.sleep(1000);
    }

    public void clickLoginBtn() throws InterruptedException{
        driver.findElement(byLoginBtn).click();
        Thread.sleep(1000);
    }

    public void loginIn(String userName, String userPW) throws InterruptedException{
        this.clickZhiDaoLe();
        this.setLoginName(userName);
        this.setLoginPW(userPW);
        this.clickLoginBtn();
        Thread.sleep(5000);
    }
}
