package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sviatoslav on 10.12.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.cssSelector("input[value = 'Enter']"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("work"), contactData.getWorkphone());
    type(By.name("email"), contactData.getEmail());
    click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
    click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    type(By.name("byear"), contactData.getByear());
    type(By.name("address2"), contactData.getAddress2());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }


  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void confirmContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contactData, boolean contact) {
    initContactCreation();
    fillContactForm(contactData, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void modifyContact(ContactData contact, int index) {
    editContact(index);
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    confirmContactDeletion();
    returnToHomePage();
  }

  public void returnToHomePage() {

    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
      }

    public int getContactCount() {
      return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
      List<ContactData> contacts = new ArrayList<ContactData>();
      List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
      for(WebElement element: elements) {
        List<WebElement> cells = element.findElements(By.cssSelector("td"));
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        String firstname = cells.get(2).getText();
        String lastname = cells.get(1).getText();
        ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
        contacts.add(contact);
    }
    return contacts;
  }
}


