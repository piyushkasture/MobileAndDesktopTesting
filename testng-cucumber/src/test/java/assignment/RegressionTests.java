package assignment;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionTests {

    @Test(groups = {"regression"})
    public void regressionSearch() {
        System.out.println("regressionSearch | thread=" + Thread.currentThread().getId());
        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void regressionAddToCart() {
        System.out.println("regressionAddToCart | thread=" + Thread.currentThread().getId());
        Assert.assertTrue(true);
    }

    @Test(groups = {"regression"})
    public void regressionCheckout() {
        System.out.println("regressionCheckout | thread=" + Thread.currentThread().getId());
        Assert.assertTrue(true);
    }
}
