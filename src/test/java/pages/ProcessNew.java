package pages;

import support.DriverQA;

public class ProcessNew extends BasePage{
    public ProcessNew(DriverQA stepsDriver){
        super(stepsDriver);
    }

    public void fillField(String field, String value) {
        switch (field) {
            case "vara":
                fillField_Vara(value);
                break;
            case "numero_processo":
                fillField_NumeroProcesso(value);
                break;
            case "natureza":
                fillField_Natureza(value);
                break;
            case "partes":
                fillField_Partes(value);
                break;
            case "assistente_social":
                fillField_AssistenteSocial(value);
                break;
            case "data_entrada":
                fillField_DataEntrada(value);
                break;
            case "data_saida":
                fillField_DataSaida(value);
                break;
            case "data_agendamento":
                fillField_DataAgendamento(value);
                break;
            case "status":
                fillField_Status(value);
                break;
            case "observacao":
                fillField_Observacao(value);
                break;
        }
    }

    public void selectField(String field, String value) {
        switch (field) {
            case "urgente":
                selectField_Urgency(value);
                break;
        }
    }

    public void clickField(String field, String value) {
        switch (field) {
            case "arbitramento":
                clickField_Arbitramento(value);
                break;
        }
    }

    private void fillField_Vara(String value) { driver.sendKeys(value, "processo_vara");    }

    private void fillField_NumeroProcesso(String value) { driver.sendKeys(value, "#processo_numero_processo","css");  }

    private void fillField_Natureza(String value) {
        driver.sendKeys(value,"processo_natureza");
    }

    private void fillField_Partes(String value) {
        driver.sendKeys(value,"#processo_partes","css");
    }

    private void fillField_AssistenteSocial(String value) { driver.sendKeys(value,"processo_assistente_social"); }

    private void fillField_DataEntrada(String value) {
        driver.sendKeys(value,"processo_data_entrada");
    }

    private void fillField_DataSaida(String value) {
        driver.sendKeys(value,"#processo_data_saida","css");
    }

    private void fillField_DataAgendamento(String value) {
        driver.sendKeys(value,"processo_data_agendamento");
    }

    private void fillField_Status(String value) {
        driver.sendKeys(value,"#processo_status","css");
    }

    private void fillField_Observacao(String value) {
        driver.sendKeys(value,"processo_observacao");
    }

    public void clickSave() {
        driver.click("btn-save");
    }

    public void selectField_Urgency(String value) {
        driver.selectByText(value,"processo_urgente");
    }

    public void clickField_Arbitramento(String value) {
        if (value.equals("Sim")){
            driver.click("processo_arbitramento_s");
        } else {
            driver.click("processo_arbitramento_n");
        }
    }
}
