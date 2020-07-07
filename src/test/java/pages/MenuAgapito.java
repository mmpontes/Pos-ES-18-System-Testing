package pages;

import support.DriverQA;

public class MenuAgapito  extends BasePage{

    public MenuAgapito(DriverQA stepsDriver) {
        super(stepsDriver);
    }

    public void clickUser() {
        driver.click("#processos", "css");
    }
}
