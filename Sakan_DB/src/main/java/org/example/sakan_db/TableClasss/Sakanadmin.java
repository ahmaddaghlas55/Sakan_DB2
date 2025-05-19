package org.example.sakan_db.TableClasss;


public class Sakanadmin {

  private long adminId;
  private String adminname;
  private String adminpassword;
  private String adminemail;
  private java.sql.Date datecreated;
  private String adminpic;


  public long getAdminId() {
    return adminId;
  }

  public void setAdminId(long adminId) {
    this.adminId = adminId;
  }


  public String getAdminname() {
    return adminname;
  }

  public void setAdminname(String adminname) {
    this.adminname = adminname;
  }


  public String getAdminpassword() {
    return adminpassword;
  }

  public void setAdminpassword(String adminpassword) {
    this.adminpassword = adminpassword;
  }


  public String getAdminemail() {
    return adminemail;
  }

  public void setAdminemail(String adminemail) {
    this.adminemail = adminemail;
  }


  public java.sql.Date getDatecreated() {
    return datecreated;
  }

  public void setDatecreated(java.sql.Date datecreated) {
    this.datecreated = datecreated;
  }


  public String getAdminpic() {
    return adminpic;
  }

  public void setAdminpic(String adminpic) {
    this.adminpic = adminpic;
  }

}
