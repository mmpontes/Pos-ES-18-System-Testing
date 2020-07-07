package pages;

import support.DriverQA;

public class ProcessGrid extends BasePage{
    public ProcessGrid(DriverQA stepDriver){
        super(stepDriver);
    }

    public void clickNewProcess() {
        driver.click("#btn-novo", "css");
    }

    public void clickShow(String lastProcess) {
        String sName = "btn-show_" + lastProcess;
        driver.click(sName);
    }

    public void clickEdit(String lastProcess) {
        String sName = "btn-edit_" + lastProcess;
        driver.click(sName);
    }

    public void clickDelete(String lastProcess) {
        String sName = "btn-delete_" + lastProcess;
        driver.click(sName);
    }

    public void clickConfirmDelete() {
        driver.ChooseOkOnNextConfirmation();
    }

    public boolean existProcess(String lastProcess) {
        String sName = "btn-delete_" + lastProcess;
        return driver.getDriver().getPageSource().contains(sName);
    }
}
