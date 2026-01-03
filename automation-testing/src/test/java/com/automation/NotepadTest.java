package com.automation;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;

public class NotepadTest {

    private static WindowsDriver NotepadSession = null;
    private static WebElement EditBox = null;

    @BeforeClass
    public static void setup() throws Exception {
        System.out.println("== Setup started ==");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        capabilities.setCapability("deviceName", "WindowsPC");

        NotepadSession = new WindowsDriver(
                new URL("http://127.0.0.1:4723"),
                capabilities
        );
        NotepadSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        System.out.println("Notepad session created.");

        EditBox = NotepadSession.findElementByClassName("Edit");
        Assert.assertNotNull("Edit box not found", EditBox);

        System.out.println("Edit box found. Setup done.");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("== Teardown started ==");
        if (NotepadSession != null) {
            NotepadSession.closeApp();
            NotepadSession.quit();
            System.out.println("Notepad closed.");
        }
    }

    @Test
    public void writeAndSaveFile() {
        WindowsDriver DesktopSession = null;

        try {
            System.out.println("Test started: writeAndSaveFile");

            EditBox.sendKeys("Automated text for saving.");
            System.out.println("Typed text in Notepad.");

            Actions actions = new Actions(NotepadSession);
            actions.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
            System.out.println("Pressed Ctrl+S (Save As should open).");

            DesiredCapabilities rootCapabilities = new DesiredCapabilities();
            rootCapabilities.setCapability("app", "Root");

            DesktopSession = new WindowsDriver(
                    new URL("http://127.0.0.1:4723"),
                    rootCapabilities
            );
            DesktopSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println("Root session created.");

            WebElement saveAsWindow;
            try {
                saveAsWindow = DesktopSession.findElement(By.name("Save As"));
                System.out.println("Save As window found by name.");
            } catch (Exception e) {
                saveAsWindow = DesktopSession.findElement(By.xpath("//Window[@ClassName='#32770']"));
                System.out.println("Save As window found by ClassName #32770.");
            }
            Assert.assertNotNull("Save As window not found!", saveAsWindow);

            WebElement fileNameBox = saveAsWindow.findElement(By.xpath(".//Edit[@Name='File name:']"));
            Assert.assertNotNull("File name textbox not found!", fileNameBox);
            System.out.println("File name textbox found.");

            fileNameBox.click();
            fileNameBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            fileNameBox.sendKeys(Keys.BACK_SPACE);
            fileNameBox.sendKeys("vvv.txt");
            System.out.println("Entered filename: piyushsss.txt");

            saveAsWindow.findElement(By.name("Save")).click();
            System.out.println("Clicked Save button. Test completed.");

        } catch (Exception e) {
            System.err.println("ERROR in writeAndSaveFile: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("File save failed! " + e.getMessage());
        } finally {
            if (DesktopSession != null) {
                try {
                    DesktopSession.quit();
                    System.out.println("Root session quit.");
                } catch (Exception ignored) {}
            }
        }
    }
}
