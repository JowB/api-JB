package com.jb.apijb.home;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "home")
@ToString
@Getter
@Setter
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "job")
    private String job;

    @Column(name = "actual_job")
    private String actualJob;

    @Column(name = "user_id")
    private int userId;

    public Home() {}

    public Home(String name, String job, String actualJob, int userId) {
        this.name = name;
        this.job = job;
        this.actualJob = actualJob;
        this.userId = userId;
    }
}
