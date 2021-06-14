package com.jb.apijb.menu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "menu")
@ToString
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "nav_item_1")
    private String navItem1;

    @Column(name = "nav_item_2")
    private String navItem2;

    @Column(name = "nav_item3")
    private String navItem3;

    @Column(name = "nav_item_4")
    private String navItem4;

    @Column(name = "nav_item_5")
    private String navItem5;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "github_url")
    private String githubUrl;

    public Menu() {}

    public Menu(String title, String navItem1, String navItem2, String navItem3, String navItem4, String navItem5, String linkedinUrl, String githubUrl) {
        this.title = title;
        this.navItem1 = navItem1;
        this.navItem2 = navItem2;
        this.navItem3 = navItem3;
        this.navItem4 = navItem4;
        this.navItem5 = navItem5;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
    }
}
