import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.nio.channels.Selector.open;

public class webView {


    @Test
    void webView() {
        //открываем тестовый филиал (id=6344) на webview
        Selenide.open("https://express-web.choco.kz/filials/6344");
        sleep(5000);
        //чекаем открыто ли заведение
        $("[data-test-id=filial-status]").shouldHave(Condition.text("Открыто"));
        sleep(5000);
        ///кликаем на (+) первой позиции
        $("[data-test-id=food-count-btn]").click();
        sleep(5000);
        //проверяем, добавилась ли позиция в корзину
        $("[data-test-id=cart-btn]").shouldHave(Condition.text("1 шт"));
        sleep(5000);
        //переходим в карзину
        $("[data-test-id=cart-btn]").click();
        sleep(5000);
        //пишем тестовый комментарии
        $("[data-test-id=cart-comment]").setValue("тестовый комментарии");
        sleep(5000);
        //нажимаем на кнопку "перейти к оплате"
        $("[data-test-id=payment-btn]").click();
        sleep(2000);


    }
}
