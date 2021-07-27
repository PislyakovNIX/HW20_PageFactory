package tests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "stringsForTest")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"FullName1", "FullName1@lkjh.com", "Current Address 1", "Permanent Address 1"},
                {"FullName2", "FullName2@lkjh.com", "Current Address 2", "Permanent Address 2"},
                {"FullName3", "FullName3@lkjh.com", "Current Address 3", "Permanent Address 3"},
                {"FullName4", "FullName4@lkjh.com", "Current Address 4", "Permanent Address 4"},
                {"FullName5", "FullName5@lkjh.com", "Current Address 5", "Permanent Address 5"}
        };
    }
}
