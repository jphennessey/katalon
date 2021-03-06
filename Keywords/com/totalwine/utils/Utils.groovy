package com.totalwine.utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import java.awt.*
import org.openqa.selenium.Keys as Keys


import internal.GlobalVariable

public class Utils {
	@Keyword
	def Boolean isDesktop() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize()
		//		Integer screenHeight = screenSize.height
		//		Integer screenWidth = screenSize.width
		return (screenSize.width > 1024)
	}

	@Keyword
	def clearSearchText(TestObject to) {
		def maxTries = 3
		def contents = WebUI.getAttribute(to, 'value')
		def empty = (contents.length() == 0)

		try {
			while (!empty && (maxTries-- > 0)) {
				empty = doubleclickAndClear(to)
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to clear field!")
		}
	}

	@Keyword
	def doubleclickAndClear(TestObject to) {
		WebUI.doubleClick(to)
		WebUI.sendKeys(to, Keys.chord(Keys.BACK_SPACE))
		def contents = WebUI.getAttribute(to, 'value')
		def empty = (contents.length() == 0)
		return empty
	}

	@Keyword
	def delimitName(String name) {
		def newName = name.toLowerCase().replaceAll(" ", "-")
		return newName
	}

	@Keyword
	def getHrefFromFooterElements(String header, String columnElement) {
		def href = "/" + delimitName(header) + "/" + delimitName(columnElement)
		return href
	}
}
