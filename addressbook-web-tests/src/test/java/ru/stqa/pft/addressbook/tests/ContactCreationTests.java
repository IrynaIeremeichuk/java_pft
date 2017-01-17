package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().HomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Ira").withLastname("Me").withGroup("test1").withNickname("Me_Ira").withTitle("QA").
            withCompany("uTest").withAddress("online").withMobilephone("8188267879").withWorkphone("8188267879").withEmail("ira@gmail.com").
            withByear("1985").withAddress2("Fremont, CA");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()+1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

 }
