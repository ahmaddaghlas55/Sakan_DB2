package org.example.sakan_db.TableClasss;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sakanadmin")  // optional, defaults to class name if omitted
public class Sakanadmin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "adminId") // map to your DB column name
  private long adminId;

  @Column(name = "adminname", nullable = false)
  private String adminname;

  @Column(name = "adminpassword", nullable = false)
  private String adminpassword;

  @Column(name = "adminemail", nullable = false)
  private String adminemail;

  @Column(name = "datecreated")
  private Date datecreated;

  @Column(name = "adminpic")
  private String adminpic;

  // Getters and setters (same as before)
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

  public Date getDatecreated() {
    return datecreated;
  }

  public void setDatecreated(Date datecreated) {
    this.datecreated = datecreated;
  }

  public String getAdminpic() {
    return adminpic;
  }

  public void setAdminpic(String adminpic) {
    this.adminpic = adminpic;
  }
}
