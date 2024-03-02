package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "222590652";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Wenzong Xuan";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login(null, "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("abc", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("abc", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("abc", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "xyz");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testSuccessCorrectUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testFailValidationCodeEmpty() {
        boolean isValid = LoginForm.validateCode(null);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testFailValidationCodeWrong() {
        boolean isValid = LoginForm.validateCode("abcd");
        Assert.assertFalse(isValid);
    }

    @Test
    public void testSuccessValidationCodeCorrect() {
        boolean isValid = LoginForm.validateCode("123456");
        Assert.assertTrue(isValid);
    }
}
