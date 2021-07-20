package com.jb.apijb.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MessageDTO {

    private long id;
    private String email;
    private String content;
}
