package com.jb.apijb.study;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class StudyDTO {

    private long id;
    private String year;
    private String logo;
    private String diploma;
    private String secondDiploma;
}
