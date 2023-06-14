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
import org.openqa.selenium.Cookie as Cookie
import groovy.json.JsonOutput

WebUI.openBrowser('')

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), 'Admin')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Login'))

String pageTitle = WebUI.getText(findTestObject('Object Repository/Page_OrangeHRM/h6_Dashboard'))

// Get the current browser driver
def driver = DriverFactory.getWebDriver()

// Store username and password in cookies
//def usernameCookie = new Cookie('username', 'Admin')
//
//def passwordCookie = new Cookie('password', 'hUKwJTbofgPU9eVlw/CnDQ==')

println('cookies size:: before insert ' + driver.manage().getCookies().size())

//driver.manage().addCookie(usernameCookie)
//
//driver.manage().addCookie(passwordCookie)

println('cookies size:: after insert ' + driver.manage().getCookies().size())
File file = new File("S:/katalon/API_Testing/TEST/output.json")

//Set<Cookie> value = driver.manage().getCookies()
driver.manage().getCookies().each { cookie ->
	println("cookies domain:: "+cookie.domain)
	println("cookies name:: " +cookie.name)

	println("cookie.isSecure :: "+cookie.isSecure)
 }
 def jsonCookie = JsonOutput.toJson(driver.manage().getCookies())
 file.write(jsonCookie)

println('Page Title: ' + pageTitle)
WebUI.deleteAllCookies()
println('cookies size:: after delete ' + driver.manage().getCookies().size())
// Delete the specific cookie
//def domain = "example.com"
//def cookieName = "username"
//

WebUI.closeBrowser()

