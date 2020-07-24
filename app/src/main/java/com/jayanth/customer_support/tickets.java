package com.jayanth.customer_support;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class tickets {

    @PrimaryKey
    @NonNull
    String ticket_no;
    @NonNull
    String date;
    String name;
    String email;
    String phone_no;
    @NonNull
    String subject;
    @NonNull
    String description;
    String status;
    String attachment;

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @NonNull
    public String getTicket_no() {
        return ticket_no;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    @NonNull
    public String getSubject() {
        return subject;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String ststus) {
        this.status = ststus;
    }

    public void setTicket_no(@NonNull String ticket_no) {
        this.ticket_no = ticket_no;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setSubject(@NonNull String subject) {
        this.subject = subject;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
