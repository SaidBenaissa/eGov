package utils;

import java.io.*;

public class ScenarioContext implements Serializable {

    private String applicationNumber;

    private String assessmentNumber;

    private String dataScreenAssessmentNumber;

    private String voucherNumber;

    private String actualMessage;

    private int isRemittance;

    private String user;

    private String registrationNumber;

    public void setRegistrationNumber(String Number){
        this.registrationNumber = Number;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIsRemittance() {
        return isRemittance;
    }

    public void setIsRemittance(int isRemittance) {
        this.isRemittance = isRemittance;
    }

    public String getActualMessage() {
        return actualMessage;
    }

    public void setActualMessage(String actualMessage) {
        this.actualMessage = actualMessage;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getAssessmentNumber() {
        return assessmentNumber;
    }

    public void setAssessmentNumber(String assessmentNumber) {
        this.assessmentNumber = assessmentNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getDataScreenAssessmentNumber() {
        return dataScreenAssessmentNumber;
    }

    public void setDataScreenAssessmentNumber(String dataScreenAssessmentNumber) {
        this.dataScreenAssessmentNumber = dataScreenAssessmentNumber;
    }
}

