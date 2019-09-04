package stepdefs;

import cucumber.api.java.en.*;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.android.nativekey.*;
import org.openqa.selenium.remote.*;
import io.appium.java_client.android.nativekey.KeyEvent;


import java.io.*;
import java.net.*;


public class RBSListStepsDefinitions {


    public AppiumDriver driver ;


    @Given("^I want to open app OI Shopping list$")
    public void iWantToOpenAppOIShoppingList() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f,"org.openintents.shopping.apk");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "org.openintents.shopping");
        cap.setCapability("appActivity", "org.openintents.shopping.ShoppingActivity");
        cap.setCapability("deviceName", "Android");
        cap.setCapability("noReset", true);
        cap.setCapability("automationName", "UIAutomator2");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //return cap;
    }



    @And("^I want to create a list$")
    public void iWantToCreateAList() throws InterruptedException {

        //MyShoppingPage myShoppingPage = new MyShoppingPage(driver);
       // myShoppingPage.navDrawer.click();


         driver.findElementByAccessibilityId("Open navigation drawer").click();
         Thread.sleep(500);
         driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView").click();
         Thread.sleep(500);
         driver.findElementById("edittext").sendKeys("List1");
         Thread.sleep(500);
         driver.findElementById("android:id/button1").click();


    }

    @And("^I want to add items to the list$")
    public void iWantToAddItemsToTheList() {

        driver.findElementById("autocomplete_add_item").sendKeys("Bread");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();
        driver.findElementById("autocomplete_add_item").sendKeys("Milk");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();
        driver.findElementById("autocomplete_add_item").sendKeys("Eggs");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();
        driver.findElementById("autocomplete_add_item").sendKeys("Vegetables");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();

    }


    @Then("^I want to sort the list$")
    public void iWantToSortTheList() throws InterruptedException {

        driver.findElementByAccessibilityId("More options").click();
        Thread.sleep(500);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
        driver.findElementByXPath("hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[2]").click();

        //Navigating Back from sort order to MainMenu//

       ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));



        //cleaning up list1/

        Thread.sleep(500);
        driver.findElementByAccessibilityId("More options").click();
        Thread.sleep(500);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView").click();
        driver.findElementById("android:id/button1").click();

    }



    @And("^I want to create two lists$")
    public void iWantToCreateTwoLists() throws InterruptedException {

        driver.findElementByAccessibilityId("Open navigation drawer").click();
        Thread.sleep(500);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView").click();

        // Creation Of List2//

        Thread.sleep(500);
        driver.findElementById("edittext").sendKeys("List2");
        Thread.sleep(500);
        driver.findElementById("android:id/button1").click();

        driver.findElementByAccessibilityId("Open navigation drawer").click();
        Thread.sleep(500);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView").click();

        //Creation of  list3//

        Thread.sleep(500);
        driver.findElementById("edittext").sendKeys("List3");
        Thread.sleep(500);
        driver.findElementById("android:id/button1").click();


    }

    @And("^I want to Add new list items$")
    public void iWantToAddNewListItems() {

        //Adding items to List3//

        driver.findElementById("autocomplete_add_item").sendKeys("Orange");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();
        driver.findElementById("autocomplete_add_item").sendKeys("Apple");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();
        driver.findElementById("autocomplete_add_item").sendKeys("PineApple");
        driver.findElementById("org.openintents.shopping:id/button_add_item").click();
    }

    @Then("^I want to Delete an item from the list$")
    public void iWantToDeleteAnItemFromTheList() throws InterruptedException {

      driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.CheckBox").click();

      //Deleting an item from the list//

      driver.findElementByAccessibilityId("Clean up list").click();

      //cleaning up list3//

      driver.findElementByAccessibilityId("More options").click();
      Thread.sleep(500);
      driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView").click();
      driver.findElementById("android:id/button1").click();

      //cleaning up list2//

        driver.findElementByAccessibilityId("More options").click();
        Thread.sleep(500);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView").click();
        driver.findElementById("android:id/button1").click();


    }
}
