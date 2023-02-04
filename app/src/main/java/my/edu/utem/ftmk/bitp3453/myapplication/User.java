package my.edu.utem.ftmk.bitp3453.myapplication;

import java.io.Serializable;

public class User implements Serializable {
    String fullName,
        pwd,
        address,
        email,
        birthdate,
        gender;

    public User(String fullName, String pwd, String address, String email, String birthdate, String gender) {
        this.fullName = fullName;
        this.pwd = pwd;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
