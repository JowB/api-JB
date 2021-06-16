package com.jb.apijb.project;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@ToString
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "miniature")
    private String miniature;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "description")
    private String description;

    @Column(name = "picture_1")
    private String picture1;

    @Column(name = "picture_2")
    private String picture2;

    @Column(name = "picture_3")
    private String picture3;

    @Column(name = "picture_4")
    private String picture4;

    @Column(name = "technologies")
    private String technologies;

    public Project() {
    }

    public Project(String miniature, String name, String date, String description, String picture1, String picture2, String picture3, String picture4, String technologies) {
        this.miniature = miniature;
        this.name = name;
        this.date = date;
        this.description = description;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.picture4 = picture4;
        this.technologies = technologies;
    }
}
