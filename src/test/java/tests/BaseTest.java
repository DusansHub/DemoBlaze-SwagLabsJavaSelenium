package tests;

import helpers.BaseHelper;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;


public class BaseTest extends BaseHelper
{
    @Before
    public void testInit()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void testTearDown() {
        driver.close();
        driver.quit();
    }

}