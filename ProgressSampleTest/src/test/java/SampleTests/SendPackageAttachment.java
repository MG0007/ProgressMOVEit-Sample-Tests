package SampleTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SendPackageAttachment extends BaseClass{

    @Test
    void sendPackageAttachment() {
        commonMethods.login(driver, constsLP.LOGIN_USERNAME_ID, constsLP.LOGIN_PASSWORD_ID,
                constsLP.LOGIN_SUBMIT_BUTTON_ID, wait);

        WebElement packages = commonMethods.getElementXpathSelector(driver, constsLP.PACKAGES_FOLDER_XPATH, wait);
        packages.click();

        WebElement sendPackageButton = commonMethods.getElementXpathSelector(driver,
                constsLP.PACKAGES_SEND_BUTTON_XPATH, wait);
        sendPackageButton.click();

        WebElement packagesSendToButton = commonMethods.getElementById(driver, constsLP.PACKAGES_SENT_TO_BUTTON_ID,
                wait);
        packagesSendToButton.click();

        WebElement emailDestinationAddress =
                commonMethods.getElementCssSelector(driver, constsLP.PACKAGES_EMAIL_DESTINATION_ADDRESS_CSS, wait);
        emailDestinationAddress.click();

        WebElement emailDestinationOkButton =
                commonMethods.getElementXpathSelector(driver, constsLP.PACKAGES_EMAIL_DESTINATION_OK_BUTTON_XPATH,
                        wait);
        emailDestinationOkButton.click();

        WebElement uploadFilesButton = commonMethods.getElementById(driver, constsLP.PACKAGES_UPLOAD_FILES_BUTTON_ID,
                wait);
        uploadFilesButton.click();

        WebElement browseButton = driver.findElement(By.xpath(constsLP.PACKAGES_BROWSE_BUTTON));
        String projPath = System.getProperty("user.dir");
        browseButton.sendKeys(projPath + "\\src\\test\\java\\Resources\\hand.png");

        WebElement uploadButton = commonMethods.getElementXpathSelector(driver, constsLP.PACKAGES_UPLOAD_BUTTON, wait);
        uploadButton.click();

        WebElement closeButton = commonMethods.getElementXpathSelector(driver,
                constsLP.PACKAGES_UPLOAD_FILES_CLOSE_BUTTON_XPATH, wait);
        closeButton.click();

        WebElement attachmentName = commonMethods.getElementXpathSelector(driver,
                constsLP.PACKAGES_VERIFY_ATTACHMENT_NAME_XPATH, wait);

        assertTrue(attachmentName.getText().equalsIgnoreCase(constsLP.PACKAGES_ATTACHMENT_NAME));
    }
}
