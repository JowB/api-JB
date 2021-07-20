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

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "year_start", nullable = false)
    private String yearStart;

    @Column(name = "year_end", nullable = false)
    private String yearEnd;

    @Column(name = "languages", nullable = false)
    private String languages;

    @Column(name = "description", nullable = false)
    private String description;
}
