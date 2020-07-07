package pages;

import support.DriverQA;

public class ProcessShow extends BasePage {

    private String lastProcess;

    public ProcessShow(DriverQA stepsDriver) { super(stepsDriver);}

    public void storeIdLastProcess() { setLastIdProcess(driver.getText("codigo")); }

    private void setLastIdProcess(String codigo) {
        lastProcess = codigo;
    }

    public String getAlert() { return driver.getText("notice"); }

    public void clickBack() { driver.click(".ls-btn-primary-danger", "css"); }

    public String getLastProcess(){
        return lastProcess;
    }

    public String getField(String field) { return driver.getText(field); }
}
