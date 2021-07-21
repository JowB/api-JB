package com.jb.apijb.study;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "studies")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "logo", nullable = false)
    private String logo;

    @Column(name = "diploma", nullable = false)
    private String diploma;

    @Column(name = "second_diploma")
    private String secondDiploma;
}
