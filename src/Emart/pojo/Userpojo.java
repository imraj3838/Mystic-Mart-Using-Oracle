
package Emart.pojo;


public class Userpojo {

    @Override
    public String toString() {
        return "Userpojo{" + "userid=" + userid + ", password=" + password + ", usertype=" + usertype + ", empid=" + empid + ", username=" + username + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
private String userid;
private String password;
private String usertype;
private String empid;
private String username;

}