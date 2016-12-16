package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Sviatoslav on 11.12.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Irina", "Me", null, "Me_Ira", "QA", "uTest", "online", "8188267879", "8188267879", "ira@gmail.com", "1985", "Fremont, CA"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }
}

