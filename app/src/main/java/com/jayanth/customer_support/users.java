package com.jayanth.customer_support;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class users {

    @PrimaryKey
    @NonNull
    private String login_id;
    @NonNull
    private String pswd;
    private String first_name;
    private String last_name;
    private String phone_no;
    private String email_id;
    private String address;

    @NonNull
    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(@NonNull String login_id) {
        this.login_id = login_id;
    }

    @NonNull
    public String getPswd() {
        return pswd;
    }

    public void setPswd(@NonNull String pswd) {
        this.pswd = pswd;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name( String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
