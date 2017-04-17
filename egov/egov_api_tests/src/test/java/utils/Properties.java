package utils;

public class Properties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();

    //  Server Url's  //
    public static final String devServerUrl = propertiesReader.getDevServerUrl();
    public static final String serverUrl = propertiesReader.getServerUrl();

    //  Login And Logout Url's  //
    public static final String loginUrl = propertiesReader.getLoginUrl();
    public static final String logoutUrl = propertiesReader.getLogoutUrl();

    //  User Url's  //
    public static final String userUrl = propertiesReader.getUserUrl();

    //  PGR Module Url's  //
    public static final String getPGRComplaintUrl = propertiesReader.getPGRComplaintUrl();
    public static final String complaintUrl = propertiesReader.getComplaintUrl();
    public static final String locationNameUrl = propertiesReader.getLocationNameUrl();
    public static final String fetchComplaintsUrl = propertiesReader.getFetchComplaintsUrl();
    public static final String frequentlyFilledComplaintsUrl = propertiesReader.getFrequentlyFilledComplaintstUrl();
    public static final String pgrStatusUrl = propertiesReader.getPGRStatusUrl();
    public static final String pgrReceivingCenterUrl = propertiesReader.getPGRReceivingCenter();
    public static final String pgrSearchCitizenComplaintUrl = propertiesReader.getPGRSearchCitizenComplaint();

    //  Asset Module Url's  //
    public static final String searchAssetServiceUrl = propertiesReader.getSearchAssetServiceUrl();
    public static final String assetCategoryCreateUrl = propertiesReader.getAssetCategoryCreateUrl();
    public static final String createAssetServiceUrl = propertiesReader.getCreateAssetServiceUrl();
    public static final String assetCategorySearchUrl = propertiesReader.getAssetCategorySearchUrl();

    //  eGov EIS Module Url's  //
    public static final String searchAttendanceUrl = propertiesReader.getSearchAttendanceUrl();
    public static final String createAttendanceURL = propertiesReader.getCreateAttendanceUrl();
    public static final String searchEmployeeURL = propertiesReader.getSearchEmployeeUrl();
    public static final String createEmployeeUrl = propertiesReader.getCreateEmployeeUrl();
    public static final String eisSearchEmployeeTypeUrl = propertiesReader.getSearchEmployeeTypeUrl();
    public static final String eisSearchDesignationTypeUrl = propertiesReader.getSearchDesignationTypeUrl();
    public static final String eisSearchPositionUrl = propertiesReader.getSearchPositionUrl();
    public static final String eisSearchPositionHierarchyUrl = propertiesReader.getSearchPositionHierarchyUrl();
    public static final String eisSearchGradeUrl = propertiesReader.getSearchGradeUrl();
    public static final String eisSearchEmployeeGroupUrl = propertiesReader.getSearchEmployeeGroupUrl();
    public static final String eisSearchRecruitmentQuotaUrl = propertiesReader.getSearchRecruitmentQuotaUrl();
    public static final String eisSearchRecruitmentModesUrl = propertiesReader.getSearchRecruitmentModesUrl();
    public static final String eisSearchHrConfigurationsUrl = propertiesReader.getSearchHrConfigurationsUrl();
    public static final String eisSearchHrStatusesUrl = propertiesReader.getSearchHrStatusesUrl();
    public static final String eisSearchLeaveApplicationsUrl = propertiesReader.getSearchLeaveApplicationsUrl();
    public static final String eisSearchLeaveOpeningbalancesUrl = propertiesReader.getSearchLeaveOpeningbalancesUrl();
    public static final String eisSearchLeaveAllotmentsUrl = propertiesReader.getSearchLeaveAllotmentsUrl();

    //  Land Estate Module Url's  //
    public static final String lAMSServiceSearchUrl = propertiesReader.getLAMSServiceSearchUrl();

    //  Common Master's Module Url's  //
    public static final String cmLanguageUrl = propertiesReader.getCMLanguageUrl();
    public static final String cmDepartmentUrl = propertiesReader.getCMDepartmentUrl();
    public static final String cmCommunityUrl = propertiesReader.getCMCommunityUrl();
    public static final String cmReligionUrl = propertiesReader.getCMReligionUrl();
    public static final String cmHolidayUrl = propertiesReader.getCMHolidayUrl();
    public static final String cmCategoryUrl = propertiesReader.getCMCategoryUrl();
    public static final String cmCreateHolidayUrl = propertiesReader.getCMCreateHolidayUrl();

    public static final String userCreateUrl = propertiesReader.getUserCreateUrl();
    public static final String pgrReceivingModesUrl = propertiesReader.getPGRReceivingModesUrl();
    public static final String searchEmployeeLeaveUrl = propertiesReader.getSearchEmployeeLeaveUrl();
}