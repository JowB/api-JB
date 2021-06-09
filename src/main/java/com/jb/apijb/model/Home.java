package com.jb.apijb.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
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

    public Home() {}

    public Home(String name, String job, String actualJob) {
        this.name = name;
        this.job = job;
        this.actualJob = actualJob;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getActualJob() {
        return actualJob;
    }

    public void setActualJob(String actualJob) {
        this.actualJob = actualJob;
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", job='" + job + "'" +
                ", actualJob='" + actualJob + "'" +
                '}';
    }
}
