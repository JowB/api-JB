package com.jb.apijb.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class MenuDTO {

    private long id;
    private String title;
    private String navItem1;
    private String navItem2;
    private String navItem3;
    private String navItem4;
    private String navItem5;
    private String linkedinUrl;
    private String githubUrl;
}
