/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emart.pojo;

/**
 *
 * @author rajpr
 */
public class Receptionistpojo {

    

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String Empid) {
        this.Empid = Empid;
    }

    public String getEmpname() {
        return Empname;
    }

    public void setEmpname(String Empname) {
        this.Empname = Empname;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    private String Empid;
    private String Empname;
    private String Userid;
    private String Job;
    private double salary;
}
