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

not_run: WebUI.waitForElementClickable(findTestObject('MFE Testing Pages/Header/link_signInOrCreateAccount'), GlobalVariable.G_mediumLongTimeout)

WebUI.delay(1)

WebUI.click(findTestObject('MFE Testing Pages/Header/link_signInOrCreateAccount'))

WebUI.verifyElementPresent(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/iframe_signInOrCreateAccount'), GlobalVariable.G_smallTimeout)

WebUI.sendKeys(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/input_username'), username_MFE_testAccount)

WebUI.sendKeys(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/input_password'), password)

WebUI.waitForElementClickable(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/button_signIn'), GlobalVariable.G_smallTimeout)

WebUI.click(findTestObject('MFE Testing Pages/Page_LoginOrCreateAccount/Login/button_signIn'))

WebUI.waitForPageLoad(GlobalVariable.G_mediumTimeout)

