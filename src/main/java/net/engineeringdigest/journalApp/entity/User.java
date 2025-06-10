package net.engineeringdigest.journalApp.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("users")
public class User {

    public User(ObjectId id, @NonNull String userName, String email, boolean sentimentalAnalysis, @NonNull String password, List<JournalEntry> journalEntries, List<String> roles) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.sentimentalAnalysis = sentimentalAnalysis;
        this.password = password;
        this.journalEntries = journalEntries;
        this.roles = roles;
    }

    public User() {
    }
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    private String email;
    private boolean sentimentalAnalysis;
    @NonNull
    private String password;
    @DBRef
    private List<JournalEntry> journalEntries=new ArrayList<>();

    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", journalEntries=" + journalEntries +
                '}';
    }
}
