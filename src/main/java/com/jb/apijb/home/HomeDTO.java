package com.jb.apijb.home;

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
public class HomeDTO {

    private long id;
    private String name;
    private String job;
    private String actualJob;
}
