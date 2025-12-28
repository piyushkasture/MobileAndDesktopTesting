package assignment;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTests {

    @DataProvider(name = "smokeData", parallel = true)
    public Object[][] smokeData() {
        return new Object[][]{
                {"admin", "admin123"},
                {"user1", "pass1"},
                {"user2", "pass2"}
        };
    }

    // Only this test will be run from testng.xml in parallel
    @Test(groups = {"smoke"}, dataProvider = "smokeData")
    public void smokeLoginDataDriven(String user, String pass) {
        System.out.println("smokeLoginDataDriven | thread=" + Thread.currentThread().getId()
                + " | user=" + user);
        Assert.assertNotNull(user);
        Assert.assertTrue(pass.length() > 0);
    }

    @Test(groups = {"smoke"})
    public void smokeHomePageLoads() {
        System.out.println("smokeHomePageLoads | thread=" + Thread.currentThread().getId());
        Assert.assertTrue(true);
    }

    @Test(groups = {"smoke"})
    public void smokeLogout() {
        System.out.println("smokeLogout | thread=" + Thread.currentThread().getId());
        Assert.assertTrue(true);
    }
}
