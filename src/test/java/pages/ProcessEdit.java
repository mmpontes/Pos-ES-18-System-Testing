package pages;

import support.DriverQA;

public class ProcessEdit extends BasePage {

    public ProcessEdit(DriverQA stepsDriver) {
        super(stepsDriver);
    }

    public void clickSave() {
        driver.click("btn-save");
    }

    public void changeField(String field, String value) {
        switch (field) {
            case "status":
                changeField_status(value);
                break;
            case "observacao":
                changeField_observacao(value);
                break;
        }
    }

    public void changeclickField(String field, String value) {
        switch (field) {
            case "arbitramento":
                changClickField_Arbitramento(value);
                break;
        }
    }

    private void changeField_status(String value) {
        driver.sendKeys(value,"#processo_status","css");
    }

    private void changeField_observacao(String value) {
        driver.sendKeys(value,"processo_observacao");
    }

    public void changClickField_Arbitramento(String value) {
        if (value.equals("Sim")){
            driver.click("processo_arbitramento_s");
        } else {
            driver.click("processo_arbitramento_n");
        }
    }
}
