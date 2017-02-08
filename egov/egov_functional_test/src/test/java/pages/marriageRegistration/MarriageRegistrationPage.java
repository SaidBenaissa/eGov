package pages.marriageRegistration;

import entities.marriageRegistration.MarriageRegistrationInformation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manjunatha-lap on 24/01/2017.
 */
public class MarriageRegistrationPage extends BasePage {
    public WebDriver driver;

    @FindBy(id = "select-registrationunit")
    private WebElement registrationUnit;

    @FindBy(id = "txt-street")
    private List<WebElement> street;

    @FindBy(id = "select-locality")
    private WebElement locality;

    @FindBy(id = "txt-locality")
    private List<WebElement> localityTxt;

    @FindBy(id = "txt-city")
    private List<WebElement> city;

    @FindBy(id = "txt-dateOfMarriage")
    private WebElement dateOfMarriage;

    @FindBy(id = "select-venue")
    private  WebElement venueOfMarriage;

    @FindBy(id = "txt-placeofmrg")
    private WebElement placeOfMarriage;

    @FindBy(css = "input[type='file'][id='marriage-photo']")
    private WebElement marriagePhoto;

    @FindBy(id = "husband.name.firstName")
    private WebElement brideFullName;

    @FindBy(id = "txt-lastName")
    private List<WebElement> lastName;

    @FindBy(id = "txt-parentsName")
    private WebElement parentsName;

    @FindBy(css = "input[type='file'][id='husband-photo']")
    private WebElement photoUpload;

    @FindBy(css = "input[type='file'][id='wife-photo']")
    private WebElement wifePhotoUpload;

    @FindBy(xpath = ".//*[@id='settingstab']/li[2]/a")
    private WebElement witnessInfoLink;

    @FindBy(id = "witnesses0.name.firstName")
    private WebElement witnessName1;

    @FindBy(id = "witnesses1.name.firstName")
    private WebElement witnessName2;

    @FindBy(id = "witnesses2.name.firstName")
    private WebElement witnessName3;

    @FindBy(id = "witnesses3.name.firstName")
    private WebElement witnessName4;

    @FindBy(xpath = ".//*[@id='settingstab']/li[3]/a")
    private WebElement checkListLink;

    @FindBy(id = "file1id")
    private WebElement memorandumofMarriage;

    @FindBy(id = "ageproofhusbandfile1id")
    private WebElement birthCertificateForBridegroom;

    @FindBy(id = "ageproofwifefile1id")
    private WebElement birthCertificateForBride;

    @FindBy(id = "addressproofhusbandfile10id")
    private WebElement proofofResidenceForBridegroom;

    @FindBy(id = "addressproofwifefile10id")
    private WebElement proofofResidenceForBride;

    @FindBy(xpath = ".//*[@id='registrationsuccess-form']/div/div[2]/div")
    private WebElement creationMessage;

    @FindBy(css = "input[type='button'][value='Close']")
    private WebElement closeButton;

    @FindBy(css = "input[id='inboxsearch'][type='text']")
    private WebElement inboxSearchTextBox;

    @FindBy(id = "official_inbox")
    private WebElement inboxTable;

    @FindBy(css = "li[role='presentation'] a[data-now='Marriage%20Registration%20%3A%3A%20New%20Registration']")
    private WebElement marraigeRegistrationsLink;

    @FindBy(css = "li[role='presentation'] a[data-now='Marriage%20Registration%20%3A%3A%20Re-Issue']")
    private WebElement reIssueCertificateTab;

    @FindBy(id = "Approve")
    private WebElement approveButton;

    @FindBy(id = "txt-serialNo")
    private WebElement marriageSerialNum;

    @FindBy(xpath = ".//*[@id='txt-pageNo']")
    private WebElement marriagePageNum;

    @FindBy(id = "dataEntrySubmit")
    private WebElement dataEntrySubmitButton;

    @FindBy(id = "file1id")
    private WebElement memorandumOfMarriage;

    @FindBy(className = "today active day")
    private WebElement todayDatePicker;

    @FindBy(id = "applicationNo")
    private WebElement applicationNumberTextBox;

    @FindBy(id = "btnregistrationsearch")
    private WebElement searchRegistrationButton;

