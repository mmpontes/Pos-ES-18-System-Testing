package pages;

import support.DriverQA;

public class Home extends BasePage{

    private String url = "http://agapito-server.herokuapp.com/";

    public Home (DriverQA stepsDriver){
        super(stepsDriver);
    }

    public void openPage() {
        driver.openURL(url);
    }
}
