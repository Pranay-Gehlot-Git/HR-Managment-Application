package com.thinking.machines.hr.dl;
import java.util.*;
import java.math.*;


public class EmployeeDTO implements java.io.Serializable, Comparable<EmployeeDTO> {
    
    private String id;
    private String name;
    private String title;
    private int designationCode;
    private Date dateOfBirth;
    private String city;
    private String panNumber;
    private String aadharNumber;

    public EmployeeDTO() {
        this.id="";
        this.name="";
        this.title="";
        this.designationCode=0;
        this.city="";
        this.dateOfBirth=null;
        this.panNumber="";
        this.aadharNumber="";
     }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDesignationCode() {
        return this.designationCode;
    }

    public void setDesignationCode(int designationCode) {
        this.designationCode = designationCode;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPanNumber() {
        return this.panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadharNumber() {
        return this.aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int hashCode()
    {
        return id.hashCode();
    }
    public boolean equals(Object object)
    {
        if(!(object instanceof EmployeeDTO)) return false;
        EmployeeDTO employee=(EmployeeDTO)object;
        return this.id.equalsIgnoreCase(employee.id);
    }
    public int compareTo(EmployeeDTO employee)
    {
        return this.id.compareTo(employee.id);
    }
}