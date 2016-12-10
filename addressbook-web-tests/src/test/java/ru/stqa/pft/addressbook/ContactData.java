package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String mobilephone;
  private final String email1;
  private final String year;
  private final String address2;

  public ContactData(String FirstName, String LastName, String Nickname, String title, String company, String address, String mobilephone, String email1, String year, String address2) {
    firstName = FirstName;
    lastName = LastName;
    nickname = Nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mobilephone = mobilephone;
    this.email1 = email1;
    this.year = year;
    this.address2 = address2;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail1() {
    return email1;
  }

  public String getYear() {
    return year;
  }

  public String getAddress2() {
    return address2;
  }
}
