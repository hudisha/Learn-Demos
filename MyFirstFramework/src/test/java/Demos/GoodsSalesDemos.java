package Demos;

import AppPages.*;
import io.appium.java_client.android.AndroidDriver;
import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class GoodsSalesDemos {

    @BeforeMethod
    public void setUp(){

    }
    @Test
    public void MoreThan10GoodsSales() throws MalformedURLException, InterruptedException {

        String loginUser="18611200000";
        String loginPW="123456";
        //登录
        LoginPage loginPage=new LoginPage();
        loginPage.loginIn(loginUser,loginPW);

        //首页点击销售开单
        HomePage homePage=new HomePage();
        homePage.clickXiaoShouKaiDan();

        //销售开单首页
        GoodSalesHomePage gsHomePage=new GoodSalesHomePage();
        gsHomePage.clickXuanZeShangPin();

        //选择商品列表页面，选择10个商品
        SelectGoodsListPage selectGoodPage=new SelectGoodsListPage();
        selectGoodPage.clickTheTootipImage();
        selectGoodPage.selectNGoods(10);
        selectGoodPage.clickXuanHaoLe();

        //进行结算，结算并保存
        gsHomePage.clickJieSuan();

        JieSuanPage jieSuanPage=new JieSuanPage();
        jieSuanPage.clickSave();

        //最后验证开单是否成功
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
