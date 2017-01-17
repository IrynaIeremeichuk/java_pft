package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Sviatoslav on 11.12.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Ira").withLastname("Me").withGroup("test1").withNickname("Me_Ira").withTitle("QA").
              withCompany("uTest").withAddress("online").withMobilephone("8188267879").withWorkphone("8188267879").withEmail("ira@gmail.com").
              withByear("1985").withAddress2("Fremont, CA"), true);
    }
  }

  @Test

  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Irina").withLastname("Ieremeichuk");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}

