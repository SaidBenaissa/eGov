package pages.financial;

import entities.financial.FinancialJournalVoucherDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

public class JournalVoucherDetailsPage extends FinancialPage {

    @FindBy(id = "vType")
    private WebElement voucherSubType;

    @FindBy(id = "voucherTypeBean.partyName")
    private WebElement voucherPartyName;

    @FindBy(id = "fundId")
    private WebElement fundId;

    @FindBy(id = "vouchermis.departmentid")
    private WebElement voucherDepartment;

    @FindBy(id = "vouchermis.function")
    private WebElement voucherFunction;

    @FindBy(id = "billDetailslist[0].glcodeDetail")
    private WebElement accountCode1;

    @FindBy(className = "yui-ac-highlight")
    private WebElement accountCodeDropdown;

    @FindBy(id = "billDetailslist[0].debitAmountDetail")
    private WebElement debitAmount1;

    @FindBy(id = "billDetailslist[1].glcodeDetail")
    private WebElement accountCode2;

    @FindBy(id = "billDetailslist[1].creditAmountDetail")
    private WebElement creditAmount2;

    @FindBy(xpath = ".//*[@id='egov_yui_add_image']")
    private List<WebElement> addList;

    @FindBy(id = "billDetailslist[2].glcodeDetail")
    private WebElement accountCode3;

    @FindBy(id = "billDetailslist[2].creditAmountDetail")
    private WebElement creditAmount3;

    @FindBy(id = "subLedgerlist[0].glcode.id")
    private WebElement ledgerAccount1;

    @FindBy(id = "subLedgerlist[0].detailType.id")
    private WebElement ledgerType1;

    @FindBy(id = "subLedgerlist[0].detailCode")
    private WebElement ledgerCode1;

    @FindBy(id = "subLedgerlist[0].amount")
    private WebElement ledgerAmount1;

    @FindBy(id = "subLedgerlist[1].glcode.id")
    private WebElement ledgerAccount2;

    @FindBy(id = "subLedgerlist[1].detailType.id")
    private WebElement ledgerType2;

    @FindBy(id = "subLedgerlist[1].detailCode")
    private WebElement ledgerCode2;

    @FindBy(id = "subLedgerlist[1].amount")
    private WebElement ledgerAmount2;

    @FindBy(id = "button2")
    private WebElement closeButton;

    public JournalVoucherDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterJournalVoucherDetails(FinancialJournalVoucherDetails financialJournalVoucherDetails, String isSubLedgerPresent) {
        enterVoucherDetails(financialJournalVoucherDetails);
        enterVoucherAccountDetails(financialJournalVoucherDetails);
        enterVoucherSubLedgerDetails(financialJournalVoucherDetails, isSubLedgerPresent);
    }

    private void enterVoucherDetails(FinancialJournalVoucherDetails financialJournalVoucherDetails) {

        selectFromDropDown(voucherSubType, financialJournalVoucherDetails.getVoucherType(), webDriver);

        if (!financialJournalVoucherDetails.getVoucherType().equals("General")) {
            enterText(voucherPartyName, "Voucher", webDriver);
        }

        selectFromDropDown(fundId, financialJournalVoucherDetails.getFundId(), webDriver);
        selectFromDropDown(voucherDepartment, financialJournalVoucherDetails.getDepartment(), webDriver);
        selectFromDropDown(voucherFunction, financialJournalVoucherDetails.getFunction(), webDriver);
    }

    private void enterVoucherAccountDetails(FinancialJournalVoucherDetails financialJournalVoucherDetails) {

        enterText(accountCode1, financialJournalVoucherDetails.getAccountCode1(), webDriver);
        clickOnButton(accountCodeDropdown, webDriver);
        enterText(debitAmount1, financialJournalVoucherDetails.getDebitAmount1(), webDriver);

        enterText(accountCode2, financialJournalVoucherDetails.getAccountCode2(), webDriver);
        clickOnButton(accountCodeDropdown, webDriver);
        enterText(creditAmount2, financialJournalVoucherDetails.getCreditAmount2(), webDriver);

        if (!financialJournalVoucherDetails.getAccountCode3().isEmpty()) {

            clickOnButton(addList.get(1), webDriver);

            enterText(accountCode3, financialJournalVoucherDetails.getAccountCode3(), webDriver);
            clickOnButton(accountCodeDropdown, webDriver);
            enterText(creditAmount3, financialJournalVoucherDetails.getCreditAmount3(), webDriver);
        }
    }

    private void enterVoucherSubLedgerDetails(FinancialJournalVoucherDetails financialJournalVoucherDetails, String isSubLedgerPresent) {

        if (isSubLedgerPresent.contains("yes")) {

            waitForElementToBePresent(By.className("yui-dt-dropdown"), webDriver);
            await().atMost(5, SECONDS).until(() -> new Select(ledgerAccount1).getOptions().size() > 1);
            List<WebElement> webElementList = ledgerAccount1.findElements(By.tagName("option"));

            selectFromDropDown(ledgerAccount1, webElementList.get(1).getText(), webDriver);
            selectFromDropDown(ledgerType1, financialJournalVoucherDetails.getLedgerType1(), webDriver);

            enterText(ledgerCode1, financialJournalVoucherDetails.getLedgerCode1(), webDriver);
            clickOnButton(accountCodeDropdown, webDriver);
            enterText(ledgerAmount1, financialJournalVoucherDetails.getLedgerAmount1(), webDriver);

            if (webElementList.size() > 2) {

                if (addList.get(3).isDisplayed()) {
                    clickOnButton(addList.get(3), webDriver);
                } else {
                    clickOnButton(addList.get(2), webDriver);
                }

                selectFromDropDown(ledgerAccount2, webElementList.get(2).getText(), webDriver);
                selectFromDropDown(ledgerType2, financialJournalVoucherDetails.getLedgerType2(), webDriver);

                enterText(ledgerCode2, financialJournalVoucherDetails.getLedgerCode2(), webDriver);
                clickOnButton(accountCodeDropdown, webDriver);
                enterText(ledgerAmount2, financialJournalVoucherDetails.getLedgerAmount2(), webDriver);
            }
        }
    }

    public String getVoucherNumber() {

        switchToNewlyOpenedWindow(webDriver);

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class~='bootbox-alert'] div[class^='bootbox-body']")));
        WebElement voucherNumber = webDriver.findElement(By.cssSelector("div[class~='bootbox-alert'] div[class^='bootbox-body']"));
        String number = voucherNumber.getText();

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class~='bootbox-alert'] button[class^='btn']")));
        WebElement element = webDriver.findElement(By.cssSelector("div[class~='bootbox-alert'] button[class^='btn']"));
        element.click();

        clickOnButton(closeButton, webDriver);
        switchToPreviouslyOpenedWindow(webDriver);

        return number;
    }

}