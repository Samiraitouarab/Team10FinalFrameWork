package testSignIn;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SignIn;
import reporting.ApplicationLog;
import reporting.TestLogger;

public class TestSignIn extends CommonAPI {

    @Test
    public void signIn(){
        ApplicationLog.epicLogger();
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        SignIn signIn = PageFactory.initElements(driver,SignIn.class);
        signIn.signInAccoount("samir_aitouarab@yahoo.fr","123456");
    }
}
