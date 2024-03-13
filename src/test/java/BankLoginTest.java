import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class BankLoginTest {
    LoginPage loginPage;

    @AfterEach
    void tearDown() {
        SQLHelper.cleanAuthCodes();}

    @AfterAll
    static void tearDownAll() {cleanDatabase();}

    private static void cleanDatabase() {
    }

    @BeforeEach
    void setUp() {
        var LoginPage = open ("http://localhost:8080", LoginPage.class);}

    @Test
    @DisplayName ("Should successfully login to dashboard with exist login and password from sut test data")
    void shouldSuccessfulLogin() {
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisiblity();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    @DisplayName("Should get error notification if user is not exist in base")
    void shouldGetErrorNotificationIfLoginWithRandomUserNotExist() {
        var AuthInfo = DataHelper.generateRandomUser();
        loginPage.validLogin(AuthInfo);
        loginPage.verifyErrorNotification("Ошибка! \nНеверно указан логин или пароль");
    }


}
