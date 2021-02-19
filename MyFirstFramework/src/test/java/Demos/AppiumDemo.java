package Demos;

import io.appium.java_client.android.AndroidDriver;
import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import AppPages.*;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumDemo {

    @BeforeMethod
    public void setUp(){

    }
    @Test
    public void MyFirstGoodsSales() throws MalformedURLException, InterruptedException {

        String loginUser="18611200000";
        String loginPW="123456";
        //登录
        LoginPage loginPage=new LoginPage();
        loginPage.loginIn(loginUser,loginPW);

        HomePage homePage=new HomePage();
        homePage.clickXiaoShouKaiDan();

        //Assert.isTrue(driver.findElement(xpath("//*[@text='选择商品']")).isEnabled(),"进入销售开单成功！");

        GoodSalesHomePage gsHomePage=new GoodSalesHomePage();
        gsHomePage.clickXuanZeShangPin();

        SelectGoodsListPage selectGoodPage=new SelectGoodsListPage();
        selectGoodPage.clickTheTootipImage();
        selectGoodPage.selectfirstGoods();
        selectGoodPage.clickXuanHaoLe();

        gsHomePage.clickJieSuan();

        JieSuanPage jieSuanPage=new JieSuanPage();
        jieSuanPage.clickSave();

        KaiDanChengGongPage kdChengGongPage=new KaiDanChengGongPage();
        Assert.isTrue(kdChengGongPage.IsKaiDanChengGong(),"第一单销货单开单成功！");
    }
    @AfterMethod
    public void tearDown() throws MalformedURLException{
        //方案1：调用方式
        AndroidDriver driver=BasePage.getInstance();
        driver.quit();
    }
}
