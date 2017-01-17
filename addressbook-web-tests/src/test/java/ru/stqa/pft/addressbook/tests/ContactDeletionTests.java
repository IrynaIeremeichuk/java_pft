package ru.stqa.pft.addressbook.tests;

import javafx.scene.effect.SepiaTone;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size() == 0)
      app.contact().create(new ContactData().withFirstname("Ira").withLastname("Me").withGroup("test1").withNickname("Me_Ira").withTitle("QA").
              withCompany("uTest").withAddress("online").withMobilephone("8188267879").withWorkphone("8188267879").withEmail("ira@gmail.com").
              withByear("1985").withAddress2("Fremont, CA"), true);
  }

  @Test
  public void testContactDeletion() {

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);

  }
}
