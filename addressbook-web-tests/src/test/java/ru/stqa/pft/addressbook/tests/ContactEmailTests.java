package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Sviatoslav on 19.01.2017.
 */
public class ContactEmailTests extends TestBase {

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
  public void testContactEmails(){
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForms = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllemails(), equalTo(mergeEmails(contactInfoFromEditForms)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3()).stream().
            filter((s) ->!s.equals("")).collect(Collectors.joining("\n"));
  }
}
