//package com.automation;
//
//import org.junit.*;
//import org.openqa.selenium.WebElement;
//import java.util.concurrent.TimeUnit;
//import java.net.URL;
//import io.appium.java_client.windows.WindowsDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//public class CalculatorTest {
//
//    private static WindowsDriver CalculatorSession = null;
//    private static WebElement CalculatorResult = null;
//
//    @BeforeClass
//    public static void setup() {
//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
//            CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4727"), capabilities);
//            CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//
//            CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
//            Assert.assertNotNull(CalculatorResult);
//            Thread.sleep(10000);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally {
//        }
//    }
//
//    @Before
//    public void Clear()
//    {
//        CalculatorSession.findElementByName("Clear").click();
//        Assert.assertEquals("0", _GetCalculatorResultText());
//    }
//
//    @AfterClass
//    public static void TearDown()
//    {
//        CalculatorResult = null;
//        if (CalculatorSession != null) {
//            CalculatorSession.quit();
//        }
//        CalculatorSession = null;
//    }
//
//       @Test
//       public void check()
//       {
//    	   CalculatorSession.findElementByName("Open Navigation").click();
//    	   CalculatorSession.findElementByName("Scientific Calculator").click();
//    	   CalculatorSession.findElementByName("Pi").click();
//    	   Assert.assertEquals("3.1415926535897932384626433832795", _GetCalculatorResultText());
//       }
////     @Test
////     public void Addition()
////     {
////         CalculatorSession.findElementByName("One").click();
////         CalculatorSession.findElementByName("Plus").click();
////         CalculatorSession.findElementByName("Seven").click();
////         CalculatorSession.findElementByName("Equals").click();
////         Assert.assertEquals("8", _GetCalculatorResultText());
////     }
//
////    @Test
////    public void Combination()
////    {
////        // CalculatorSession.findElementByName("Seven").click();
////        // CalculatorSession.findElementByName("Multiply by").click();
////        // CalculatorSession.findElementByName("Nine").click();
////        // CalculatorSession.findElementByName("Plus").click();
////        // CalculatorSession.findElementByName("One").click();
////        // CalculatorSession.findElementByName("Equals").click();
////        // CalculatorSession.findElementByName("Divide by").click();
////        // CalculatorSession.findElementByName("Eight").click();
////        // CalculatorSession.findElementByName("Equals").click();
////        // Assert.assertEquals("8", _GetCalculatorResultText());
////    }
//
//    // @Test
//    // public void Division()
//    // {
//    //     CalculatorSession.findElementByName("Eight").click();
//    //     CalculatorSession.findElementByName("Eight").click();
//    //     CalculatorSession.findElementByName("Divide by").click();
//    //     CalculatorSession.findElementByName("One").click();
//    //     CalculatorSession.findElementByName("One").click();
//    //     CalculatorSession.findElementByName("Equals").click();
//    //     Assert.assertEquals("8", _GetCalculatorResultText());
//    // }
//
//    // @Test
//    // public void Multiplication()
//    // {
//    //     CalculatorSession.findElementByName("Nine").click();
//    //     CalculatorSession.findElementByName("Multiply by").click();
//    //     CalculatorSession.findElementByName("Nine").click();
//    //     CalculatorSession.findElementByName("Equals").click();
//    //     Assert.assertEquals("81", _GetCalculatorResultText());
//    // }
//
//    // @Test
//    // public void Subtraction()
//    // {
//    //     CalculatorSession.findElementByName("Nine").click();
//    //     CalculatorSession.findElementByName("Minus").click();
//    //     CalculatorSession.findElementByName("One").click();
//    //     CalculatorSession.findElementByName("Equals").click();
//    //     Assert.assertEquals("8", _GetCalculatorResultText());
//    // }
//
//    protected String _GetCalculatorResultText()
//    {
//        // trim extra text and whitespace off of the display value
//        return CalculatorResult.getText().replace("Display is", "").trim();
//    }
//
//}