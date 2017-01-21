package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sviatoslav on 20.01.2017.
 */
public class ContactDetailesTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Ira").withLastname("Me").withAddress("US").
              withHomephone("1234567895").withMobilephone("8188267879").withWorkphone("8188267879").
              withEmail("ira@gmail.com"), true);
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForms = app.contact().infoFromEditForm(contact);
    String contactDetailes = app.contact().contactDetailes(contact);

    assertThat(contactDetailes, equalTo(mergeInfo(contactInfoFromEditForms)));
  }

  private String mergeInfo(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),contact.getHomephone(),
            contact.getMobilephone(), contact.getWorkphone(),contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream().
            filter((s) -> !s.equals("")).map(ContactDetailesTests::cleaned).collect(Collectors.joining());
  }

  public static String cleaned(String detailes){
    return detailes.replaceAll("\\s", "");
  }

}
