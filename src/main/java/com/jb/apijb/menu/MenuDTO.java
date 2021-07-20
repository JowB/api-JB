package com.jb.apijb.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDTO {

    private long id;
    private String item;
    private String link;
}
