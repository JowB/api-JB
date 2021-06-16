package com.jb.apijb.experience;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "experiences")
@ToString
@Getter
@Setter
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "job")
    private String job;

    @Column(name = "company")
    private String company;

    @Column(name = "year_start")
    private String yearStart;

    @Column(name = "year_end")
    private String yearEnd;

    @Column(name = "languages")
    private String languages;

    @Column(name = "description")
    private String description;

    public Experience() {
    }

    public Experience(String job, String company, String yearStart, String yearEnd, String languages, String description) {
        this.job = job;
        this.company = company;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.languages = languages;
        this.description = description;
    }
}
