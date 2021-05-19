package com.example.pointofsale.entities;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "\"User\"")
public class User extends BaseEntity {

    @NotEmpty
    @Size(min = 10)
    private String salt;
    @NaturalId
    @NotBlank
    @Size(min = 5)
    private String username;
    @NotBlank
    private String passwordHash;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String defaultTimeZone;


    public User(String username, String password, String firstName, String lastName) {
        super();
        this.username = username;
        this.salt = RandomStringUtils.random(RandomUtils.nextInt(10, 20));
        this.passwordHash = hashPassword(password, this.salt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.defaultTimeZone = "UTC";

    }

    public User() {
        this.salt = RandomStringUtils.random(RandomUtils.nextInt(10, 20));
        this.defaultTimeZone = "UTC";
    }

    public User(int id) {
        setId(id);
        this.defaultTimeZone = "Wack";
    }


    public boolean validCredentials(String proposedPassword) {
        return comparePasswords(proposedPassword, this.passwordHash);
    }

    private String hashPassword(String password, String salt) {
        return DigestUtils.sha256Hex(password + salt);
    }

    private boolean comparePasswords(String password, String passwordHash) {
        return hashPassword(password, this.salt).equals(passwordHash);
    }

    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public void setDefaultTimeZone(String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.passwordHash = hashPassword(password, this.salt);
    }
}