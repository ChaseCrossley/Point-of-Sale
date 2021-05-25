package com.example.pointofsale.entities;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "\"User\"", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User extends BaseEntity {

    @Size(min = 10)
    private String salt;
    @Size(min = 5)
    private String username;
    @NotBlank
    private String passwordHash;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public User() {
        setSalt(RandomStringUtils.random(RandomUtils.nextInt(10, 20)));
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = hashPassword(password, salt);
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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