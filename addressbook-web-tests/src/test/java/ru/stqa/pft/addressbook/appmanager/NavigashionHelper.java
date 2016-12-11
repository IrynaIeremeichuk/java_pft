package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sviatoslav on 10.12.2016.
 */
public class NavigashionHelper {
  private FirefoxDriver wd;

  public NavigashionHelper(FirefoxDriver wd) {
    this.wd=wd;
  }

  public void gotoGroupPage() {

    wd.findElement(By.linkText("groups")).click();
  }
}