    @FindBy(className = "dropchange")
    private WebElement actionDropDown;

    @FindBy(xpath = ".//*[@id='registration_table']/tbody/tr/td[10]/button")
    private WebElement editButton;

    @FindBy(xpath = ".//*[@id='form-updateregistration']/div[2]/div/button")
    private WebElement updateButton;

    @FindBy(id = "applicationNo")
    private WebElement applicationNo;

    @FindBy(xpath = ".//*[@id='registration_table']/tbody/tr[1]/td[10]/button")
    private WebElement reIssueCertificateLink;

    @FindBy(id = "txt-firstName")
    private WebElement firstName;

    @FindBy(id = "txt-residenceAddress")
    private WebElement residenceAddress;

    @FindBy(id = "txt-officeAddress")
    private WebElement officeAddress;

    @FindBy(id = "txt-phoneNo")
    private WebElement phoneNo;

    public  MarriageRegistrationPage(WebDriver driver){ this.driver = driver;}

    public void enterApplicantsInformation(MarriageRegistrationInformation marriageRegistrationInformation) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());

        waitForElementToBeClickable(registrationUnit, driver);
        registrationUnit.sendKeys(marriageRegistrationInformation.getRegistrationUnit());
        waitForElementToBeClickable(street.get(0), driver);
        street.get(0).sendKeys(marriageRegistrationInformation.getStreet());
        waitForElementToBeClickable(locality, driver);
        locality.sendKeys(marriageRegistrationInformation.getLocality());
        waitForElementToBeClickable(city.get(0), driver);
        city.get(0).sendKeys(marriageRegistrationInformation.getCity());
        waitForElementToBeClickable(dateOfMarriage, driver);
        dateOfMarriage.clear();
        dateOfMarriage.sendKeys(getPastDate(35));
