package sample;


import java.io.InputStream;

public class Account {
    private String name;

    private int  schoolID;

    private String account;

    private String password;

    private String email;

    private boolean vip;

    private String phoneNumber;

    private InputStream picture;

    public Account(String name, int schoolID, String account, String password, boolean vip, String phoneNumber, InputStream picture, String email) {
        this.name = name;
        this.schoolID = schoolID;
        this.account = account;
        this.password = password;
        this.vip = vip;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }
}
