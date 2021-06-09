package com.jb.apijb.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "gitlab_url")
    private String gitlabUrl;

    @Column(name = "github_url")
    private String githubUrl;

    public Contact() {}

    public Contact(String address, String phoneNumber, String email, String linkedinUrl, String gitlabUrl, String githubUrl) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.gitlabUrl = gitlabUrl;
        this.githubUrl = githubUrl;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGitlabUrl() {
        return gitlabUrl;
    }

    public void setGitlabUrl(String gitlabUrl) {
        this.gitlabUrl = gitlabUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", address='" + address + "'" +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + "'" +
                ", linkedinUrl='" + linkedinUrl + "'" +
                ", gitlabUrl='" + gitlabUrl + "'" +
                ", githubUrl='" + githubUrl + "'" +
                '}';
    }
}
