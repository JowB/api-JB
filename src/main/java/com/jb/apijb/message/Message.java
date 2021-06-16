package com.jb.apijb.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@ToString
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "content")
    private String content;

    public Message() {
    }

    public Message(String email, String content) {
        this.email = email;
        this.content = content;
    }
}
