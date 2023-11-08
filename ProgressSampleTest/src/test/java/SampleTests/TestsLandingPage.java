package SampleTests;

import BaseClass.BaseClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestsLandingPage extends BaseClass {

    @Test
    void logoLoads(){
    WebElement logo = commonMethods.getElementXpathSelector(driver, constsLP.LOGO_XPATH, wait);
    String altText = logo.getAttribute("alt");
    assertTrue(altText.equalsIgnoreCase(""));
    }

    @Test
    void fieldsBlankAfterNewFolder() {
        commonMethods.login(driver, constsLP.LOGIN_USERNAME_ID, constsLP.LOGIN_PASSWORD_ID,
                constsLP.LOGIN_SUBMIT_BUTTON_ID, wait);

        WebElement packages = commonMethods.getElementXpathSelector(driver, constsLP.PACKAGES_FOLDER_XPATH, wait);
        packages.click();

        WebElement addMailFolderButton = commonMethods.getElementLinkText(driver,
                constsLP.FOLDER_ADD_MAIL_FOLDER_BUTTON_LINKTEXT, wait);
        addMailFolderButton.click();
        
        WebElement folderNameField = commonMethods.getElementNameSelector(driver, constsLP.FOLDER_ADD_MAIL_FOLDER_NAME_FIELD_NAMETAG, wait);
        folderNameField.sendKeys(constsLP.FOLDER_NAME);

        WebElement folderDescriptionField = commonMethods.getElementByNameTag(driver,
                constsLP.FOLDER_ADD_MAIL_FOLDER_DESCRIPTION_FIELD_NAMETAG, wait);
        folderDescriptionField.sendKeys(constsLP.FOLDER_DESCRIPTION);

        WebElement folderAddMailFolderButton =
                commonMethods.getElementXpathSelector(driver, constsLP.FOLDER_ADD_MAIL_FOLDER_BUTTON_XPATH, wait);
        folderAddMailFolderButton.click();

        WebElement folderNameFieldAfter =
                commonMethods.getElementNameSelector(driver,constsLP.FOLDER_ADD_MAIL_FOLDER_NAME_FIELD_NAMETAG, wait);
        WebElement folderDescriptionFieldAfter = commonMethods.getElementByNameTag(driver,
                constsLP.FOLDER_ADD_MAIL_FOLDER_DESCRIPTION_FIELD_NAMETAG, wait);

        assertTrue(folderNameFieldAfter.getText().equalsIgnoreCase("") &&
                            folderDescriptionFieldAfter.getText().equalsIgnoreCase(""));
    }
}
