import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginPageTest extends BaseTestClass {

    @ParameterizedTest
    @CsvSource({"Asen,12345,Hello Asen, let's complete the test form:",
                "@sen,12345,Hello @sen, let's complete the test form:"})
    public void CorrectCredentials(String username, String password, String expectedMessage) throws InterruptedException {
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);
        Thread.sleep(2000);


        Assert.assertEquals(expectedMessage, login.AssertMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Asen.csv")
    public void CorrectCredentialsCSV(String username, String password, String expectedMessage) throws InterruptedException {
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);
        Thread.sleep(2000);


        Assert.assertEquals(expectedMessage, login.AssertMessage());
    }

    @ParameterizedTest
    @CsvSource({"Asen,2345,Password is invalid",
            "@sen,2345,Password is invalid"})

    public void InvalidPass(String username, String password, String invalidPs) throws InterruptedException {
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);
        Thread.sleep(2000);


        Assert.assertEquals(invalidPs, login.AssertInvalidPs());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/InvalidPass.csv")

    public void InvalidPassCSV(String username, String password, String invalidPs) throws InterruptedException {
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);
        Thread.sleep(2000);


        Assert.assertEquals(invalidPs, login.AssertInvalidPs());
    }

    @ParameterizedTest
    @CsvSource({"'' ,12345,Hint: password is 12345",
            "'',12345,Hint: password is 12345"})

    public void InvalidName(String username, String password, String nameMess) throws InterruptedException {
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);
        Thread.sleep(2000);


        Assert.assertEquals(nameMess, login.AssertName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/EmptyName.csv")

    public void InvalidNameFile(String username, String password, String invalidName) throws InterruptedException {
        LoginPage login= new LoginPage(driver, wait);
        login.NavigateToURL();
        login.Login(username, password);
        Thread.sleep(2000);


        Assert.assertEquals(invalidName, login.AssertName());
    }

}
