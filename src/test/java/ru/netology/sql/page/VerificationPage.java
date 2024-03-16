package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'].notification__content");
           // .shouldHave(Condition.text("Ошибка! Неверно указан логин или пароль"))
           // .shouldBe(Condition.visible);

    public void verifyVerificationPageVisiblity() {
        codeField.shouldBe(Condition.visible);
    }
    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        //System.out.println("help6");
        return new DashboardPage();}

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }

}