//        dateOfMarriage.click();
//        new Select(todayDatePicker).selectByVisibleText("6");
        waitForElementToBeClickable(venueOfMarriage, driver);
        venueOfMarriage.sendKeys(marriageRegistrationInformation.getVenueOfMarriage());
        waitForElementToBeClickable(placeOfMarriage, driver);
        placeOfMarriage.sendKeys(marriageRegistrationInformation.getPlaceOfMarriage());
        marriagePhoto.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
    }


    public void enterBrideGroomInformation(MarriageRegistrationInformation marriageRegistrationInformation,String name )
    {
        WebElement fullName = driver.findElement(By.id(name + ".name.firstName"));
        fullName.sendKeys(marriageRegistrationInformation.getFullName());

//        waitForElementToBeClickable(brideFullName, driver);
//        brideFullName.sendKeys(marriageRegistrationInformation1.getFullName());

        waitForElementToBeClickable(lastName.get(0), driver);
        lastName.get(0).sendKeys("N");
        waitForElementToBeClickable(lastName.get(1), driver);
        lastName.get(1).sendKeys("P");
        photoUpload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");

        WebElement parentsNamegb = driver.findElement(By.name(name + ".parentsName"));
        parentsNamegb.sendKeys(marriageRegistrationInformation.getFathersMothersName());

        WebElement religion = driver.findElement((By.id(name + ".religion")));
        religion.sendKeys(marriageRegistrationInformation.getReligion());

//        waitForElementToBeClickable(ageInYearsAsOnMarriage, driver);
//        ageInYearsAsOnMarriage.sendKeys("32");
//        waitForElementToBeClickable(ageInMonthsAsOnMarriage, driver);
//        ageInMonthsAsOnMarriage.sendKeys("0");

        WebElement ageInYears = driver.findElement(By.id(name + ".ageInYearsAsOnMarriage"));
        ageInYears.sendKeys("30");
        WebElement ageInMonth = driver.findElement(By.id(name + ".ageInMonthsAsOnMarriage"));
        ageInMonth.sendKeys("8");

        WebElement martialStatus = driver.findElement(By.id(name + ".maritalStatus"));
        martialStatus.sendKeys(marriageRegistrationInformation.getStatusAtTheTimeMarriage());

        WebElement residenceAddress = driver.findElement(By.id(name + ".contactInfo.residenceAddress"));
        residenceAddress.sendKeys(marriageRegistrationInformation.getResidenceAddress());
        WebElement officeAddress = driver.findElement(By.id(name + ".contactInfo.officeAddress"));
        officeAddress.sendKeys(marriageRegistrationInformation.getOfficeAddress());

        WebElement localitygb = driver.findElement(By.name(name + ".locality"));
        localitygb.sendKeys(marriageRegistrationInformation.getLocality());

        WebElement streetbg = driver.findElement(By.name(name + ".street"));
        streetbg.sendKeys(marriageRegistrationInformation.getStreet());

        WebElement citygb = driver.findElement(By.name(name + ".city"));
        citygb.sendKeys(marriageRegistrationInformation.getCity());

        WebElement mobileNogb = driver.findElement(By.id(name + ".contactInfo.mobileNo"));
        mobileNogb.sendKeys(marriageRegistrationInformation.getPhoneNo());

        WebElement occupationgb = driver.findElement(By.id(name+".occupation"));
        occupationgb.sendKeys(marriageRegistrationInformation.getOccupation());

        WebElement qualificationgb = driver.findElement(By.id(name+".qualification"));
        qualificationgb.sendKeys(marriageRegistrationInformation.getEducationQualification());

        wifePhotoUpload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
    }

    public void entersWitnessesInformation() {
        waitForElementToBeClickable(witnessInfoLink, driver);
        jsClick(witnessInfoLink, driver);

        for(int i=0; i<=3; i++)
        {
            int res = 0;
            int sum = i+res;
            System.out.println(sum);
            WebElement witnessName = driver.findElement(By.id("witnesses"+sum+".name.firstName"));
            witnessName.sendKeys("Witness Names");
            WebElement witnessLastName = driver.findElement(By.id("witnesses"+sum+".name.lastName"));
            witnessLastName.sendKeys("Witness Last Names");
            WebElement relativeName = driver.findElement(By.id("witnesses["+sum+"].relativeName"));
            relativeName.sendKeys("Relative Name");
            WebElement witnessAge = driver.findElement(By.id("witnesses["+sum+"].age"));
            witnessAge.sendKeys("35");
            WebElement residenceAddress = driver.findElement(By.id("witnesses["+sum+"].contactInfo.residenceAddress"));
            residenceAddress.sendKeys("Residence Address");


        }

//        waitForElementToBeClickable(witnessName1, driver);
//        witnessName1.sendKeys("AAAA");


    }

    public void enterChecklist() {
        waitForElementToBeClickable(checkListLink,driver);
        jsClick(checkListLink,driver);

        memorandumofMarriage.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
        birthCertificateForBridegroom.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
        birthCertificateForBride.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
        proofofResidenceForBridegroom.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
        proofofResidenceForBride.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");
        memorandumOfMarriage.sendKeys(System.getProperty("user.dir") + "/src/test/resources/logo.jpg");

        memorandumofMarriage.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpg");
        birthCertificateForBridegroom.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpg");
        birthCertificateForBride.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpg");
        proofofResidenceForBridegroom.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpg");
        proofofResidenceForBride.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpg");
        memorandumOfMarriage.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\logo.jpg");
//        waitForElementToBeClickable(dataEntrySubmitButton, driver);
//        jsClick(dataEntrySubmitButton, driver);
    }

    public String getApplicationNumber() {
         String msg = creationMessage.getText();
         String number = msg.split("\\s")[6];
         System.out.println("\n "+number);
         return number;
    }

    public String getSuccessMessage() {
        return creationMessage.getText();
    }

    public void close() {
        waitForElementToBeClickable(closeButton,driver);
        closeButton.click();
        switchToPreviouslyOpenedWindow(driver);
    }

    public void searchForApplicationInbox(String applicationNumber) {
        waitForElementToBeVisible(inboxSearchTextBox,driver);
        inboxSearchTextBox.sendKeys(applicationNumber);

    }

    public void selectAboveApplication(String applicationNumber) {
        waitForElementToBeVisible(inboxTable,driver);
        waitForElementToBeClickable(inboxTable,driver);

        List<WebElement> totalRows = inboxTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
//        System.out.println("\n "+ totalRows.size());

        for (WebElement applicationRow : totalRows){
            if(applicationRow.findElements(By.tagName("td")).get(4).getText().contains(applicationNumber)){
                applicationRow.click();
                break;
            }
        }

        switchToNewlyOpenedWindow(driver);
    }

    public void searchForMarriageRegistration() {
        waitForElementToBeVisible(marraigeRegistrationsLink,driver);
        marraigeRegistrationsLink.click();
    }


    public void approve() {
        waitForElementToBeClickable(approveButton,driver);
        approveButton.click();
    }

    public String getRegistrationNumber(){
        String msg = creationMessage.getText();
        String number = msg.split("\\ ")[7];
        System.out.println(number);

        return number;
    }

    public void enterMarriageRegNum() {
        String min = String.valueOf(Calendar.getInstance().get(Calendar.MILLISECOND));
        waitForElementToBeClickable(marriageSerialNum, driver);
        marriageSerialNum.sendKeys("0123"+min);
        waitForElementToBeClickable(marriagePageNum, driver);
        marriagePageNum.sendKeys("0123"+min);
    }

    public String isSuccesful() {
//        waitForElementToBeClickable(dataEntrySubmitButton, driver);
//        jsClick(dataEntrySubmitButton, driver);
        String message = creationMessage.getText();
         return  message;
//        Assert.assertEquals(expectedMessage,actualMessage);
    }

    public void searchForMarriageApplicationNumberToCollect(String applicationNumber) {
        waitForElementToBeVisible(applicationNumberTextBox,driver);
        applicationNumberTextBox.sendKeys(applicationNumber);
        searchRegistrationButton.click();
    }

    public void clickOnCollectDropdown(){
        waitForElementToBeVisible(actionDropDown,driver);
        new Select(actionDropDown).selectByVisibleText("Collect Fee");
        switchToNewlyOpenedWindow(driver);
    }

    public void searchForApplicationToModify(String applicationNumber) {
        waitForElementToBeVisible(applicationNumberTextBox,driver);
        applicationNumberTextBox.sendKeys(applicationNumber);
        searchRegistrationButton.click();
    }

    public void clickOnEditButton() {
        waitForElementToBeClickable(editButton,driver);
        editButton.click();
        switchToNewlyOpenedWindow(driver);
    }

    public void modifyAndUpdateMarriageApplication() {
        waitForElementToBeClickable(lastName.get(0), driver);
        lastName.get(0).sendKeys("KHAN");
        waitForElementToBeClickable(updateButton,driver);
        updateButton.click();

    }

    public String isSuccesfulForModification() {
        return creationMessage.getText();
    }

    public void closeMultipleWindows() {
        waitForElementToBeClickable(closeButton, driver);
        closeButton.click();
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getCurrentUrl().equals("http://kurnool-uat.egovernments.org/mrs/registration/searchApproved")) {
                break;
            }
        }
        driver.findElement(By.linkText("Close")).click();
        switchToPreviouslyOpenedWindow(driver);

    }

    public void searchMarriageApplication(String applicationNumber) {
        waitForElementToBeClickable(applicationNo, driver);
        applicationNo.sendKeys(applicationNumber);
        searchRegistrationButton.click();
    }

    public void selectsReIssueCertificate() {
        waitForElementToBeClickable(reIssueCertificateLink, driver);
        reIssueCertificateLink.click();
        switchToNewlyOpenedWindow(driver);
    }

    public void entersMemorandumOfMarriage() {
        String min = String.valueOf(Calendar.getInstance().get(Calendar.MILLISECOND));
        String min1 = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
        waitForElementToBeClickable(registrationUnit, driver);
        new Select(registrationUnit).selectByVisibleText("Sarjapur");
        waitForElementToBeClickable(firstName, driver);
        firstName.sendKeys("AaZz");
        waitForElementToBeClickable(residenceAddress, driver);
        residenceAddress.sendKeys("Kurnool, Andra Pradesh");
        waitForElementToBeClickable(officeAddress, driver);
        officeAddress.sendKeys("Kurnool, Andra Pradesh");
        waitForElementToBeClickable(phoneNo, driver);
        phoneNo.sendKeys("9876511223");
    }

    public void searchForReIssueRegistration() {
        waitForElementToBeClickable(reIssueCertificateTab, driver);
        reIssueCertificateTab.click();
    }

    public String forwardReIssueCertificate() {
        String message = creationMessage.getText();
        return  message;

    }

}