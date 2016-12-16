package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Ira", "Me", "test1", "Me_Ira", "QA", "uTest", "online", "8188267879", "8188267879", "ira@gmail.com", "1985", "Fremont, CA"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }

}
