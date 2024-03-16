package ru.netology.sql.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;
import ru.netology.sql.data.DataHelper;
import ru.netology.sql.data.SQLHelper;
import ru.netology.sql.page.DashboardPage;
import ru.netology.sql.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BankLoginTest {
    LoginPage loginPage;

    @AfterEach
    void tearDown() {
        SQLHelper.cleanAuthCodes();}

    @AfterAll
    static void tearDownAll() {
        SQLHelper.cleanDatabase();}


    @BeforeEach
    void setUp() {
        loginPage = open ("http://localhost:8080", LoginPage.class);}

    @Test
    @DisplayName ("Should successfully login to dashboard with exist login and password from sut test data")
    void shouldSuccessfulLogin() {
        var authInfo = DataHelper.getAuthInfoWithTestData();
        //System.out.println("help1");
        var verificationPage = loginPage.validLogin(authInfo);
        //System.out.println("help2");
        verificationPage.verifyVerificationPageVisiblity();
        //System.out.println("help3");
        var verificationCode = SQLHelper.getVerificationCode();
        //System.out.println("help4");
        verificationPage.validVerify(verificationCode.getCode());
        //System.out.println("help5");


    }

    //@Test
    //@DisplayName("Should get error notification if user is not exist in base")
    //void shouldGetErrorNotificationIfLoginWithRandomUserNotExist() {
        //var AuthInfo = DataHelper.generateRandomUser();
        //loginPage.validLogin(AuthInfo);
        //loginPage.verifyErrorNotification("Ошибка! Неверно указан логин или пароль");
    }



