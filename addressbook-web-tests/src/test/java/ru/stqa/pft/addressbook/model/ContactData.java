package ru.stqa.pft.addressbook.model;

public class ContactData {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String firstname;
  private final String lastname;
  private String group;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String mobilephone;
  private final String workphone;
  private final String email;
  private final String byear;
  private final String address2;

  public ContactData(int id, String firstname, String lastname, String group, String nickname, String title, String company, String address, String mobilephone, String workphone, String email, String byear, String address2) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.email = email;
    this.byear = byear;
    this.address2 = address2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public ContactData(String firstname, String lastname, String group, String nickname, String title, String company, String address, String mobilephone, String workphone, String email, String byear, String address2) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.group = group;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.email = email;
    this.byear = byear;
    this.address2 = address2;
  }
  public int getId() {  return id; }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
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

  public String getWorkphone() {
    return workphone;
  }

  public String getEmail() {
    return email;
  }

  public String getByear() {
    return byear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getGroup() {
    return group;
  }


}
