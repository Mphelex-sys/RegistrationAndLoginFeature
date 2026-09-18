package registrationandloginfeature;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationAndLoginFeatureTest {

    // =========================================================
    // USERNAME TEST
    // =========================================================

    @Test
    public void testUsernameIncorrectlyFormatted() {

        // Username does NOT contain an underscore
        // and is no more than five characters long
        String username = "abcde";

        assertFalse(
                RegistrationAndLoginFeature.checkUserName(username)
        );
    }

    @Test
    public void testUsernameCorrectlyFormatted() {

        // Username contains an underscore
        // and is no more than five characters long
        String username = "abc_1";

        assertTrue(
                RegistrationAndLoginFeature.checkUserName(username)
        );
    }

    // =========================================================
    // PASSWORD TESTS
    // =========================================================

    @Test
    public void testPasswordMeetsComplexityRequirements() {

        // Test Data: Ch&sec@ke99!
        String password = "Ch&sec@ke99!";

        assertTrue(
                RegistrationAndLoginFeature.checkPasswordComplexity(password)
        );
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {

        // Test Data: password
        String password = "password";

        assertFalse(
                RegistrationAndLoginFeature.checkPasswordComplexity(password)
        );
    }

    // =========================================================
    // CELL PHONE TESTS
    // =========================================================

    @Test
    public void testCellPhoneCorrectlyFormatted() {

        // Test Data: +27838968976
        String cellphone = "+27838968976";

        assertTrue(
                RegistrationAndLoginFeature.checkCellPhoneNumber(cellphone)
        );
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {

        // Test Data: 08966553
        String cellphone = "08966553";

        assertFalse(
                RegistrationAndLoginFeature.checkCellPhoneNumber(cellphone)
        );
    }

    // =========================================================
    // LOGIN SUCCESSFUL
    // =========================================================

    @Test
    public void testLoginSuccessful() {

        // Register the test user
        RegistrationAndLoginFeature.username = "abc_1";
        RegistrationAndLoginFeature.password = "Ch&sec@ke99!";
        RegistrationAndLoginFeature.cellphone = "+27838968976";
        RegistrationAndLoginFeature.isRegistered = true;

        // Simulate keyboard input
        String testInput = "abc_1\nCh&sec@ke99!\n";

        RegistrationAndLoginFeature.input =
                new Scanner(
                        new ByteArrayInputStream(testInput.getBytes())
                );

        // Login should be successful
        assertTrue(
                RegistrationAndLoginFeature.loginUser()
        );
    }

    // =========================================================
    // LOGIN FAILED
    // =========================================================

    @Test
    public void testLoginFailed() {

        // Register the test user
        RegistrationAndLoginFeature.username = "abc_1";
        RegistrationAndLoginFeature.password = "Ch&sec@ke99!";
        RegistrationAndLoginFeature.cellphone = "+27838968976";
        RegistrationAndLoginFeature.isRegistered = true;

        // Wrong password
        String testInput = "abc_1\npassword\n";

        RegistrationAndLoginFeature.input =
                new Scanner(
                        new ByteArrayInputStream(testInput.getBytes())
                );

        // Login should fail
        assertFalse(
                RegistrationAndLoginFeature.loginUser()
        );
    }

    // =========================================================
    // USERNAME CORRECTLY FORMATTED
    // =========================================================

    @Test
    public void testUsernameCorrectFormat() {

        String username = "abc_1";

        assertTrue(
                RegistrationAndLoginFeature.checkUserName(username)
        );
    }
}
