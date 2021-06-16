package com.jb.apijb.experience;

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
public class ExperienceDTO {

    private long id;
    private String job;
    private String company;
    private String yearStart;
    private String yearEnd;
    private String languages;
    private String description;
}
