package com.jb.apijb.contact;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@ToString
@Getter
@Setter
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
}
