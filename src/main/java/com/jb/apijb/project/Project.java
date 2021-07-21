package com.jb.apijb.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "miniature", nullable = false)
    private String miniature;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "picture_1", nullable = false)
    private String picture1;

    @Column(name = "picture_2", nullable = false)
    private String picture2;

    @Column(name = "picture_3", nullable = false)
    private String picture3;

    @Column(name = "picture_4", nullable = false)
    private String picture4;

    @Column(name = "technologies", nullable = false)
    private String technologies;

    @Column(name = "link")
    private String link;
}
