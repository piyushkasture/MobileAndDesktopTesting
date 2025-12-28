package automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ArithmeticSteps {

    private int a;
    private int b;
    private int result;

    @Given("I have numbers {int} and {int}")
    public void i_have_numbers(int n1, int n2) {
        a = n1;
        b = n2;
        System.out.println("Given numbers: a=" + a + ", b=" + b);
    }

    @When("I add them")
    public void i_add_them() {
        result = a + b;
        System.out.println("Computed addition: " + result);
    }

    @When("I multiply them")
    public void i_multiply_them() {
        result = a * b;
        System.out.println("Computed multiplication: " + result);
    }

    @When("I divide them")
    public void i_divide_them() {
        result = a / b;
        System.out.println("Computed division: " + result);
    }

    @Then("result should be {int}")
    public void result_should_be(int expected) {
        System.out.println("Verify expected=" + expected + ", actual=" + result);
        Assert.assertEquals(expected, result);
        System.out.println("PASS");
    }
}
