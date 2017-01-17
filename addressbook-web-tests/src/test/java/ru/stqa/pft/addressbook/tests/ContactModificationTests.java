package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

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

    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withId(before.get(before.size() - 1).getId()).withFirstname("Irina").withLastname("Ieremeichuk");
    int index = before.size() - 1;
    app.contact().modifyContact(contact, index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}

