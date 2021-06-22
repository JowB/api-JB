package com.jb.apijb.home;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HomeDTO {
    private long id;
    private String name;
    private String job;
    private String actualJob;
}
