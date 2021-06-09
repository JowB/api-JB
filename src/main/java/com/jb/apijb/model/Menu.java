package com.jb.apijb.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
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

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNavItem1() {
        return navItem1;
    }

    public void setNavItem1(String navItem1) {
        this.navItem1 = navItem1;
    }

    public String getNavItem2() {
        return navItem2;
    }

    public void setNavItem2(String navItem2) {
        this.navItem2 = navItem2;
    }

    public String getNavItem3() {
        return navItem3;
    }

    public void setNavItem3(String navItem3) {
        this.navItem3 = navItem3;
    }

    public String getNavItem4() {
        return navItem4;
    }

    public void setNavItem4(String navItem4) {
        this.navItem4 = navItem4;
    }

    public String getNavItem5() {
        return navItem5;
    }

    public void setNavItem5(String navItem5) {
        this.navItem5 = navItem5;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + "'" +
                ", navItem1='" + navItem1 + "'" +
                ", navItem2='" + navItem2 + "'" +
                ", navItem3='" + navItem3 + "'" +
                ", navItem4='" + navItem4 + "'" +
                ", navItem5='" + navItem5 + "'" +
                ", linkedinUrl='" + linkedinUrl + "'" +
                ", githubUrl='" + githubUrl + "'" +
                '}';
    }
}
