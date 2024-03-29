package com.jb.apijb.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProjectDTO {

    private long id;
    private String miniature;
    private String name;
    private String date;
    private String description;
    private String picture1;
    private String picture2;
    private String picture3;
    private String picture4;
    private String technologies;
    private String link;
}
