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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "link", nullable = false)
    private String link;
}
