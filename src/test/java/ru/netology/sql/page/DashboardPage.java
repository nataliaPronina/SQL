package ru.netology.sql.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final SelenideElement heading = $("[data-test-id=dashboard]")
            .shouldBe(Condition.visible)
            .shouldHave(Condition.text("Личный кабинет"));
    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

}
