package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact())
      app.getContactHelper().createContact(new ContactData("Ira", "Me", "test1", "Me_Ira", "QA", "uTest", "online", "8188267879", "8188267879", "ira@gmail.com", "1985", "Fremont, CA"), true);
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmContactDeletion();
    app.getContactHelper().returnToHomePage();
  }

}
