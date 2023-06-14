import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt')

WebUI.click(findTestObject('Object Repository/Page_W3Schools Tryit Editor/button_Try it'))

WebUI.verifyAlertPresent(2)

WebUI.delay(2)

AlertText = WebUI.getAlertText()

println(AlertText)

WebUI.setAlertText('SagarSunar')

WebUI.click(findTestObject('Alerts/button_ClickHere'))

def driver = DriverFactory.getWebDriver()

'Passing the text in the text box in the Alert\r\n'
driver.switchTo().alert().sendKeys('Testing')

WebUI.takeFullPageScreenshot()

WebUI.delay(2)

WebUI.acceptAlert()

WebUI.delay(2)

WebUI.closeBrowser()

