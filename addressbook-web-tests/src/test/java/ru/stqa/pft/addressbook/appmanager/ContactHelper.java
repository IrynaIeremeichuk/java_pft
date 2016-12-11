package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Sviatoslav on 10.12.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
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
  }
  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void editContact() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void submitContactModification() {
    click(By.name("update"));
  }

}
