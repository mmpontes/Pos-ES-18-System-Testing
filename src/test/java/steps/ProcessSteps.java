package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class ProcessSteps extends BaseSteps {

    private Home home = new Home(driver);
    private MenuAgapito menu = new MenuAgapito(driver);
    private ProcessGrid processGrid = new ProcessGrid(driver);
    private ProcessNew processNew = new ProcessNew(driver);
    private ProcessShow processShow = new ProcessShow(driver);
    private ProcessEdit processEdit = new ProcessEdit(driver);

    @Given("^the process is on Agapito Server page$")
    public void theProcessIsOnAgapitoServerPage() {
        home.openPage();
    }

    @And("^the user clicks on Process menu$")
    public void theUserClicksOnProcessMenu() {
        menu.clickUser();
    }

    @And("^the user clicks on new process button$")
    public void theUserClicksOnNewProcessButton() {
        processGrid.clickNewProcess();
    }

    @And("^the user fill \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserFillWithValueEqual(String field, String value) throws Throwable {
        processNew.fillField(field, value);
    }

    @And("^the user selects \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserSelectsWithValueEqual(String field, String value) throws Throwable {
        processNew.selectField(field, value);
    }

    @And("^the user clicks on \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserClicksOnWithValueEqual(String field, String value) throws Throwable {
        processNew.clickField(field, value);
    }

    @When("^the user clicks on save button$")
    public void theUserClicksOnSaveButton() {
        processNew.clickSave();
        processShow.storeIdLastProcess();
    }

    @Then("^the user should see \"([^\"]*)\" into view process page$")
    public void theUserShouldSeeIntoViewProcessPage(String msg) throws Throwable {
        Assert.assertEquals(msg, processShow.getAlert());
    }

    @Given("^the user backs to the process grid$")
    public void theUserBacksToTheProcessGrid() {
        processShow.clickBack();
    }

    @When("^the user clicks on show button$")
    public void theUserClicksOnShowButton() {
        processGrid.clickShow(processShow.getLastProcess());
    }

    @Then("^the user should see \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserShouldSeeWithValueEqual(String field, String value) throws Throwable {
        Assert.assertEquals(value, processShow.getField(field));
    }

    @And("^the user clicks on edit button$")
    public void theUserClicksOnEditButton() {
        processGrid.clickEdit(processShow.getLastProcess());
    }

    @And("^the user clicks on edit save button$")
    public void theUserClicksOnEditSaveButton() {
        processEdit.clickSave();
    }

    @And("^the user must change \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserMustChangeWithValueEqual(String field, String value) throws Throwable {
        processEdit.changeField(field, value);
    }

    @When("^the user clicks on delete button$")
    public void theUserClicksOnDeleteButton() {
        processGrid.clickDelete(processShow.getLastProcess());
    }

    @And("^the user confirms delete$")
    public void theUserConfirmsDelete() {
        processGrid.clickConfirmDelete();
    }

    @Then("^the user should not see last process code$")
    public void theUserShouldNotSeeLastProcessCode() {
        Assert.assertFalse("ERROR: There is a process with this code " + processShow.getLastProcess(),
                processGrid.existProcess(processShow.getLastProcess()) );
    }

    @And("^the user edits and clicks \"([^\"]*)\" with value equal \"([^\"]*)\"$")
    public void theUserEditsAndClicksWithValueEqual(String field, String value) throws Throwable {
        processEdit.changeclickField(field, value);
    }
}
