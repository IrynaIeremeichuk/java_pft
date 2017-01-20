package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sviatoslav on 20.01.2017.
 */
public class ContactAddressTests extends TestBase  {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().all().size() == 0)
      app.contact().create(new ContactData().withFirstname("Ira").withLastname("Me").withGroup("test1").
              withNickname("Me_Ira").withTitle("QA").withCompany("uTest").withAddress("online").
              withHomephone("1234567895").withMobilephone("8188267879").withWorkphone("8188267879").
              withEmail("ira@gmail.com").withEmail2("ieremira@gmail.com").withEmail3("other@mail.ru").
              withByear("1985").withAddress2("Fremont, CA"), true);
  }

  @Test
  public void testContactAddress(){
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForms = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForms.getAddress()));
  }
}
