import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

'Get Selenium WebDriver'
System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())

WebDriver driver = new ChromeDriver()

DriverFactory.changeWebDriver(driver)

String domainPrefix = domain

String previewSuffix = preview

WebUI.navigateToUrl(domainPrefix + previewSuffix)

WebUI.delay(1)

List linkList = driver.findElements(By.xpath('//div[starts-with(@class, \'aboutUs\')]//a'))

int numberOfLinks = linkList.size()

RequestObject ro = new RequestObject()

for (WebElement link : linkList) {
    String url = link.getAttribute('href')

    ro.setRestRequestMethod('GET')

    ro.setRestUrl(url)

    ResponseObject resp = WS.sendRequest(ro)

    String response = resp.getStatusCode()

    //    println((('url:' + url) + '\nresponse:') + response)
    WebUI.verifyEqual(response, 200)
}

WebUI.closeBrowser()

